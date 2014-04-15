/**
 * 
 */
package com.sivalabs.bookworms.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.Publisher;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class PublisherService extends AbstractService
{
	public Publisher createPublisher(Publisher publisher) {
		return getPublisherRepository().save(publisher);
	}
	
	public Publisher findPublisherById(int id) {
		return getPublisherRepository().findOne(id);
	}
	
	public Publisher findPublisherByName(String name) {
		return getPublisherRepository().findByName(name);
	}
	
	public List<Publisher> findAllPublishers() {
		return getPublisherRepository().findAll();
	}

	public Publisher updatePublisher(Publisher publisher) {
		return getPublisherRepository().save(publisher);
	}

	public void deletePublisher(int publisherId) {
		Publisher publisher = getPublisherRepository().findOne(publisherId);
		if(publisher != null){
			getPublisherRepository().delete(publisher);
		}
	}
	
}
