'use strict';

/**
 * @ngdoc function
 * @name hlApp.controller:SubscribersCtrl
 * @description
 * # SubscribersCtrl
 * Controller of the hlApp
 */
angular.module('hlApp')
  .controller('SubscribersCtrl', function ($scope,$http, $modal) {
		$http.get('subscribers.json').success(function(data){
		   $scope.subscribers =data
		});
		
		$scope.gridOptions = { 
			data: 'subscribers',
			showGroupPanel: true,
			//jqueryUIDraggable: true,
			enableCellSelection: true,
			enableRowSelection: false,
			enableCellEdit: true,
			columnDefs: [
				{field:'no', displayName:'No.'}, 
				{field:'name', displayName:'Name'}, 
				{field:'userType', displayName:'Subscription Type'}, 
				{field:'loyalty', displayName:'Loyalty Score'},
				{field:'joinDate', displayName:'Date of Joining'}
				]
		};
		
		$scope.showModal=function () {
			$scope.newUser={};
			var modalInstance = $modal.open({
				templateUrl: 'views/add-user.html',
				controller:'AddNewUserCtrl',
				resolve: {
				   newUser: function () {
					return $scope.newUser;
				   }
				}
			});
			modalInstance.result.then(function (selectedItem) {
				$scope.subscribers.push({
				no:$scope.subscribers.length+1,
				name:$scope.newUser.name,
				 userType:$scope.newUser.userType,
				loyalty:$scope.newUser.loyalty,
				joinDate:$scope.newUser.joinDate

				  });
			});
	
		};
	  
	  
	  
})

.controller('AddNewUserCtrl', function ($scope, $modalInstance, newUser) {
$scope.newUser=newUser;
$scope.saveNewUser=function(){
  $modalInstance.close(newUser);
};
$scope.cancel =function(){
    $modalInstance.dismiss('cancel');
  };
})

;
