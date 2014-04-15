/**
 * 
 */
package com.sivalabs.bookworms.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.Role;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class AdminService extends AbstractService
{
	public Role createRole(Role role) {
		return getRoleRepository().save(role);
	}
	
	public Role findRoleByName(String roleName) {
		return getRoleRepository().findByRoleName(roleName);
	}
}
