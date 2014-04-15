/**
 * 
 */
package com.sivalabs.bookworms.testdata;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.sivalabs.bookworms.entities.Author;
import com.sivalabs.bookworms.entities.Book;
import com.sivalabs.bookworms.entities.Publisher;
import com.sivalabs.bookworms.entities.Role;
import com.sivalabs.bookworms.entities.User;

/**
 * @author Siva
 *
 */
public class TestDataProvider 
{
	private static List<Publisher> publishers;
	private static List<Author> authors;
	private static List<Book> books;
	private static List<Role> roles;
	private static List<User> users;
	
	
	static
	{
		pupulateRoles();
		pupulateUsers();
		pupulatePublishers();
		pupulateAuthors();
		pupulateBooks();
		
	}
	
	static void pupulatePublishers()
	{
		Publisher publisher1 = new Publisher();
		publisher1.setName("Manning Publications");
		Publisher publisher2 = new Publisher();
		publisher2.setName("Manning Publications");
		Publisher publisher3 = new Publisher();
		publisher3.setName("Manning Publications");
		
		publishers = Lists.newArrayList(publisher1, publisher2, publisher3);
	}
	

	private static List<Book> pupulateBooks() {
		Book b1 = new Book();
		b1.setIsbn("ISBN0001");
		b1.setTitle("Java Persistence with MyBatis3");
		b1.setShortDescription("");
		b1.setLongDescription("");
		b1.setPageCount(120);
		b1.setPublishedDate(new Date());
		
		Book b2 = new Book();
		b2.setIsbn("ISBN0002");
		b2.setTitle("PrimeFaces Beginners Guide");
		b2.setShortDescription("");
		b2.setLongDescription("");
		b2.setPageCount(360);
		b2.setPublishedDate(new Date());
		
		return Lists.newArrayList(b1,b2);
	}


	private static List<Author> pupulateAuthors() {
		Author a1 = new Author();
		a1.setName("Siva");
		a1.setEmail("siva@gmail.com");
		
		Author a2 = new Author();
		a2.setName("Venkat");
		a2.setEmail("venkat@gmail.com");
		
		return Lists.newArrayList(a1,a2);
		
	}


	private static List<User> pupulateUsers() {
		User admin = new User(1, "admin@gmail.com", "admin", "Administrator");
		User siva = new User(2, "siva@gmail.com", "siva", "Siva");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		admin.addRoles(role1, role2);
		siva.addRoles(role1);
		
		return Lists.newArrayList(admin, siva);
		
	}

	private static List<Role> pupulateRoles() {
		Role adminRole = new Role("ROLE_ADMIN");
		Role userRole = new Role("ROLE_USER");
		return Lists.newArrayList(adminRole, userRole);
	}


	public static List<Publisher> getPublishers() {
		return publishers;
	}	
	public static List<Author> getAuthors() {
		return authors;
	}
	public static List<Book> getBooks() {
		return books;
	}
	public static List<Role> getRoles() {
		return roles;
	}
	public static List<User> getUsers() {
		return users;
	}
	
}
