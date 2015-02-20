package strings

def file = new File('E:/names.txt')
//println file.text

def list = []
file.eachLine { line ->
	def name = line.split(',')[0].trim();
	//println name.toLowerCase() - name.reverse().toLowerCase()
	if(name.toLowerCase() == name.reverse().toLowerCase()){
		println name + ":"+line
	}
}

