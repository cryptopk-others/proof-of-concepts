/**
 * 
 */
package com.sivalabs.ebuddy.rest.endpoints;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.ebuddy.entities.User;
import com.sivalabs.ebuddy.services.UserService;
import com.sivalabs.ebuddy.utils.Constants;
import com.sivalabs.ebuddy.web.model.AjaxResponse;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/users")
public class UserRestController 
{
	private static final String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.APP_DATE_FORMAT);
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId) 
	{
		User user = userService.findUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<User> authenticate(@RequestHeader("email") String email, @RequestHeader("password") String password) 
	{
		User user = userService.login(email, password);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=JSON_TYPE)
	public ResponseEntity<AjaxResponse<List<User>>> findAllUsers() 
	{
		List<User> users = userService.findAllUsers();
		AjaxResponse<List<User>> resp = new AjaxResponse<>();
		resp.setData(users);
		ResponseEntity<AjaxResponse<List<User>>> responseEntity = new ResponseEntity<>(resp, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, produces=JSON_TYPE)
	public ResponseEntity<AjaxResponse<Void>> createUser(@RequestBody User user, BindingResult errors) 
	{
		userService.createUser(user);
		ResponseEntity<AjaxResponse<Void>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
}
