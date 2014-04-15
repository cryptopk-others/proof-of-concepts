package com.sivalabs.groovy.sqlcrud

/**
 * @author Siva
 *
 */
class Person
{
	int id;
	String name;
	String email;
	String phone;
	Date dob;
	
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob + "]";
	}
	
}
