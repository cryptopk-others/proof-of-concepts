/**
 * 
 */
package com.sivalabs.bootsample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author user
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/")
	public List<Person> list() {
		return personRepository.findAll();
	}
}
