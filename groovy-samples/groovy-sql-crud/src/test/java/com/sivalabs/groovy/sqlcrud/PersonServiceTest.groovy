package com.sivalabs.groovy.sqlcrud;

import static org.junit.Assert.*;

import org.junit.Test;

class PersonServiceTest
{
	PersonService ps = new PersonService()
	
	@Test
	public void testList()
	{
		def list = ps.list()
		list.each {
			println it
		}
	}

}
