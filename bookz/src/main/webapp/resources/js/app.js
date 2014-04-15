var bookwormsApp = angular.module('bookwormsApp',[]);

bookwormsApp.controller('AuthorCtrl',['$scope','$http', function($scope, $http){
	$scope.name = 'Siva Prasad Reddy';	
	
	$http.get('authors/').success(function(response) {
	    $scope.authors = response.data;
	    $scope.totalRecords = $scope.authors.length;
	  });
	
	$scope.edit = function(author){
		//alert(id);
		$scope.editAuthor = author;//{id: id, name: 'Me', email: 'me@me'};
	};
	
	$scope.deleteA = function(author){
		alert("Delete Author: "+author.id);
	};
	
	
}]);