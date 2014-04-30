package com.sivalabs.discuzz.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.discuzz.core.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByRoleName(String string);

}
