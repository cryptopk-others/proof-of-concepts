var myApp = angular.module('myApp',['ngRoute','users','roles','profiles']);

myApp.config(['$routeProvider',
        function($routeProvider) {
          $routeProvider.
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
            otherwise({
              redirectTo: '/users'
            });
}]);

