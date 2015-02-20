/**
 * 
 */
package com.sivalabs.blog.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sivalabs.blog.config.AppConfig;
import com.sivalabs.blog.domain.User;
import com.sivalabs.blog.mappers.UserMapper;

/**
 * @author skatam
 *
 */
public class BlogService 
{
	public User createUser(User user) 
	{		
		SqlSession session = AppConfig.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
		    int userId = userMapper.createUser(user);
		    session.commit();
		    user.setId(userId);
		} finally {
		  session.close();
		}
		return user;

	}
	
	public List<User> findAllUsers()
	{		
		SqlSession session = AppConfig.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
		    List<User> users = userMapper.findAllUsers();
		    session.commit();
		    return users;
		} finally {
		  session.close();
		}

	}
	
	public User findUserById(Integer userId) {		
		SqlSession session = AppConfig.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
		    User user = userMapper.findUserById(userId);
		    session.commit();
		    return user;
		} finally {
		  session.close();
		}
	}

	public User updateUser(User user) {		
		SqlSession session = AppConfig.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
		    userMapper.updateUser(user);
		    session.commit();
		    return user;
		} finally {
		  session.close();
		}
	}

	public void deleteUser(Integer userId) {		
		SqlSession session = AppConfig.getSqlSession();
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
		    userMapper.deleteUser(userId);
		    session.commit();
		} finally {
		  session.close();
		}
	}

}
