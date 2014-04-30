var buzzApp = angular.module('buzzApp',['ngRoute']);

buzzApp.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
            .when('/home', {
            	templateUrl: 'static?page=home',
                controller: 'HomeController'
            })
            .otherwise({
            	redirectTo: '/home'
            });
          
}]);


buzzApp.controller('HomeController',['$scope','$http', function($scope, $http){
	
	$scope.loadMessages = function(page){
		$http.get('rest/messages?page='+page)
			.success(function(data, status, headers, config){
				$scope.msgsPage = data;
			})
			.error(function(data, status, headers, config){
				alert('Error');
			});
	};
	
	$scope.loadMessages(0);
	
}]);