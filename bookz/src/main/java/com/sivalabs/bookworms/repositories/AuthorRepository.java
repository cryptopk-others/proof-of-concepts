package com.sivalabs.bookworms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookworms.entities.Author;

/**
 * @author Siva
 * 
 */
public interface AuthorRepository extends JpaRepository<Author, Integer>
{

	Author findByName(String name);

}
