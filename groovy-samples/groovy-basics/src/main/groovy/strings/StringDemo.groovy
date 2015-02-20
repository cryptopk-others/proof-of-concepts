/**
 * 
 */
package strings

/**
 * @author skatam
 *
 */

//def name ='', profession = ''
def quote = "${ -> name} is a ${ -> profession}"
def nameProfMap = ['siva':'Developer','prasad':'Writer']
nameProfMap.each { key, val ->
	name = key
	profession = val
	println quote	
}