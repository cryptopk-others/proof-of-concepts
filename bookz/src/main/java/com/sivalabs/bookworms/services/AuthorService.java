/**
 * 
 */
package com.sivalabs.bookworms.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.Author;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class AuthorService extends AbstractService
{
	public Author createAuthor(Author author) {
		return getAuthorRepository().save(author);
	}
	
	public Author findAuthorById(int id) {
		return getAuthorRepository().findOne(id);
	}
	
	public Author findAuthorByName(String name) {
		return getAuthorRepository().findByName(name);
	}
	
	public List<Author> findAllAuthors() {
		return getAuthorRepository().findAll();
	}

	public Author updateAuthor(Author author) {
		return getAuthorRepository().save(author);
	}

	public void deleteAuthor(int authorId) {
		
		Author author = getAuthorRepository().findOne(authorId);
		if(author != null){
			getAuthorRepository().delete(author);
		}
	}
}
