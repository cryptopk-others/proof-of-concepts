var myApp = angular.module('myApp');

myApp.controller('HomeController', [ '$scope', '$http', function ($scope, $http) {
	$scope.hello = 'Im Home';
}]);


myApp.controller('ContactsController', [ '$scope', '$http', function ($scope, $http) {
	
	$http.get('contacts/list')
	.success(function(data){
		$scope.contacts = data;
	})
	.error(function(data){
		alert('error');
	});
	
	
}]);

myApp.controller('TodosController', [ '$scope', '$http', function ($scope, $http) {
	console.log('---------TodosController-------------');
	$http.get('todos/list')
	.success(function(data){
		$scope.todos = data;
	})
	.error(function(data){
		alert('error');
	});
	
}]);
