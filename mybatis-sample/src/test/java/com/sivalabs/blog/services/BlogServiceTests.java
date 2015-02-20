package com.sivalabs.blog.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sivalabs.blog.domain.User;

public class BlogServiceTests 
{
	private static BlogService blogService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		blogService = new BlogService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		blogService = null;
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("guest@gmail.com");
		user.setPassword("guest");
		user.setName("Guest");
		User savedUser = blogService.createUser(user);
		assertNotNull(savedUser);
		assertNotNull(savedUser.getId());
		assertEquals(user.getEmail(), savedUser.getEmail());
		assertEquals(user.getPassword(), savedUser.getPassword());
		assertEquals(user.getName(), savedUser.getName());
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = blogService.findAllUsers();
		assertNotNull(users);
		assertFalse(users.isEmpty());
	}

	@Test
	public void testFindUserById() {
		User user = blogService.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void testUpdateUser() {
		User user = blogService.findUserById(2);
		user.setName("New Name");
		assertNotNull(user);
		User updatedUser = blogService.updateUser(user);
		assertNotNull(updatedUser);
		assertEquals(user.getName(), updatedUser.getName());
	}

	@Test
	public void testDeleteUser() {
		blogService.deleteUser(3);
		User user = blogService.findUserById(3);
		assertNull(user);
	}

}
