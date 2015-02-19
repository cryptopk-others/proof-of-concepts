var myApp = angular.module('myApp')

myApp.service('ContactService', function($http){
	this.getContacts = function(){
			var promise = $http.get('contacts')
								.then(function(response){
									return response.data;
								},function(response){
									alert('error');
								});
			return promise;
		};
});

myApp.factory('TodoService', function($http){
	return {
		loadTodos : function(){
			return $http.get('todos');
		},
		
		createTodo: function(todo){
			return $http.post('todos',todo);
		},
		
		deleteTodo: function(id){
			return $http.delete('todos/'+id);
		}		
	}
})

;