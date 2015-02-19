
var myApp = angular.module('myApp',['ngRoute']);

myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/home', {
              templateUrl: 'templates/home.html',
              controller: 'HomeController'
          	}).
            when('/contacts', {
              templateUrl: 'templates/contacts.html',
              controller: 'ContactController'
            }).
            when('/todos', {
            	templateUrl: 'templates/todos.html',
                controller: 'TodoController'
            })
           
            .otherwise({
            	redirectTo: 'home'
            });
          
          //$locationProvider.html5Mode(true); //Remove the '#' from URL.
}]);


myApp.run(['$rootScope', '$location', function ($rootScope, $location) {
	
    $rootScope.$on('$routeChangeStart', function (event, next, current) {
    	//console.log($location.path());
    	//console.log(next.templateUrl +":"+current.templateUrl );
    	//var currentNavLink = '/home';
    	$rootScope.currentNavLink=$location.path();
    });

}]);

