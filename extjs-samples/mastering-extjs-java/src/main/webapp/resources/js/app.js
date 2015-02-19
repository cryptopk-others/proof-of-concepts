
var myApp = angular.module('myApp',[]);

myApp.controller('HelloCtrl', function($scope, $http){
	$scope.hello = 'Hello World';
});