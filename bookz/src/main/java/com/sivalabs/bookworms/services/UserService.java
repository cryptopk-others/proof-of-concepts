package com.sivalabs.bookworms.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookworms.entities.User;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class UserService  extends AbstractService
{
	/*@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;*/

	public void createUser(User user)
	{
		if(checkEmailExists(user.getEmail())){
			throw new RuntimeException("Email ["+user.getEmail()+"] already exist");
		}
		getUserRepository().save(user);
	}

	public User findUserById(Integer userId)
	{
		return getUserRepository().findOne(userId);
	}

	public List<User> findAllUsers()
	{
		return getUserRepository().findAll();
	}

	public boolean checkEmailExists(String email)
	{
		return getUserRepository().findByEmail(email) != null;
	}

	public User login(String email, String password)
	{
		return getUserRepository().findByEmailAndPassword(email, password);
	}

	
}
