package com.sivalabs.groovy.basics

import groovy.transform.TypeChecked;

/**
 * @author Siva
 *
 */
class TakeHelp {

	static main(args) {
		takeHelp(new Man())
		takeHelp(new Woman())
		takeHelp(new Elephant())
		
		try {
			shout('hello')
			} catch(ex) {
			println "Failed..."
			}
	}
	
	static def takeHelp(helper)
	{
		helper.help()
	}
	
	@TypeChecked
	def static shout(String str) {
		println "Printing in uppercase"
		println str.toUpperCase()
		println "Printing again in uppercase"
		println str.toUpperCase()
	}

}

class Man
{
	def help()
	{
		println "Man is helping"
	}
}

class Woman
{
	def help()
	{
		println "Woman is helping"
	}
}

class Elephant
{
	def help()
	{
		println "Elephant is helping"
	}
}
