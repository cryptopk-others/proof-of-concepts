/**
 * 
 */
package com.sivalabs.camelexamples.basics;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author skatam
 * 
 */
public class CamelRouting 
{
	public static void main(String args[]) throws Exception 
	{
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:D:/misc/data/inbox")
				/*
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						System.err.println(exchange.getIn().getHeader("CamelFileName"));
					}
				})
				*/
				.to("jms:queue:incomingOrders");
				
				from("jms:queue:incomingOrders")
				.wireTap("jms:orderAudit")
				.choice()
					.when(header("CamelFileName").endsWith(".xml")).to("jms:xmlOrders")
					.when(header("CamelFileName").regex("^.*(csv|csl)$")).to("jms:csvOrders")
					.otherwise().to("jms:badOrders").stop()
				.end()
				.to("jms:continuedProcessing");
				
				/*from("jms:xmlOrders")
					.multicast().stopOnException().parallelProcessing()
					.to("jms:accounting", "jms:production");*/
				
				from("jms:xmlOrders")
				.setHeader("customer", xpath("/order/@customer"))
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						String recipients = "jms:accounting";
						String customer = exchange.getIn().getHeader("customer", String.class);
						System.err.println("King is : "+customer);
						if (customer.equals("amazon")) {
							recipients += ",jms:production";
						}
						exchange.getIn().setHeader("recipients", recipients);
					}
				})
				.recipientList(header("recipients"));
				
				
				
				from("jms:xmlOrders")
					.filter(xpath("/order[not(@test)]"))
					.process(new FileNameLoggingProcessor("Received XML order:")); 
				
				
				from("jms:csvOrders").process(new FileNameLoggingProcessor("Received CSV order:")); 
				
				from("jms:badOrders").process(new FileNameLoggingProcessor("Received BAD order:")); 
				
				from("jms:continuedProcessing").process(new FileNameLoggingProcessor("Received Generic order:")); 
				
				from("jms:accounting").process(new FileNameLoggingProcessor("Received Accounting order:")); 
				from("jms:production").process(new FileNameLoggingProcessor("Received Production order:"));
				
				from("jms:orderAudit").process(new FileNameLoggingProcessor("Received WireTap orderAudit:"));
				
			}
		});
		
		context.start();
		Thread.sleep(100000);
		context.stop();
	}
}


class FileNameLoggingProcessor implements Processor
{
	String prefix = "Received ";
	public FileNameLoggingProcessor(String prefix) {
		this.prefix = prefix;
	}
	@Override
	public void process(Exchange exchange) throws Exception {
		System.err.println(prefix + exchange.getIn().getHeader("CamelFileName"));
	}
}
