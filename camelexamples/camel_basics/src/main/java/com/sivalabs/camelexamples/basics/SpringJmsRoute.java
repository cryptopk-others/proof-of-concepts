/**
 * 
 */
package com.sivalabs.camelexamples.basics;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author skatam
 *
 */
public class SpringJmsRoute extends RouteBuilder 
{
	public static void main(String[] args) throws Exception 
	{
		new ClassPathXmlApplicationContext("spring-camel-context.xml");
		Thread.sleep(100000);
	}
	
	public void configure() 
	{
		from("file:D:/misc/data/inbox")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				System.err.println(exchange.getIn().getHeader("CamelFileName"));
			}
		})
		.to("jms:queue:incomingOrders");
	}
}