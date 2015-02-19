var myApp = angular.module('myApp',['ngRoute','users','roles','profiles','login']);

myApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/login', {
              templateUrl: 'views/login.html',
              controller: 'LoginController'
          	}).
            when('/users', {
              templateUrl: 'views/users.html',
              controller: 'UserController'
            }).
            when('/roles', {
            	templateUrl: 'views/roles.html',
                controller: 'RoleController'
            }).
            when('/profile', {
            	templateUrl: 'views/profile.html',
                controller: 'ProfileController'
            }).
            when('/main', {
            	templateUrl: 'views/profile.html',
                controller: 'MainController'
            }).
            otherwise({
            	redirectTo: 'login'
            });
          
          $locationProvider.html5Mode(true); //Remove the '#' from URL.
}]);

myApp.factory('Auth', function(){
	var user;

	return {
	    setUser : function(aUser){
	    	console.log('setUser:'+aUser);
	        user = aUser;
	    },
	    isLoggedIn : function(){
	        return(user)? user : false;
	    }
	}
});
	
myApp.run(['$rootScope', '$location', 'Auth', function ($rootScope, $location, Auth) {
    $rootScope.$on('$routeChangeStart', function (event, next, current) {

        if (!Auth.isLoggedIn()) {
            console.log('DENY');
            event.preventDefault();
            $location.path('/login');
        }
        else {
            console.log('ALLOW');
           // $location.path('/users');
        }
    });
}]);

