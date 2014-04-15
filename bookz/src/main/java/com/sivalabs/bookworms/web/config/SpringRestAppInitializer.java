package com.sivalabs.bookworms.web.config;

import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
//import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Siva
 * 
 */
public class SpringRestAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class<?>[] {/* AppConfig.class*/};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[] { RepositoryRestMvcConfiguration.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		
		return new String[] { "/rest/*" };
	}
	@Override
	protected String getServletName() {
		return "spring-rest";
	}
	/*@Override
    protected Filter[] getServletFilters() {
       return new Filter[]{new OpenEntityManagerInViewFilter()};
    } */
	

}
