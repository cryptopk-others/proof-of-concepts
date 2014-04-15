/**
 * 
 */
package com.sivalabs.bookworms.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookworms.config.AppConfig;
import com.sivalabs.bookworms.entities.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTests 
{
	@Autowired UserService userService;
	
	@Test
	public void findAllUsers() {
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
}
