package com.sivalabs.extjsdemo.web.rest.endpoints;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.extjsdemo.entities.User;
import com.sivalabs.extjsdemo.services.MockDataProvider;
import com.sivalabs.extjsdemo.services.UserService;
import com.sivalabs.extjsdemo.web.rest.model.DataGrid;
import com.sivalabs.extjsdemo.web.rest.model.UsersResource;

/**
 * @author Siva
 *
 */
@Controller
public class UserEndpoint
{
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/users", produces={APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public ResponseEntity<UsersResource> findAllUsers()
	{
		return new ResponseEntity<UsersResource>(new UsersResource(userService.findAllUsers()), HttpStatus.ACCEPTED);
	}
	
	@ResponseBody
	@RequestMapping(value="/searchUsers", produces={APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public ResponseEntity<UsersResource> searchUsers(@RequestParam(value="query", defaultValue="") String searchQuery)
	{
		return new ResponseEntity<UsersResource>(new UsersResource(userService.searchUsers(searchQuery)), HttpStatus.ACCEPTED);
	}
	
	@ResponseBody
	@RequestMapping(value="/users/{id}", produces={APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public User findUser(@PathVariable("id") int id)
	{
		return userService.findUser(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getUsersJSON", produces={APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public ResponseEntity<DataGrid> getUsersJSON(@RequestParam(value="query", defaultValue="") String searchQuery)
	{
		return new ResponseEntity<DataGrid>(MockDataProvider.getUsersDataGrid(), HttpStatus.ACCEPTED);
	}
}
