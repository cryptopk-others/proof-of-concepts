var buzzAdminApp = angular.module('buzzAdminApp',['ngRoute']);

buzzAdminApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
            .when('/roles', {
            	templateUrl: 'static?page=admin/roles',
                controller: 'RoleController'
            })
            .otherwise({
            	redirectTo: '/roles'
            });
          
}]);


buzzAdminApp.controller('RoleController',['$scope','$http', function($scope, $http){
	
	console.log('-----------------RoleController----------------');
	
}]);