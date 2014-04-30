/**
 * 
 */
package com.sivalabs.buzz.web.controller;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.buzz.core.entity.Message;
import com.sivalabs.buzz.core.service.MessageService;
import com.sivalabs.buzz.core.viewmodel.MessagesDTO;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/rest", produces=APPLICATION_JSON_VALUE)
public class MessageController
{
	@Autowired MessageService messageService;
	
	@RequestMapping(value="/messages")
	public MessagesDTO messages(@RequestParam("page")int pageNumber)
	{
		Page<Message> page = messageService.findMessages(pageNumber);
		MessagesDTO dto = new MessagesDTO();
		dto.setMessages(page.getContent());
		dto.setCurrentPage(page.getNumber());
		dto.setHasNext(page.hasNextPage());
		dto.setHasPrevious(page.hasPreviousPage());
		return dto;
	}
}
