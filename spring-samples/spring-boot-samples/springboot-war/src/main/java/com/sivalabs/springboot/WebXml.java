/**
 * 
 */
package com.sivalabs.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author skatam
 *
 */
public class WebXml extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
