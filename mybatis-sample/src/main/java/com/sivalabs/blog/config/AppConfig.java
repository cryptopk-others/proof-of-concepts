/**
 * 
 */
package com.sivalabs.blog.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author skatam
 *
 */
public class AppConfig {

	private static final SqlSessionFactory SQL_SESSION_FACTORY = buildSqlSessionFactory();
	
	private static SqlSessionFactory buildSqlSessionFactory() {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SQL_SESSION_FACTORY;
	}
	
	public static SqlSession getSqlSession()
	{
		return SQL_SESSION_FACTORY.openSession();
	}
}
