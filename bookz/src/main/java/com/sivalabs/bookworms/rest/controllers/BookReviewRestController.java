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

import com.sivalabs.bookworms.entities.BookReview;
import com.sivalabs.bookworms.model.GenericResponse;
import com.sivalabs.bookworms.services.BookReviewService;

/**
 * @BookReview Siva
 *
 */
@RestController
@RequestMapping(value="/bookreviews/", produces={MediaType.APPLICATION_JSON_VALUE})
public class BookReviewRestController extends BaseController
{
	@Autowired private BookReviewService bookReviewService;
	
	@RequestMapping(value="")
	public GenericResponse<List<BookReview>> findAllBookReviews() {
		GenericResponse<List<BookReview>> response = new GenericResponse<>();
		response.setData(bookReviewService.findAllBookReviews());
		return response;
	}
	
	@RequestMapping(value="/{bookReviewId}")
	public GenericResponse<BookReview> findBookReview(@PathVariable(value="bookReviewId")int bookReviewId) {
		GenericResponse<BookReview> response = new GenericResponse<>();
		response.setData(bookReviewService.findBookReviewById(bookReviewId));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public GenericResponse<BookReview> createBookReview(BookReview bookReview) {
		GenericResponse<BookReview> response = new GenericResponse<>();
		response.setData(bookReviewService.createBookReview(bookReview));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public GenericResponse<BookReview> updateBookReview(BookReview bookReview) {
		GenericResponse<BookReview> response = new GenericResponse<>();
		response.setData(bookReviewService.updateBookReview(bookReview));
		return response;
	}
	
	@RequestMapping(value="/{bookReviewId}", method=RequestMethod.DELETE)
	public GenericResponse<BookReview> deleteBookReview(@PathVariable(value="bookReviewId")int bookReviewId) {
		bookReviewService.deleteBookReview(bookReviewId);
		GenericResponse<BookReview> response = new GenericResponse<>();
		return response;
	}
	
	
}
