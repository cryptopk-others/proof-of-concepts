
var myApp = angular.module('myApp',['ngResource','ui.router','myApp.services']);

myApp.config(function($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.when('', '/home');
	$urlRouterProvider.otherwise('/home');
	
	$stateProvider
	.state('home', {
		url: '/home',
		templateUrl: 'templates/home.html',
        controller: 'HomeController'
	})
	.state('contacts', {
		url: '/contacts',
		templateUrl: 'templates/contacts.html',
        controller: 'ContactController'
	})	
	.state('todos', {
		url: '/todos',
		templateUrl: 'templates/todos.html',
        controller: 'TodoController'
	})
	.state('todos.create', {
		url: '/create',
		templateUrl: 'templates/newTodo.html',
		controller: function($scope, $stateParams, $resource) {
			$scope.newTodo = {};
			
			$scope.createTodo = function(newTodoObj){
				console.log('new Todo: '+newTodoObj.description);
				$resource('todos').save(newTodoObj, function(data){
					alert('Saved successfully');
				},function(data){
					alert('Failed to save Todo');
				});
			}
		}
	})	
		
});

myApp.run(['$rootScope', '$location', function ($rootScope, $location) {
	
	$rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
		// We can prevent this state from completing
		//evt.preventDefault();
	    $rootScope.currentNavLink=$location.path();
	});

}]);

