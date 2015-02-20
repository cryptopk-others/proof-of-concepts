/**
 * 
 */
package com.sivalabs.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author skatam
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonService myService = ctx.getBean(PersonService.class);
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(null,"abcd"));
		persons.add(new Person(null,"xyz"));
		persons.add(new Person(null,"xxx"));
		persons.add(new Person(null,"pqr"));
		
		myService.save(persons);
		
	}
}
