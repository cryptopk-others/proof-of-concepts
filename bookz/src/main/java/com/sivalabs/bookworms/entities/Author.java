/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="AUTHORS")
@JsonIgnoreProperties({"books"})
public class Author extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", nullable = false, unique=true, length = 50)
	private String name;
	@Column(name = "email", length = 50)
	private String email;
	
	@ManyToMany(mappedBy="authors")
	private List<Book> books = null;
	
	public Author() {
	}
	public Author(int id) {
		super.setId(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks() {
		if(books == null){
			books = new ArrayList<>();
		}
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
