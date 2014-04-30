/**
 * 
 */
package com.sivalabs.discuzz.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.discuzz.core.entities.Role;
import com.sivalabs.discuzz.core.entities.User;
import com.sivalabs.discuzz.core.repositories.UserRepository;

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
		Set<Role> roles = user.getRoles();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return new SecurityUser(user);
	}

}
