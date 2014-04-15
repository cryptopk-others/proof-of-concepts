/**
 * 
 */
package com.sivalabs.bookworms.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookworms.config.AppConfig;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class AdminServiceTests 
{
	@Autowired AdminService adminService;
	
	@Test
	public void test() {
		
		
	}
	
	
}
