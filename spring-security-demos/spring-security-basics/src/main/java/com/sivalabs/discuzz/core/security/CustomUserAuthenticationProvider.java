package com.sivalabs.discuzz.core.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.discuzz.core.entities.Role;
import com.sivalabs.discuzz.core.entities.User;
import com.sivalabs.discuzz.core.services.UserService;

@Component
public class CustomUserAuthenticationProvider implements AuthenticationProvider
{

	@Autowired
	private UserService userService;

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException
	{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String email = token.getName();
		User user = null;
		if (email != null)
		{
			user = userService.findByEmail(email);
		}
		if (user == null)
		{
			throw new UsernameNotFoundException("Invalid username/password");
		}
		String password = user.getPassword();
		if (!password.equals(token.getCredentials()))
		{
			throw new BadCredentialsException("Invalid username/password");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : user.getRoles())
		{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	public boolean supports(Class<?> authentication)
	{
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
