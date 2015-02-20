package com.sivalabs.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


@Controller
class MySampleController
{
	@Autowired
	PersonService personService;
	
	@RequestMapping({"/"})
	public String welcome(Model model) {
		return "welcome.html";
	}
	
	@RequestMapping(value="/users/{id}", 
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person findPersonById(@PathVariable("id") int id) 
	{
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(null,"abcd"));
		persons.add(new Person(null,"xyz"));
		persons.add(new Person(null,"xxx"));
		persons.add(new Person(null,"pqr"));
		
		personService.save(persons);
		
		Person person = new Person();
		person.setId(id);
		person.setName("PersonName "+id);
		return person;
	}
}




