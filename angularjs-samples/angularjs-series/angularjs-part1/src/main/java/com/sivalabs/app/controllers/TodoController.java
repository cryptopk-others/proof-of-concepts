/**
 *
 *
 */
package com.sivalabs.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.app.entities.Todo;
import com.sivalabs.app.repos.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Todo> persons() {
        return todoRepository.findAll();
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
    	todoRepository.delete(id);
	}
}
