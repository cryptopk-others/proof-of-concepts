package com.sivalabs.springdatamongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sivalabs.springdatamongo.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends MongoRepository<User, Integer>
{

	User findByEmail(String email);

	User findByUserName(String userName);

	User findByUserNameAndPassword(String userName, String password);

}
