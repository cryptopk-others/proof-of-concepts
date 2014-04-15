/**
 * 
 */
package com.sivalabs.bookworms.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.bookworms.entities.Author;
import com.sivalabs.bookworms.model.GenericResponse;
import com.sivalabs.bookworms.services.AuthorService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/authors/", produces={MediaType.APPLICATION_JSON_VALUE})
public class AuthorRestController extends BaseController
{
	@Autowired private AuthorService authorService;
	
	@RequestMapping(value="")
	public GenericResponse<List<Author>> findAllAuthors() {
		GenericResponse<List<Author>> response = new GenericResponse<>();
		response.setData(authorService.findAllAuthors());
		return response;
	}
	
	@RequestMapping(value="/{authorId}")
	public GenericResponse<Author> findAuthor(@PathVariable(value="authorId")int authorId) {
		GenericResponse<Author> response = new GenericResponse<>();
		response.setData(authorService.findAuthorById(authorId));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public GenericResponse<Author> createAuthor(Author author) {
		GenericResponse<Author> response = new GenericResponse<>();
		response.setData(authorService.createAuthor(author));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public GenericResponse<Author> updateAuthor(Author author) {
		GenericResponse<Author> response = new GenericResponse<>();
		response.setData(authorService.updateAuthor(author));
		return response;
	}
	
	@RequestMapping(value="/{authorId}", method=RequestMethod.DELETE)
	public GenericResponse<Author> deleteAuthor(@PathVariable(value="authorId")int authorId) {
		authorService.deleteAuthor(authorId);
		GenericResponse<Author> response = new GenericResponse<>();
		return response;
	}
	
	
}
