package com.sivalabs.discuzz.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.discuzz.core.entities.Role;
import com.sivalabs.discuzz.core.entities.User;
import com.sivalabs.discuzz.core.repositories.RoleRepository;
import com.sivalabs.discuzz.core.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService
{
	//@Autowired
	//private UserDetailsManager userDetailsManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public void createUser(User user)
	{
		if(findByEmail(user.getEmail()) != null){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		
		//Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		//UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities );
		//userDetailsManager.createUser(userDetails);
		
		Role role = roleRepository.findByRoleName("ROLE_USER");
		user.getRoles().add(role);
		role.getUsers().add(user);
		
		userRepository.save(user);
	}
	
	public void updateUser(User user)
	{
		userRepository.save(user);
	}
	
	public void deleteUser(Integer userId)
	{
		userRepository.delete(userId);
	}

	public User findUserById(Integer userId)
	{
		return userRepository.findOne(userId);
	}

	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	public User login(String email, String password)
	{
		return userRepository.login(email, password);
	}

}
