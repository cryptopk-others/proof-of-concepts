package com.sivalabs.tasktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.tasktracker.entities.Privilege;

/**
 * @author Siva
 * 
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>
{

}
