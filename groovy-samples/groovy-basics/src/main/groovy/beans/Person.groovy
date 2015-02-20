/**
 * 
 */
package beans

import groovy.transform.Canonical

/**
 * @author skatam
 *
 */
@Canonical(includes="email")
class Person {

	def name
	def email
	
	def printMe(name, email = 'guest@gmail.com'){
		println "Name : $name, Email: $email"
	}
	
}

