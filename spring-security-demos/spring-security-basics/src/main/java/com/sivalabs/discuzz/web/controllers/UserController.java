package com.sivalabs.discuzz.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.discuzz.core.entities.User;
import com.sivalabs.discuzz.core.security.UserContext;
import com.sivalabs.discuzz.core.services.UserService;

/**
 * @author Siva
 * 
 */
@Controller
public class UserController
{
	@Autowired private UserContext userContext;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@Autowired
	private UserService userService;
	
	/*
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
	*/
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleRegistration(@ModelAttribute("user") User user, BindingResult errors, Model model, RedirectAttributes redirectAttributes)
	{
		if (errors.hasErrors()) {
			return "register";
		}
		try {
			userService.createUser(user);
			userContext.setCurrentUser(user);
			redirectAttributes.addFlashAttribute("msg", "You have registered successfully");
			return "redirect:welcome";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
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
	
	/*
	public static User getCurrentUser() {

	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    if (principal instanceof SecurityUser) {
	    	return ((SecurityUser) principal).getDomainUser();
	    }

	    return null;
	}
	
	public static boolean isLoggedIn() {
	    return getCurrentUser() != null;
	}
	*/
}
