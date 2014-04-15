package com.sivalabs.discuzz.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.discuzz.entities.User;
import com.sivalabs.discuzz.rest.model.AjaxResponse;
import com.sivalabs.discuzz.rest.model.AjaxResponseBuilder;
import com.sivalabs.discuzz.services.UserService;

/**
 * @author Siva
 * 
 */
@Controller
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("user") User user, BindingResult errors, Model model)
	{
		if (errors.hasErrors()) {
			return "login";
		}
		try {
			User loginUser = userService.login(user.getEmail(), user.getPassword());
			if(loginUser != null){
				return "redirect:welcome";
			} else {
				model.addAttribute("ERROR", "Invalid Email and Password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "login";
		}
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@ModelAttribute("user") User user, BindingResult errors, Model model,RedirectAttributes redirectAttributes)
	{
		if (errors.hasErrors()) {
			return "register";
		}
		try {
			userService.createUser(user);
			redirectAttributes.addFlashAttribute("msg", "You have registered successfully");
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR", e.getMessage());
			return "register";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes)
	{
		session.invalidate();
		redirectAttributes.addFlashAttribute("msg", "You have been logged out.");
		return "redirect:login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkEmailExists", produces = "application/json")
	public AjaxResponse<Void> checkEmailExists(@RequestParam("email") String email)
	{
		boolean exists = userService.checkEmailExists(email);
		if (exists) {
			return new AjaxResponseBuilder<Void>().notOk().error("Email [" + email + "] already exist").build();
		} else {
			return new AjaxResponseBuilder<Void>().ok().build();
		}
	}
}
