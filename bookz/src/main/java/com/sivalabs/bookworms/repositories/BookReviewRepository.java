package com.sivalabs.bookworms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookworms.entities.BookReview;

/**
 * @author Siva
 * 
 */
public interface BookReviewRepository extends JpaRepository<BookReview, Integer>
{

}
