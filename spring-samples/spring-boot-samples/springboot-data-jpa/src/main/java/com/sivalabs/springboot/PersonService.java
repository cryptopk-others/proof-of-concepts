package com.sivalabs.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService
{
	@Autowired PersonRepository personRepository;
	@Autowired LogService logService;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void save(List<Person> persons){
		for (Person person : persons) {		
			
			Log log = new Log();
			log.setName("Inserting "+person.getId());
			//logService.save(log);
			if("xxx".equals(person.getName())){
				throw new RuntimeException("boooom!!!");
			}
			personRepository.save(person);
			//em.persist(person);
		}
	}
}
