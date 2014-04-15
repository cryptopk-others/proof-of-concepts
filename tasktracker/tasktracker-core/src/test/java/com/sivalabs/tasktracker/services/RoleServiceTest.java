/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.tasktracker.config.AppConfig;
import com.sivalabs.tasktracker.entities.Role;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class RoleServiceTest 
{
	@Autowired private RoleService roleService;
	
	
	@Test
	public void findAllRoles() {
		List<Role> roles = roleService.findAllRoles();
		Assert.assertNotNull(roles);
	}
	
	@Test
	public void findRoleById() {
		Role role = roleService.findRoleById(1);
		Assert.assertNotNull(role);
	}
	
	@Test
	public void createRole() {
		Role role = new Role();
		role.setRoleName("ROLE_GUEST");
		Role savedRole = roleService.createRole(role );
		Assert.assertNotNull(savedRole);
	}
	
	@Test
	public void updateRole() {
		Role role = roleService.findRoleById(1);
		role.setRoleName(role.getRoleName()+"_TEMP");
		Role savedRole = roleService.updateRole(role );
		Assert.assertNotNull(savedRole);
	}
	
	@Test
	public void deleteRole() {
		int roleId= 3;
		roleService.deleteRole(roleId);
		Role role = roleService.findRoleById(roleId);
		Assert.assertNull(role);
	}
	
	
}
