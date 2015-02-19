/**
 * 
 */
package com.sivalabs.springdatamongo.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.springdatamongo.entities.User;
import com.sivalabs.springdatamongo.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private UserService userService;

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
		
		
		User user1 = new User(1, "admin", "admin", "Administrator", "admin@gmail.com");
		User user2 = new User(2, "siva", "siva", "Siva", "sivaprasadreddy.k@gmail.com");
		
		userService.createUser(user1);
		userService.createUser(user2);
		
		

	}
}
