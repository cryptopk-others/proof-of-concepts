/**
 * 
 */
package com.sivalabs.tasktracker.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author katsi02
 *
 */
public class SpringApplicationContext implements ApplicationContextAware 
{
	private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;		
	}
	
	public static <T> T getBean(Class<T> type) 
	{
		return ctx.getBean(type);
	}

	public static <T> T getBean(String beanId, Class<T> type) 
	{
		return ctx.getBean(beanId, type);
	}
	
}
