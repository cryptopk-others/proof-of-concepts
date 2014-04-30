/**
 * 
 */
package com.sivalabs.buzz.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.buzz.core.entity.Message;
import com.sivalabs.buzz.core.repository.MessageRepository;
import com.sivalabs.buzz.core.repository.UserRepository;
import static com.sivalabs.buzz.core.utils.Constants.*;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class MessageService
{
	@Autowired UserRepository userRepository;
	@Autowired MessageRepository messageRepository;

	public Message create(Message message)
	{
		return messageRepository.save(message);
	}
	
	public List<Message> findAllMessages()
	{
		return messageRepository.findAll();
	}
	
	public Page<Message> findMessages()
	{
		return findMessages(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE, null, null);
	}
	public Page<Message> findMessages(int pageNumber)
	{
		return findMessages(pageNumber, DEFAULT_PAGE_SIZE, null, null);
	}
	public Page<Message> findMessages(int pageNumber, int pageSize)
	{
		return findMessages(pageNumber, pageSize, null, null);
	}
	
	public Page<Message> findMessages(int pageNumber, int pageSize, String sortBy, String sortOrder)
	{
		Pageable pageable = null;
		if(sortBy != null){
			if(sortOrder == null || sortOrder.trim().length()==0){
				sortOrder = "ASC"; 
			}
			pageable = new PageRequest(pageNumber, pageSize, new Sort(Direction.fromString(sortOrder), sortBy));
		}else {
			pageable = new PageRequest(pageNumber, pageSize);
		}
		return messageRepository.findAll(pageable);
	}

	public Page<Message> findUserMessages(int userId)
	{
		return findUserMessages(userId, DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
	}
	
	public Page<Message> findUserMessages(int userId, int pageNumber, int pageSize)
	{
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		return messageRepository.findByCreatedById(userId, pageable);
	}

	
	
}
