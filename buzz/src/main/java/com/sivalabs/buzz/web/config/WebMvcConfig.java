/**
 * 
 */
package com.sivalabs.buzz.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Siva
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		super.addViewControllers(registry);
		registry.addViewController("/").setViewName("userLayout");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/admin").setViewName("admin/adminLayout");
		
		
	}
}
