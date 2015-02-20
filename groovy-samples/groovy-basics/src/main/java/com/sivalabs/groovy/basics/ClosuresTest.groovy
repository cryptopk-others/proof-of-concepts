package com.sivalabs.groovy.basics

/**
 * @author Siva
 *
 */
//class ClosuresTest {

//static main(args) {

//}

//}

def pickEven(n, block) {
	for(int i = 2; i <= n; i += 2) {
		block(i)
	}
}
pickEven(10, { print it + " "} )
println ""
pickEven(10) { print it + " "}
println ""
pickEven(10) { evenNum -> print evenNum + " "}
println ""

total = 0
pickEven(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"

product = 1
pickEven(10) { product *= it }
println "Product of even numbers from 1 to 10 is ${product}"

def totalSelectValues(n, closure) {
	total = 0
	for(i in 1..n) {
		if (closure(i)) { total += i }
	}
	total
}
print "Total of even numbers from 1 to 10 is "
println totalSelectValues(10) { it % 2 == 0 }
def isOdd = { it % 2 != 0}
print "Total of odd numbers from 1 to 10 is "
println totalSelectValues(10, isOdd)


class Equipment {
	def calculator
	Equipment(calc) { calculator = calc }
	def simulate() {
	println "Running simulation"
	calculator() // We may send parameters as well
	}
	}

def eq1 = new Equipment({ println "Calculator 1" })
def aCalculator = { println "Calculator 2" }
def eq2 = new Equipment(aCalculator)
def eq3 = new Equipment(aCalculator)
eq1.simulate()
eq2.simulate()
eq3.simulate()



class Resource {
	def static use(closure) {
		def r = new Resource()
		try {
			r.open()
			closure(r)
		} finally {
			r.close()
		}
	}
	
	def open() { print "opened..." }
	def close() { print "closed" }
	def read() { print "read..." }
	def write() { print "write..." }
}

Resource.use { res ->
	res.read()
	res.write()
}

