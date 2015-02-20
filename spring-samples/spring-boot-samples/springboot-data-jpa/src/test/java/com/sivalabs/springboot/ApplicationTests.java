package com.sivalabs.springboot;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	PersonService personService;
	
	@Test
	public void test_logging() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(null,"abcd"));
		persons.add(new Person(null,"xyz"));
		persons.add(new Person(null,"xxx"));
		persons.add(new Person(null,"pqr"));
		
		personService.save(persons);
	}

}
