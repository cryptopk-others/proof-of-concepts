/**
 * 
 */
package com.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class UserService {
	
	public boolean login(User user)
	{
		return ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword()));
	}
	
	public void register(User user)
	{
		System.out.println("Register User: "+user);
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "admin", "admin", "admin@gmail.com", new Date()));
		users.add(new User(2, "siva", "siva", "siva@gmail.com", new Date()));
		users.add(new User(3, "prasad", "prasad", "prasad@gmail.com", new Date()));
		users.add(new User(4, "test", "test", "test@gmail.com", new Date()));
		users.add(new User(5, "guest", "guest", "guest@gmail.com", new Date()));
		users.add(new User(6, "john", "john", "john@gmail.com", new Date()));
		users.add(new User(7, "paul", "paul", "paul@gmail.com", new Date()));
		users.add(new User(8, "rob", "rob", "rob@gmail.com", new Date()));
		
		return users;
	}
}
