package com.sivalabs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Controller
class MySampleController
{
	@RequestMapping({"/"})
	public String welcome(Model model) {
		model.addAttribute("username", "Siva");
		return "welcome.jsp";
	}
	
	@RequestMapping(value="/users/{id}", 
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Person findPersonById(@PathVariable("id") int id) 
	{
		Person person = new Person();
		person.setId(id);
		person.setName("PersonName "+id);
		return person;
	}
}

class Person
{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}