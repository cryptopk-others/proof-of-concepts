package com.sivalabs.discuzz.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.sivalabs.discuzz.core.entities.User;

@Component
public class SpringSecurityUserContext implements UserContext {
	//private final UserService userService;
	private final UserDetailsService userDetailsService;

	@Autowired
	public SpringSecurityUserContext(UserDetailsService userDetailsService) {
		//this.userService = userService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public User getCurrentUser() 
	{
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (SecurityUser) authentication.getPrincipal();
		//String email = authentication.getName();
		//return userService.findByEmail(email);
	}

	@Override
	public void setCurrentUser(User user) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,user.getPassword(),userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
