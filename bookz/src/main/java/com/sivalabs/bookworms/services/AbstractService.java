/**
 * 
 */
package com.sivalabs.bookworms.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sivalabs.bookworms.repositories.AuthorRepository;
import com.sivalabs.bookworms.repositories.BookRepository;
import com.sivalabs.bookworms.repositories.BookReviewRepository;
import com.sivalabs.bookworms.repositories.PublisherRepository;
import com.sivalabs.bookworms.repositories.RoleRepository;
import com.sivalabs.bookworms.repositories.UserRepository;

/**
 * @author Siva
 *
 */
public class AbstractService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private BookRepository bookRepository; 
	@Autowired private AuthorRepository authorRepository;
	@Autowired private BookReviewRepository bookReviewRepository; 
	@Autowired private PublisherRepository publisherRepository;
	
	public BookRepository getBookRepository() {
		return bookRepository;
	}
	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}
	
	public BookReviewRepository getBookReviewRepository() {
		return bookReviewRepository;
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	public PublisherRepository getPublisherRepository() {
		return publisherRepository;
	}
	public RoleRepository getRoleRepository() {
		return roleRepository;
	}
	
	
}
