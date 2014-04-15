package com.sivalabs.springdatamongo.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@ComponentScan(basePackages = { "com.sivalabs.springdatamongo" }, excludeFilters = {
 @ComponentScan.Filter(pattern = { "com.sivalabs.springdatamongo.web.*", "com.sivalabs.springdatamongo.rest.*" }, type = FilterType.REGEX)

})
@EnableAspectJAutoProxy
@EnableMongoRepositories(basePackages = { "com.sivalabs.springdatamongo.repositories" })
//@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

	public @Bean Mongo mongo() throws UnknownHostException {
	       return new Mongo("localhost");
	}
	
	public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydatabase");
    }
    
	/*
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	    //UserCredentials userCredentials = new UserCredentials("joe", "secret");
	    MongoURI mongoURI = new MongoURI("mongodb://user:pwd@dsxxxx.mongolab.com:61268/myforum");
	    //return new SimpleMongoDbFactory(new Mongo(), "database", userCredentials);
	    return new SimpleMongoDbFactory(mongoURI);
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
	    return new MongoTemplate(mongoDbFactory());
	}
	*/
}
