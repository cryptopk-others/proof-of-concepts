var myApp = angular.module('myApp', ['ngRoute','ngResource', 'myAppControllers', 'myAppServices']);

myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
             $routeProvider
                 .when('/welcome', {
                     templateUrl: 'views/welcome.html',
                     controller: 'WelcomeCtrl'
                 })
                  .when('/error', {
                      templateUrl: 'views/error.html'
                  })
                  .otherwise({
                 	 redirectTo: '/welcome'
                  });
 		}
]);

myApp.run(function($rootScope, $location) {
	
	$rootScope.$on('$routeChangeStart', function (event, next, current) {
		console.log('Current:'+current+', Next: '+next);
        
    });
	

	
});