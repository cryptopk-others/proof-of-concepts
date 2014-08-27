/**
*
*
*/
package com.sivalabs.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.app.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
