/**
 * 
 */
package sivalabs.app.services;


import java.util.List;

import sivalabs.app.entities.User;

/**
 * @author Siva
 *
 */
public interface UserService 
{

	User login(String userName, String password);
	
	User findUserById(int userId);
	
	List<User> findAllUsers();
	
	User saveUser(User user);
	
	void deleteUser(int userId);
}
