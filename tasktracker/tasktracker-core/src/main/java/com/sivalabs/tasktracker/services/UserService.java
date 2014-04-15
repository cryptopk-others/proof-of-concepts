/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.tasktracker.entities.User;
import com.sivalabs.tasktracker.repositories.PrivilegeRepository;
import com.sivalabs.tasktracker.repositories.RoleRepository;
import com.sivalabs.tasktracker.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private PrivilegeRepository privilegeRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(int userId) {
		userRepository.delete(userId);
	}
	
	
}

