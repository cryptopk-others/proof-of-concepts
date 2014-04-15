/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.tasktracker.entities.Privilege;
import com.sivalabs.tasktracker.entities.Role;
import com.sivalabs.tasktracker.repositories.PrivilegeRepository;
import com.sivalabs.tasktracker.repositories.RoleRepository;

/**
 * @author katsi02
 *
 */
@Service
@Transactional
public class RoleService 
{
	@Autowired private RoleRepository roleRepository;
	@Autowired private PrivilegeRepository privilegeRepository;
	
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}
	
	public Role findRoleById(int roleId) {
		return roleRepository.findOne(roleId);
	}
	
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
	
	public void addPrivilegesToRole(int roleId, List<Privilege> privileges) 
	{
		Role role = findRoleById(roleId);
		if(role != null)
		{
			Set<Privilege> currentPrivileges = role.getPrivileges();
			if(privileges != null && !privileges.isEmpty())
			{
				for (Privilege privilege : privileges) 
				{
					if(privilege.getId() != null){
						privilege = privilegeRepository.findOne(privilege.getId());
					}
					if(!currentPrivileges.contains(privilege)){
						currentPrivileges.add(privilege);
					}
				}
			}
			
		}
	}
	
	public void removePrivilegesFromRole(int roleId, List<Privilege> privileges) 
	{
		Role role = findRoleById(roleId);
		if(role != null)
		{
			Set<Privilege> currentPrivileges = role.getPrivileges();
			if(privileges != null && !privileges.isEmpty())
			{
				for (Privilege privilege : privileges) 
				{
					if(privilege.getId() != null){
						privilege = privilegeRepository.findOne(privilege.getId());
					}
					if(currentPrivileges.contains(privilege)){
						currentPrivileges.remove(privilege);
					}
				}
			}
			
		}
	}
	
	public void updateRolePrivileges(int roleId, List<Privilege> addPrivileges, List<Privilege> removePrivileges) 
	{
		addPrivilegesToRole(roleId, addPrivileges);
		removePrivilegesFromRole(roleId, removePrivileges);
	}
	
	public void deleteRole(int roleId) {
		roleRepository.delete(roleId);
	}
	
}
