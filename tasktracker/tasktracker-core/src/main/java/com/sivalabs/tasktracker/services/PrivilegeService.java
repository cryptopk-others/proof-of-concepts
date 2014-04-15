/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.tasktracker.entities.Privilege;
import com.sivalabs.tasktracker.repositories.PrivilegeRepository;
import com.sivalabs.tasktracker.repositories.RoleRepository;

/**
 * @author katsi02
 *
 */
@Service
@Transactional
public class PrivilegeService 
{
	@Autowired private RoleRepository roleRepository;
	@Autowired private PrivilegeRepository privilegeRepository;
	
	
	
	public List<Privilege> findAllPrivileges() {
		return privilegeRepository.findAll();
	}
	
	public Privilege findPrivilegeById(int privilegeId) {
		return privilegeRepository.findOne(privilegeId);
	}
	
	public Privilege createPrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}
	
	public Privilege updatePrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}
	
	public void deletePrivilege(int privilegeId) {
		privilegeRepository.delete(privilegeId);
	}
	
}
