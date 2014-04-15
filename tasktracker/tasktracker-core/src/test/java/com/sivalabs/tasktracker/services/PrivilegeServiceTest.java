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
import com.sivalabs.tasktracker.entities.Privilege;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class PrivilegeServiceTest 
{
	@Autowired private PrivilegeService privilegeService;
	
	
	@Test
	public void findAllPrivileges() {
		List<Privilege> privileges = privilegeService.findAllPrivileges();
		Assert.assertNotNull(privileges);
	}
	
	@Test
	public void findPrivilegeById() {
		Privilege privilege = privilegeService.findPrivilegeById(1);
		Assert.assertNotNull(privilege);
	}
	
	@Test
	public void createPrivilege() {
		Privilege privilege = new Privilege();
		Privilege savedPrivilege = privilegeService.createPrivilege(privilege );
		Assert.assertNotNull(savedPrivilege);
	}
	
	@Test
	public void updatePrivilege() {
		Privilege privilege = new Privilege();
		Privilege savedPrivilege = privilegeService.updatePrivilege(privilege );
		Assert.assertNotNull(savedPrivilege);
	}
	
	@Test
	public void deletePrivilege() {
		int privilegeId= 3;
		privilegeService.deletePrivilege(privilegeId);
		Privilege privilege = privilegeService.findPrivilegeById(privilegeId);
		Assert.assertNotNull(privilege);
	}
	
	
}
