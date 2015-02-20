package com.sivalabs.groovy.sqlcrud

import groovy.sql.Sql;

/**
 * @author Siva
 *
 */
class DBUtil
{
	static Sql getSql()
	{
		Sql.newInstance("jdbc:mysql://localhost:3306/test", "root", "admin", "com.mysql.jdbc.Driver")
	}
}
