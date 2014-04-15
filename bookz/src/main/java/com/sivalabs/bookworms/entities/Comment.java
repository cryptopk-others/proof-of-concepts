/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="COMMENTS")
@JsonIgnoreProperties({"bookReview"})
public class Comment extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, length=1024)
	private String message;
	@ManyToOne
	@JoinColumn(name="posted_by")
	private User postedBy;
	@ManyToOne
	@JoinColumn(name="book_review_id")
	private BookReview bookReview;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}
	
	
}
