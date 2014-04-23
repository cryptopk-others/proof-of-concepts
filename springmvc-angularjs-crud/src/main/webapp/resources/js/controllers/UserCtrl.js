
angular.module('users',[])
.controller('UserController',['$scope', '$http',function($scope, $http){
	
	$scope.loadUsers = function(){
		$http.get('rest/users/')
			.success(function(data, status, headers, config){
				$scope.users = data;
			})
			.error(function(data, status, headers, config){
				alert('Error');
			});
	};
	
	$scope.loadHome = function(){
		$scope.loadUsers();
		$scope.resetAll();
	};
	
	$scope.resetAll = function(){
		$scope.query = '';
		$scope.newUser = null;
		$scope.currentUser = null;
	};
	
	$scope.searchUsers = function(){
		$scope.newUser = null;
		$scope.currentUser = null;
		$http.get('rest/users/search?query='+$scope.query)
		.success(function(data, status, headers, config){
			$scope.users = data;
		});
		
		//$scope.loadHome();
	};
	
	$scope.newUserForm = function(){
		$scope.resetAll();
		$scope.newUser = { };
	};
	
	$scope.editUserForm = function(userId){
		$scope.resetAll();
		
		$http.get('rest/users/'+userId)
		.success(function(data, status, headers, config){
			$scope.currentUser = data;
		})
		.error(function(data, status, headers, config){
			alert('Error');
		});
	};
	

	$scope.createUser = function(){
		$http.post('rest/users/', $scope.newUser)
		.success(function(data, status, headers, config){
			$scope.loadHome();
		})
		.error(function(data, status, headers, config){
			alert('Error :'+data.error);
		});
		
	};
	
	$scope.updateUser = function(){
		$http.put('rest/users/',$scope.currentUser)
		.success(function(){
			$scope.loadHome();
		});
	};
	
	$scope.deleteUser = function(userId){
		$http.delete('rest/users/'+userId)
		.success(function(){
			$scope.loadHome();
		});
	};
	
	$scope.sortField = undefined;
	$scope.reverse = false;
	
	$scope.sort = function (fieldName) {
		if ($scope.sortField === fieldName) {
			$scope.reverse = !$scope.reverse;
		} else {
			$scope.sortField = fieldName;
			$scope.reverse = false;
		}
	};
		
	$scope.isSortUp = function (fieldName) {
		return $scope.sortField === fieldName && !$scope.reverse;
	};
		
	$scope.isSortDown = function (fieldName) {
		return $scope.sortField === fieldName && $scope.reverse;
	};
		
	$scope.loadHome();
}]);