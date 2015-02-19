angular.module('myApp.services',[])

.factory('ContactService', function($resource){
	return $resource('contacts/:id');
	
})

.factory('TodoService', function($resource){
	return $resource('todos/:id');
})

;