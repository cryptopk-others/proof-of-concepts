/**
 * 
 */
package sivalabs.app.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import sivalabs.app.entities.Group;
import sivalabs.app.entities.User;
import sivalabs.app.repositories.GroupRepository;
import sivalabs.app.repositories.UserRepository;
import sivalabs.app.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired private UserRepository userRepository;
	@Autowired private GroupRepository groupRepository;
	
	@Autowired private UserService userService;
	@Autowired private DataSource dataSource;
	
	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				//initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer()
	{
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("mysql.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		return dataSourceInitializer;
	}
	
	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		
		Group adminGroup = new Group(null, "admin");
		adminGroup = groupRepository.save(adminGroup);
		
		User user1 = new User(1, "Administrator", "admin", "admin", "admin@gmail.com");
		User user2 = new User(2, "Siva","siva","siva","siva@gmail.com");
		
		user1.setGroup(adminGroup);
		user2.setGroup(adminGroup);
		adminGroup.getUsers().add(user1);
		adminGroup.getUsers().add(user2);
		
		user1 = userRepository.save(user1);
		user2 = userRepository.save(user2);		
		
	}
}
