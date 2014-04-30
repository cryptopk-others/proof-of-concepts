/**
 * 
 */
package com.sivalabs.buzz.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.buzz.core.entity.User;
import com.sivalabs.buzz.core.repository.UserRepository;

/**
 * @author Siva
 *
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userRepository.findByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Invalid Email/Password");
		}
		
		return new SecurityUser(user);
	}

}
