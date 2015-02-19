package com.sivalabs.senchatouch.repositories;

import java.util.List;

import com.sivalabs.senchatouch.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository
{

	User findByEmail(String email);

	User findByUserName(String userName);

	void save(User user);

	User findOne(Integer userId);

	List<User> findAll();

}
