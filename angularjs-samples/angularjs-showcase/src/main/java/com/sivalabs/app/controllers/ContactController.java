/**
*
*
*/
package com.sivalabs.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.app.entities.Person;
import com.sivalabs.app.repos.PersonRepository;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private PersonRepository personRepository;
	@RequestMapping("/list")
	public List<Person> persons() {
		return personRepository.findAll();
	}
}
