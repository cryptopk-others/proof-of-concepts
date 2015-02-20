package com.sivalabs.blog.mappers;

import java.util.List;

import com.sivalabs.blog.domain.User;

/**
 * @author skatam
 *
 */
public interface UserMapper {

	int createUser(User user);
	
	User findUserById(Integer userId);
	
	List<User> findAllUsers();

	void updateUser(User user);
	
	void deleteUser(Integer userId);
	
}
