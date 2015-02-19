/**
 * 
 */
package sivalabs.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sivalabs.app.entities.User;
import sivalabs.app.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService
{
	
	@Autowired UserRepository userRepository;
	
	public User login(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
	
	public User findUserById(int userId)
	{
		return userRepository.findOne(userId);
	}

	@Override
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId)
	{
		userRepository.delete(userId);
	}
	
}
