/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.tasktracker.config.AppConfig;
import com.sivalabs.tasktracker.entities.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTest 
{
	@Autowired private ProjectService projectService;
	@Autowired private UserService userService;
	
	
	@Test
	public void findAllUsers() {
		List<User> users = userService.findAllUsers();
		Assert.assertNotNull(users);
	}
	
	@Test
	public void findUserById() {
		User user = userService.findUserById(1);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void login() {
		User user = userService.login("admin@gmail.com", "admin");
		Assert.assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new User();
		User savedUser = userService.createUser(user );
		Assert.assertNotNull(savedUser);
	}
	
	@Test
	public void updateUser() {
		User user = new User();
		User savedUser = userService.updateUser(user );
		Assert.assertNotNull(savedUser);
	}
	
	@Test
	public void deleteUser() {
		int userId= 3;
		userService.deleteUser(userId);
		User user = userService.findUserById(userId);
		Assert.assertNotNull(user);
	}
	
	
}
