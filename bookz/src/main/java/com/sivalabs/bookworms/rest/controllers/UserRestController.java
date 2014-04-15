package com.sivalabs.bookworms.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.bookworms.entities.User;
import com.sivalabs.bookworms.model.GenericResponse;
import com.sivalabs.bookworms.services.UserService;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(value = "/users/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends BaseController
{
	@Autowired
	private UserService userService;
	

	@ResponseBody
	@RequestMapping(value = "/")
	public ResponseEntity<GenericResponse<List<User>>> listUsers()
	{
		List<User> users = userService.findAllUsers();
		GenericResponse<List<User>> response = new GenericResponse<>();
		response.setData(users);
		return new ResponseEntity<GenericResponse<List<User>>>(response, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{userId}")
	public ResponseEntity<GenericResponse<User>> findUser(@PathVariable("userId") int userId)
	{
		User user = userService.findUserById(userId);
		GenericResponse<User> response = new GenericResponse<>();
		response.setData(user);
		return new ResponseEntity<GenericResponse<User>>(response, HttpStatus.OK);
	}
}
