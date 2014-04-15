/**
 * 
 */
package com.sivalabs.bookworms.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.BookReview;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BookReviewService  extends AbstractService
{

	public List<BookReview> findAllBookReviews() {
		return getBookReviewRepository().findAll();
	}

	public BookReview findBookReviewById(int bookReviewId) {
		return getBookReviewRepository().findOne(bookReviewId);
	}

	public BookReview createBookReview(BookReview bookReview) {
		return getBookReviewRepository().save(bookReview);
	}

	public BookReview updateBookReview(BookReview bookReview) {
		return getBookReviewRepository().save(bookReview);
	}

	public void deleteBookReview(int bookReviewId) {
		getBookReviewRepository().delete(bookReviewId);		
	}
	
	
	
}
