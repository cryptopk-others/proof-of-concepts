package com.sivalabs.bookworms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookworms.entities.Publisher;

/**
 * @author Siva
 * 
 */
public interface PublisherRepository extends JpaRepository<Publisher, Integer>
{

	Publisher findByName(String name);

}
