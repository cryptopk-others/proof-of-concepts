package com.sivalabs.tasktracker.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.tasktracker.entities.User;
import com.sivalabs.tasktracker.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(value="/users/", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired private UserRepository userRepository;

	@InitBinder
	private void dataBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value="{userId}")
	public User getUsers(@PathVariable("userId") int userId) {
		return userRepository.findOne(userId);
	}
	

	
}
