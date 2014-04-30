/**
 * 
 */
package com.sivalabs.buzz.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.buzz.core.entity.User;
import com.sivalabs.buzz.core.repository.RoleRepository;
import com.sivalabs.buzz.core.repository.UserRepository;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class UserService
{
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	
	public User login(String email, String password)
	{
		return userRepository.findByEmailAndPassword(email,password);
	}
	
	public User create(User user)
	{
		return userRepository.save(user);
	}
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
}
