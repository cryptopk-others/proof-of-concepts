/**
 * 
 */
package collections

/**
 * @author skatam
 *
 */

def list1 = [1,2,3,4,5]
println list1.dump()


list1.each {
	print it +" "
}
println ''

def total = 0
list1.each {
	total += it
}
println "Total : $total"

for(i in list1){
	println i
}
println '------Reverse------'
for(int j=1;j<= list1.size(); j++){
	println list1[-j]
}

println list1[2..4]

println list1.collect { it * 2}
println list1.find { it > 2 }
println list1.findAll { it > 2 }

println list1.sum()

println list1.inject(0){carryOver,element -> carryOver + element}

println list1.join(':')

def lst1 = [['k','siva'],['prasad']]
println lst1
println lst1.flatten()


def langs=['C++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy']
langs.each{entry->
println "Language $entry.key was authored by $entry.value"
}

langs.each{language,author->
	println"Language$language was authored by $author"
}
