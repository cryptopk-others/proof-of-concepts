/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="BOOK_REVIEWS")
public class BookReview extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;
	@OneToOne
	@JoinColumn(name="reviewed_by")
	private User reviewedBy;
	@Column(nullable=false, length=1024)
	private String content;
	@OneToMany(mappedBy="bookReview")
	private List<Comment> comments;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(User reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
