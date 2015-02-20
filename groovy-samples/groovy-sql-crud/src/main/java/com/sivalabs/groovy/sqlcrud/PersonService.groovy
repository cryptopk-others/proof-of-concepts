package com.sivalabs.groovy.sqlcrud

import java.sql.SQLClientInfoException;

import groovy.sql.*;

/**
 * @author Siva
 *
 */
class PersonService
{
	def List<Person> list()
	{
		def persons = []
		Sql sql = DBUtil.sql;
		DataSet dataset = sql.dataSet("users");
		dataset.each {
			println "--->"+ it['user_id'] + " "+ it.email+ " "+ it.phone
			persons += new Person(id:it['user_id'], email: it.email, phone: it.phone)
		}
		persons
	}
	
	def Person findById(int id){
		Sql sql = DBUtil.sql;
		
	}
}
