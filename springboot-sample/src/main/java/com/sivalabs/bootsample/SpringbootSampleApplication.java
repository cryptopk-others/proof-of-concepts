package com.sivalabs.bootsample;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringbootSampleApplication {

	@Autowired
	private PersonRepository personRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleApplication.class, args);
    }
    
    @PostConstruct
    void init()
    {
    	Person person1 = new Person(1,"Siva1","siva1@gmail.com");
    	Person person2 = new  Person(2,"admin1","admiN1@gmail.com");
    	personRepository.save(person1);
    	personRepository.save(person2);
    	
    }
      
  
}

@Controller
class HomeController
{
	@RequestMapping("/")
	public String hello() {
		return "index.html";
	}
	/*
	@RequestMapping("/persons")
	public List<Person> persons() {
		return Arrays.asList(new Person(1,"Siva","siva@gmail.com"), new  Person(2,"admin","admiN@gmail.com"));
	}
	*/
}
