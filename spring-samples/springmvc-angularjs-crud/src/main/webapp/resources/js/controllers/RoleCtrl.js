
angular.module('roles',[])

.controller('RoleController',['$scope', '$http', function($scope, $http){
	
	$scope.loadRoles = function(){
		$http.get('rest/roles/')
			.success(function(data, status, headers, config){
				$scope.roles = data;
			})
			.error(function(data, status, headers, config){
				alert('Error');
			});
	};
	
	$scope.selectRole = function (role) {
		$scope.selectedRole = role;
	};
	
	$scope.hasSelectedRole = function () {
		//console.log($scope.selectedRole != null);
		return $scope.selectedRole != null;
	};
	
	$scope.showNewRoleForm = function(){
		$scope.newRole = {};
	}
	$scope.loadRoles();
}]);