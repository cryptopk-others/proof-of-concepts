package com.sivalabs.tasktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.tasktracker.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
