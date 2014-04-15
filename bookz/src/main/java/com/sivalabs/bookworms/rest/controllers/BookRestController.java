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

import com.sivalabs.bookworms.entities.Book;
import com.sivalabs.bookworms.model.GenericResponse;
import com.sivalabs.bookworms.services.BookService;

/**
 * @Book Siva
 *
 */
@RestController
@RequestMapping(value="/books/", produces={MediaType.APPLICATION_JSON_VALUE})
public class BookRestController extends BaseController
{
	@Autowired private BookService bookService;
	
	@RequestMapping(value="")
	public GenericResponse<List<Book>> findAllBooks() {
		GenericResponse<List<Book>> response = new GenericResponse<>();
		response.setData(bookService.findAllBooks());
		return response;
	}
	
	@RequestMapping(value="/{bookId}")
	public GenericResponse<Book> findBook(@PathVariable(value="bookId")int bookId) {
		GenericResponse<Book> response = new GenericResponse<>();
		response.setData(bookService.findBookById(bookId));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public GenericResponse<Book> createBook(Book book) {
		GenericResponse<Book> response = new GenericResponse<>();
		response.setData(bookService.createBook(book));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public GenericResponse<Book> updateBook(Book book) {
		GenericResponse<Book> response = new GenericResponse<>();
		response.setData(bookService.updateBook(book));
		return response;
	}
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
	public GenericResponse<Book> deleteBook(@PathVariable(value="bookId")int bookId) {
		bookService.deleteBook(bookId);
		GenericResponse<Book> response = new GenericResponse<>();
		return response;
	}
	
	
}
