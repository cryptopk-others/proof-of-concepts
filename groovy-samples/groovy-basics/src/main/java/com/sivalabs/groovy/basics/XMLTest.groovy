package com.sivalabs.groovy.basics

orders = new XmlSlurper().parse("src/main/resources/orders.xml");

orders.order.each{ o ->
	println "${o.'@id'}  ${o.sku}"
}

def sql = groovy.sql.Sql.newInstance('jdbc:mysql://localhost:3306/test',
	"root", "admin", 'com.mysql.jdbc.Driver')

println sql.connection.catalog

sql.eachRow("select * from users") {
	println it.email
}