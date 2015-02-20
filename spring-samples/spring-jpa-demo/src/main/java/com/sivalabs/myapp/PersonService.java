package com.sivalabs.myapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService
{
	@Autowired PersonRepository personRepository;
	@Autowired LogService logService;
	@Autowired DataSource ds;
	@Transactional() //(propagation=Propagation.REQUIRES_NEW)
	public void save(List<Person> persons){
		JdbcTemplate jt = new JdbcTemplate(ds);
		
		for (Person person : persons) {
			System.out.println("-->"+DataSourceUtils.getConnection(ds).hashCode());
			jt.execute(new ConnectionCallback<String>() {

				@Override
				public String doInConnection(Connection conn) throws SQLException,
						DataAccessException {
					System.out.println(conn.hashCode());
					return null;
				}
			});
			try {
				
				if("xxx".equals(person.getName())){
					throw new RuntimeException("boooom!!!");
				}
				personRepository.save(person);
				//em.persist(person);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				Log log = new Log();
				log.setName("Inserting "+person.getName());
				logService.save(log );
			}
			
			
			jt.execute(new ConnectionCallback<String>() {

				@Override
				public String doInConnection(Connection conn) throws SQLException,
						DataAccessException {
					System.out.println(conn.hashCode());
					return null;
				}
			});
		}
	}
}
