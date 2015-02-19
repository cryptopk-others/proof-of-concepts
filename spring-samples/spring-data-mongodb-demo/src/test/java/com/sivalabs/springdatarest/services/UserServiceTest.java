package com.sivalabs.springdatarest.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.springdatamongo.config.AppConfig;
import com.sivalabs.springdatamongo.entities.User;
import com.sivalabs.springdatamongo.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	/*@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testFindAllUsers() {
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			assertNotNull(user);
			System.out.println(user);
			
		}
	}

	/*@Test
	public void testCheckEmailExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckUserNameExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}
*/
}
