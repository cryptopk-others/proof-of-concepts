package com.sivalabs.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService
{
	@Autowired LogRepository logRepository;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(Log log){
		logRepository.save(log);
	}
}
