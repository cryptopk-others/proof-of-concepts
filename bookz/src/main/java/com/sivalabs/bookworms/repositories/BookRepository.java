package com.sivalabs.bookworms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookworms.entities.Book;

/**
 * @author Siva
 * 
 */
public interface BookRepository extends JpaRepository<Book, Integer>
{

}
