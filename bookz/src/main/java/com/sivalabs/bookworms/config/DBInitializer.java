/**
 * 
 */
package com.sivalabs.bookworms.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.sivalabs.bookworms.entities.Author;
import com.sivalabs.bookworms.entities.Book;
import com.sivalabs.bookworms.entities.Publisher;
import com.sivalabs.bookworms.entities.Role;
import com.sivalabs.bookworms.entities.User;
import com.sivalabs.bookworms.services.AdminService;
import com.sivalabs.bookworms.services.AuthorService;
import com.sivalabs.bookworms.services.BookService;
import com.sivalabs.bookworms.services.PublisherService;
import com.sivalabs.bookworms.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired private UserService userService;
	@Autowired private AdminService adminService;
	@Autowired private PublisherService publisherService;
	@Autowired private AuthorService authorService;
	@Autowired private BookService bookService; 
	
	
	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		
		//Role adminRole = adminService.createRole(role1);
		//Role userRole  = adminService.createRole(role2);
		
		User admin = new User(1, "admin@gmail.com", "admin", "Administrator");
		User siva = new User(2, "siva@gmail.com", "siva", "Siva");
		
		admin.addRoles(adminRole, userRole);
		siva.addRoles(userRole);
		
		userService.createUser(admin);
		userService.createUser(siva);
		
		Publisher publisher1 = new Publisher();
		publisher1.setName("Manning Publications");
		Publisher publisher2 = new Publisher();
		publisher2.setName("Packt Publishers");
		Publisher publisher3 = new Publisher();
		publisher3.setName("Apress");
		
		publisherService.createPublisher(publisher1);
		publisherService.createPublisher(publisher2);
		publisherService.createPublisher(publisher3);
		
		Author a1 = new Author();
		a1.setName("Siva");
		a1.setEmail("siva@gmail.com");
		//a1.getBooks().add(b1);
		
		Author a2 = new Author();
		a2.setName("Venkat");
		a2.setEmail("venkat@gmail.com");
		//a2.getBooks().add(b1);
		
		Author a3 = new Author();
		a3.setName("Prasad");
		a3.setEmail("prasad@gmail.com");
		
		//a1 = authorService.createAuthor(a1);
		//a2 = authorService.createAuthor(a2);
		a3 = authorService.createAuthor(a3);
		
		
		Book b1 = new Book();
		b1.setIsbn("ISBN0001");
		b1.setTitle("Java Persistence with MyBatis3");
		b1.setShortDescription("");
		b1.setLongDescription("");
		b1.setPageCount(120);
		b1.setPublishedDate(new Date());
		b1.setPublisher(publisher1);
		b1.setAuthors(Sets.newHashSet(a1));
		//a1.getBooks().add(b1);
		
		
		Book b2 = new Book();
		b2.setIsbn("ISBN0002");
		b2.setTitle("PrimeFaces Beginners Guide");
		b2.setShortDescription("");
		b2.setLongDescription("");
		b2.setPageCount(360);
		b2.setPublishedDate(new Date());
		b2.setPublisher(publisher2);
		b2.setAuthors(Sets.newHashSet(a2, a3));
		//a2.getBooks().add(b2);
		
		b1 = bookService.createBook(b1);
		b2 = bookService.createBook(b2);
		
		
	}
}
