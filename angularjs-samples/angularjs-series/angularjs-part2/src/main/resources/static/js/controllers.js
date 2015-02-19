var myApp = angular.module('myApp');

myApp.controller('HomeController', [ '$scope', '$http', function ($scope, $http) {
	$scope.hello = 'Im Home';
}]);


myApp.controller('ContactController', [ '$scope', 'ContactService', function ($scope, ContactService) {
	
	ContactService.getContacts().then(function(data) {
		$scope.contacts = data;
	});
	
	}
]);

myApp.controller('TodoController', [ '$scope', 'TodoService', function ($scope, TodoService) {
	
	$scope.newTodo = {};
	
	$scope.loadTodos = function(){
		TodoService.loadTodos().
		success(function(data, status, headers, config) {
			$scope.todos = data;
		 })
		.error(function(data, status, headers, config) {
		      alert('Error loading Todos');
		});
	};
	
	$scope.addTodo = function(){
		TodoService.createTodo($scope.newTodo).
		success(function(data, status, headers, config) {
			$scope.newTodo = {};
			$scope.loadTodos();
		 })
		.error(function(data, status, headers, config) {
		      alert('Error saving Todo');
		});
	};
	
	$scope.deleteTodo = function(todo){
		TodoService.deleteTodo(todo.id).
		success(function(data, status, headers, config) {
			$scope.loadTodos();
		 })
		.error(function(data, status, headers, config) {
		      alert('Error deleting Todo');
		});
	};
	
	$scope.loadTodos();
}]);
