/**
 * 
 */
package com.sivalabs.bookworms.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.bookworms.entities.Publisher;
import com.sivalabs.bookworms.model.GenericResponse;
import com.sivalabs.bookworms.services.PublisherService;

/**
 * @Publisher Siva
 *
 */
@RestController
@RequestMapping(value="/publishers/", produces={MediaType.APPLICATION_JSON_VALUE})
public class PublisherRestController extends BaseController
{
	@Autowired private PublisherService publisherService;
	
	@RequestMapping(value="")
	public GenericResponse<List<Publisher>> findAllPublishers() {
		GenericResponse<List<Publisher>> response = new GenericResponse<>();
		response.setData(publisherService.findAllPublishers());
		return response;
	}
	
	@RequestMapping(value="/{publisherId}")
	public GenericResponse<Publisher> findPublisher(@PathVariable(value="publisherId")int publisherId) {
		GenericResponse<Publisher> response = new GenericResponse<>();
		response.setData(publisherService.findPublisherById(publisherId));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public GenericResponse<Publisher> createPublisher(Publisher publisher) {
		GenericResponse<Publisher> response = new GenericResponse<>();
		response.setData(publisherService.createPublisher(publisher));
		return response;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public GenericResponse<Publisher> updatePublisher(Publisher publisher) {
		GenericResponse<Publisher> response = new GenericResponse<>();
		response.setData(publisherService.updatePublisher(publisher));
		return response;
	}
	
	@RequestMapping(value="/{publisherId}", method=RequestMethod.DELETE)
	public GenericResponse<Publisher> deletePublisher(@PathVariable(value="publisherId")int publisherId) {
		publisherService.deletePublisher(publisherId);
		GenericResponse<Publisher> response = new GenericResponse<>();
		return response;
	}
	
	
}
