/**
 * 
 */
package com.sivalabs.buzz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Siva
 *
 */
@Controller
public class CommonController
{
	@RequestMapping("/static")
	public String staticPage(@RequestParam("page")String page)
	{
		return page;
	}
}
