package com.sivalabs.springmvc.rest.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.springmvc.entities.Contact;
import com.sivalabs.springmvc.entities.User;
import com.sivalabs.springmvc.services.UserService;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/{userId}")
	@ResponseBody
	public User getUsers(@PathVariable("userId") int userId) {
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/{userId}/contacts")
	@ResponseBody
	public HttpEntity<List<Contact>> getContacts(@PathVariable("userId") int userId) {
		List<Contact> contacts = userService.findUserContacts(userId);
		return new HttpEntity<List<Contact>>(contacts);
	}
	
	@RequestMapping(value="/{userId}/contacts/{contactId}")
	@ResponseBody
	public HttpEntity<Contact> getContact(@PathVariable("userId") int userId, @PathVariable("contactId") int contactId) {
		Contact contact = userService.findUserContact(userId, contactId);
		return new HttpEntity<Contact>(contact);
	}
	
}
