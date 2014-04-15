/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="PUBLISHERS")
@JsonIgnoreProperties({"books"})
public class Publisher extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Column(name = "name", nullable = false,unique=true, length = 50)
	private String name;
	@OneToMany(mappedBy="publisher")
	private List<Book> books = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
