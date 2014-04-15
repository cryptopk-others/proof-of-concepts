/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="BOOKS")
public class Book extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Column(nullable=false, length=10)
	private String isbn;
	@Column(nullable=false, length=100)
	private String title;
	@Column(name="short_desc", length=250)
	private String shortDescription;
	@Column(name="long_desc", length=1024)
	private String longDescription;
	@Temporal(TemporalType.DATE)
	@Column(name="published_date")
	private Date publishedDate;
	@Column(name="pages")
	private int pageCount;
	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name="books_authors",
	joinColumns=@JoinColumn(name="book_id"),
	inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		if(authors == null){
			authors = new HashSet<>();
		}
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
	
}
