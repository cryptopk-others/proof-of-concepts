/**
 * 
 */
package com.sivalabs.springmvc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
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

@Controller
class HomePageController
{
	@RequestMapping("/")
	public String welcome() {
		return "index.html";
	}
}
