var myApp = angular.module('myApp');

myApp.controller('HomeController', [ '$scope', '$resource', function ($scope, $resource) {
	$scope.hello = 'Im Home';
}]);


myApp.controller('ContactController', [ '$scope', 'ContactService', function ($scope, ContactService) {
	$scope.contacts = ContactService.query();	
}]);

myApp.controller('TodoController', [ '$scope', 'TodoService', function ($scope, TodoService) {
	
	$scope.newTodo = {};
	
	$scope.loadTodos = function(){
		$scope.todos = TodoService.query();
	};
	
	$scope.addTodo = function(){
		TodoService.save($scope.newTodo,
		function(value, responseHeaders) {
			$scope.newTodo = {};
			$scope.loadTodos();
		 },function(httpResponse) {
		      alert('Error saving Todo');
		});
	};
	
	$scope.deleteTodo = function(todo){
		TodoService.remove({id:todo.id},function(value, responseHeaders) {
			$scope.loadTodos();
		 },function(httpResponse) {
		      alert('Error deleting Todo');
		});
	};
	
	$scope.loadTodos();
}]);