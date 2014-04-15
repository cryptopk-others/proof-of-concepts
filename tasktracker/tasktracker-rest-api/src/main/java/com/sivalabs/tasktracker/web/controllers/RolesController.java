package com.sivalabs.tasktracker.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.tasktracker.entities.Role;
import com.sivalabs.tasktracker.repositories.RoleRepository;
import com.sivalabs.tasktracker.repositories.UserRepository;

/**
 * @author Siva
 * 
 */
@RestController
@RequestMapping(value="/roles/", produces=MediaType.APPLICATION_JSON_VALUE)
public class RolesController
{
	@Autowired private RoleRepository roleRepository;
	@Autowired private UserRepository userRepository;
	
	@RequestMapping(value="")
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="{id}")
	public Role findById(@PathVariable("id") int id) {
		return roleRepository.findOne(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@RequestMapping(value="", method=RequestMethod.PUT)
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.POST)
	public void createRole(@PathVariable("id") int id) {
		roleRepository.delete(id);
	}
	
}
