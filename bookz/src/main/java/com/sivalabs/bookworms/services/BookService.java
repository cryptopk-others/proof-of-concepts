/**
 * 
 */
package com.sivalabs.bookworms.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.Author;
import com.sivalabs.bookworms.entities.Book;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BookService extends AbstractService
{

	public Book createBook(Book book) {
		Set<Author> authors = book.getAuthors();
		for (Author author : authors) {
			if(author.getId() == 0){
				getAuthorRepository().save(author);
			}
		}
		return getBookRepository().save(book);
	}

	public List<Book> findAllBooks() {
		return getBookRepository().findAll();
	}

	public Book findBookById(int bookId) {
		return getBookRepository().findOne(bookId);
	}

	public Book updateBook(Book book) {
		return getBookRepository().save(book);
	}

	public void deleteBook(int bookId) {
		getBookRepository().delete(bookId);;		
	}

}
