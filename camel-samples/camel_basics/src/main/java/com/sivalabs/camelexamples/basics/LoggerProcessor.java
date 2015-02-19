/**
 * 
 */
package com.sivalabs.camelexamples.basics;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author skatam
 *
 */
public class LoggerProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.err.println("LoggerProcessor :: "+exchange.getIn().getHeader("CamelFileName"));
	}

}
