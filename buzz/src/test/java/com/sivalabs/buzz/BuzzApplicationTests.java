package com.sivalabs.buzz;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.buzz.core.entity.Message;
import com.sivalabs.buzz.core.entity.User;
import com.sivalabs.buzz.core.service.MessageService;
import com.sivalabs.buzz.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuzzApplication.class)
@WebAppConfiguration
public class BuzzApplicationTests {

	@Autowired UserService userService;
	@Autowired MessageService messageService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void login() {
		User user = userService.login("admin@gmail.com", "admin");
		assertNotNull(user);
	}
	
	@Test
	public void findByEmail() {
		User user = userService.findByEmail("admin@gmail.com");
		assertNotNull(user);
	}
	
	@Test
	public void createMessage() {
		Message message = new Message();
		message.setContent("Message :"+ new Date());
		User createdBy = userService.findByEmail("admin@gmail.com");
		message.setCreatedBy(createdBy );
		Message savedMsg = messageService.create(message);
		assertNotNull(savedMsg);
	}
	
	
	@Test
	public void findMessages() {
		Page<Message> page = messageService.findMessages(0, 25);
		assertNotNull(page);
		
		page = messageService.findMessages();
		assertNotNull(page);
		
		page = messageService.findMessages(1);
		assertNotNull(page);
	}
	
	@Test
	public void searchMessages() {
		Page<Message> page = messageService.findMessages(0, 25);
		assertNotNull(page);
	}
	
	@Test
	public void findUserMessages() {
		int userId = 1;
		Page<Message> page = messageService.findUserMessages(userId);
		assertNotNull(page);
	}
}
