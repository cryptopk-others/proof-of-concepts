/**
 * 
 */
package com.sivalabs.extjsdemo.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Siva
 * 
 */
@Controller
public class PageController
{

	@RequestMapping(value = "view")
	public String showPage(@RequestParam(value = "scripts", defaultValue = "dummy") String scriptFiles, Model model)
	{
		List<String> scripts = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(scriptFiles, ",");
		while (st.hasMoreTokens()) {
			scripts.add(st.nextToken().trim());
		}
		model.addAttribute("scripts", scripts);
		return "template";
	}
}
