/**
 * 
 */
package sivalabs.app.repositories;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sivalabs.app.config.AppConfig;
import sivalabs.app.entities.Group;
import sivalabs.app.entities.Menu;
import sivalabs.app.entities.User;

/**
 * @author Siva
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserRepositoryTest 
{
	@Autowired
	UserRepository userRepository;
	
	//@Test
	public void findAll() {
		List<User> users = userRepository.findAll();
		Assert.assertNotNull(users);
	}
	@Test
	public void findById()
	{
		User user = userRepository.findOne(1);
		Group group = user.getGroup();
		Set<Menu> menus = group.getMenus();
		System.out.println(menus);
		for (Menu menu : menus)
		{
			System.out.println(menu.getChildMenus());
		}
	}
}
