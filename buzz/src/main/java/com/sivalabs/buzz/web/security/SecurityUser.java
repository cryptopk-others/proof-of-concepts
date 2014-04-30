/**
 * 
 */
package com.sivalabs.buzz.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sivalabs.buzz.core.entity.Role;
import com.sivalabs.buzz.core.entity.User;


/**
 * @author Siva
 *
 */
public class SecurityUser extends User implements UserDetails
{
	private static final long serialVersionUID = 1L;
	
	public SecurityUser(User user)
	{
		setId(user.getId());
		setEmail(user.getEmail());
		setName(user.getName());
		setPassword(user.getPassword());
		setRoles(user.getRoles());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{

		Set<Role> roles = getRoles();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getUsername()
	{
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
