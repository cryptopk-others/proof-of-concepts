package com.sivalabs.groovy.basics

class FileIO {

	static main(args) {

		def file = new File('.')
		println file.name
		println file.absolutePath
		println file.canonicalPath
		println file.directory
	}
}
