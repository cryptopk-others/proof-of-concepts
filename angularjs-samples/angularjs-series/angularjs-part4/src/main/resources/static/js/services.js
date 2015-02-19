angular.module('myApp.services',[])

.factory('ContactService', function(Restangular){
	var Contacts = Restangular.all('contacts');
	
	return {
		getAll : function(){
			return Contacts.getList().$object;
		}
	};
	
})

.factory('TodoService', function(Restangular){
	var Todos = Restangular.all('todos');
	return {
		getAll : function(){
			return Todos.getList().$object;
		},
                
                create : function(todo){
                    return Todos.post(todo);
                },
                
                update : function(todo){
                    return todo.put();
                }
	}
})

;