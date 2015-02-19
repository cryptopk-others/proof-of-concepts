package sivalabs.app.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.http.MediaType.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sivalabs.app.entities.Group;
import sivalabs.app.entities.User;
import sivalabs.app.services.UserService;
import sivalabs.app.web.viewmodels.UserModel;
import sivalabs.app.web.viewmodels.UsersModel;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(produces=APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value="login", method=POST)
	public Map<String,String> login(@RequestBody User user) {
		Map<String, String> respMap = new HashMap<>();
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}*/
		try {
			User loginUser = userService.login(user.getUserName(), user.getPassword());
			
			
			if(loginUser != null){
				respMap.put("success", "true");
				respMap.put("msg", "User authenticated!");
			}else {
				respMap.put("success", "false");
				respMap.put("msg", "Incorrect user or password.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			respMap.put("success", "false");
			respMap.put("msg", e.getMessage());
		}
		
		return respMap ;
	}
	
	@RequestMapping(value="logout")
	public Map<String,String> logout(HttpSession session) {
		session.invalidate();
		Map<String, String> respMap = new HashMap<>();
		respMap.put("success", "true");
		respMap.put("msg", "User logged out!");
		return respMap ;
	}
	
	@RequestMapping(value="sessionAlive")
	public Map<String,String> sessionAlive(HttpSession session) {
		System.err.println("sessionAlive : "+session.getId());
		Map<String, String> respMap = new HashMap<>();
		respMap.put("success", "true");
		respMap.put("msg", "User session extended!");
		return respMap ;
	}
	
	@RequestMapping(value="security/users")
	public UsersModel findAllUsers(HttpSession session) {
		UsersModel usersModel = new UsersModel(userService.findAllUsers());
		return usersModel ;
	}
	
	@RequestMapping(value="security/saveUser", method=POST)
	public Map<String,String> saveUser(UserModel userModel, BindingResult result) 
	{
		Map<String, String> respMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		if (result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
                sb.append(error.getDefaultMessage()+"\n");
            }
             
            respMap.put("success", "false");
			respMap.put("msg", sb.toString());
             
            return respMap;
        }
		try {
			User user = new User();
			user.setName(userModel.getName());
			user.setUserName(userModel.getUserName());
			user.setPassword("password");
			user.setEmail(userModel.getEmail());
			user.setGroup(new Group(userModel.getGroupId()));
			
			User loginUser = userService.saveUser(user);
			
			
			if(loginUser != null){
				respMap.put("success", "true");
				respMap.put("msg", "User Saved!");
			}else {
				respMap.put("success", "false");
				respMap.put("msg", "Failed to save.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			respMap.put("success", "false");
			respMap.put("msg", e.getMessage());
		}
		
		return respMap ;
	}
	
	@RequestMapping(value="security/deleteUser")
	public Map<String,String> deleteUser(@RequestParam("id") int userId) {
		Map<String, String> respMap = new HashMap<>();
		
		try {
				userService.deleteUser(userId);
				respMap.put("success", "true");
				respMap.put("msg", "User deleted!");
			
		} catch (Exception e) {
			e.printStackTrace();
			respMap.put("success", "false");
			respMap.put("msg", e.getMessage());
		}
		
		return respMap ;
	}
}
