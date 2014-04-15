package com.sivalabs.bookworms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookworms.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByRoleName(String roleName);

}
