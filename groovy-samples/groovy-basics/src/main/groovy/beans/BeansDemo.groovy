/**
 * 
 */
package beans

import groovy.transform.Canonical
import groovy.transform.Immutable
import groovy.util.logging.Slf4j;

/**
 * @author skatam
 *
 */

def printMe(name, email = 'guest@gmail.com'){
	println "Name : $name, Email: $email"
}

printMe('siva')
printMe('siva','siva@gmail.com')
printMe 'he'
printMe 'he', 'he@man.com'

def (name1, name2) = ['siva', 'prasad']
println "$name1 $name2"

def p = new Person(name:'siva', email:'siv@gmail.com')
println p


class Worker{
	def work(){
		println'getworkdone'
	}
	def analyze(){
		println'analyze...'
	}
	def writeReport(){
		println'getreportwritten'
	}
}
class Expert{
	def analyze(){
		println"expertanalysis..."
	}
}
class Manager{
	@Delegate Expert expert=new Expert()
	@Delegate Worker worker=new Worker()
}
def bernie=new Manager()
bernie.analyze()
bernie.work()
bernie.writeReport()


@Immutable
class CreditCard{
	String cardNumber
	int creditLimit
}
println new CreditCard("4000-1111-2222-3333",1000)



class Heavy{
	def size=10
	Heavy(){
		println"Creating Heavy with $size"
	}
}
class AsNeeded{
	def value
	@Lazy Heavy heavy1=new Heavy()
	@Lazy Heavy heavy2={new Heavy(size:value)}()
	AsNeeded(){
		println "CreatedAsNeeded"
	}
}
def asNeeded=new AsNeeded(value:1000)
println asNeeded.heavy1.size
println asNeeded.heavy1.size
println asNeeded.heavy2.size

@Canonical
class Movie {
	def name
}

@Newify([Movie])
def printMoviesInfo(){
	def movie1 = Movie(name:'The Mummy')
	def movie2 = Movie.new(name:'The Mummy Returns')
	println movie1
	println movie2
}

printMoviesInfo();

@Singleton(lazy=true)
class TheUnique {
	//private TheUnique(){ println'Instancecreated' }
	def hello(){ println'hello' }
}

println"Accessing TheUnique"
TheUnique.instance.hello()
TheUnique.instance.hello()

@Slf4j
class LoggingTest
{
	def myMethod(){
		log.info('Hellooooo')
	}
}

LoggingTest lt = new LoggingTest()
lt.myMethod()
