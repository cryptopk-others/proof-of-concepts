/*
var myApp = angular.module('myApp',['ngRoute']);

myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/home', {
              templateUrl: 'views/home.html',
              controller: 'HomeController'
          	}).
            when('/contacts', {
              templateUrl: 'views/contacts.html',
              controller: 'ContactsController'
            }).
            when('/todos', {
            	templateUrl: 'views/todos.html',
                controller: 'TodosController'
            })
           
            .otherwise({
            	redirectTo: 'home'
            });
          
          //$locationProvider.html5Mode(true); //Remove the '#' from URL.
}]);
*/

var myApp = angular.module('myApp',['ui.router']);

myApp.config(function($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.when('', '/home');
	$urlRouterProvider.otherwise('/home');
	
	$stateProvider
	.state('home', {
		url: '/home',
		templateUrl: 'views/home.html',
        controller: 'HomeController'
	})
	.state('contacts', {
		url: '/contacts',
		templateUrl: 'views/contacts.html',
        controller: 'ContactsController'
	})	
	.state('todos', {
		url: '/todos',
		templateUrl: 'views/todos.html',
        controller: 'TodosController'
	})
	.state('todos.create', {
		url: '/create',
		templateUrl: 'views/new_todo.html',
		controller: function($scope, $stateParams) {
			$scope.newTodo = {};
			
			$scope.createTodo = function(newTodoObj){
				console.log('new Todo: '+newTodoObj.description);
			}
		}
	})	
		
		
	});


myApp.run(['$rootScope', '$location', function ($rootScope, $location) {
	/*
    $rootScope.$on('$routeChangeStart', function (event, next, current) {
    	console.log($location.path());
    	//console.log(next.templateUrl +":"+current.templateUrl );
    	//var currentNavLink = '/home';
    	$rootScope.currentNavLink=$location.path();
    });
    */
	
	$rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
    		// We can prevent this state from completing
    		//evt.preventDefault();
		    $rootScope.currentNavLink=$location.path();
    });
    
}]);


myApp.directive('myDirective', function() {
	return {
		restrict: 'E',
		template: '<a href="http://google.com">Click me to go to Google</a>'
	}
});


myApp.directive('fancyLink', function() {
	return {
		restrict: 'EAC',
		replace: true,
		scope: {
			myUrl: '@someAttr', // binding strategy
			myLinkText: '@' // binding strategy
		},
		template: '<a href="{{myUrl}}">{{myLinkText}}</a>'
	}
});
