angular.module('profiles',[])
.controller('ProfileController',['$scope', '$http',function($scope, $http){
	$scope.genderOptions = [
	                        { key: 'M', label: 'Male' },
	                        { key: 'F', label: 'Female' }
	                        ];
	
	$scope.countriesOptions = {
			'IND': 'India',
			'USA': 'United States',
			'UK': 'United Kingdom'
	};
	
	$scope.canSave = function() {
		return $scope.userInfoForm.$dirty &&
		$scope.userInfoForm.$valid;
	};
	
	$scope.getCssClasses = function(ngModelContoller) {
		return {
			error: ngModelContoller.$invalid && ngModelContoller.$dirty,
			success: ngModelContoller.$valid && ngModelContoller.$dirty
		};
	};
	
	$scope.showError = function(ngModelController, error) {
		return ngModelController.$error[error];
	};
		
}]);