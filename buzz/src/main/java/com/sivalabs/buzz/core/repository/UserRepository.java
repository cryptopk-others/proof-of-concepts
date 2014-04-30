/**
 * 
 */
package com.sivalabs.buzz.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.buzz.core.entity.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}
