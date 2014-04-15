/**
 * 
 */
package com.sivalabs.camelexamples.basics;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author skatam
 * 
 */
public class FileCopierWithCamel 
{
	public static void main(String args[]) throws Exception 
	{
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:D:/misc/data/inbox").to("file:D:/misc/data/outbox");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}
