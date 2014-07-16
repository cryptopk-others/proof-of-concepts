var myAppControllers = angular.module('myAppControllers', []);
 
myAppControllers.controller('WelcomeCtrl', ['$scope', 'PhoneBook', 
        function($scope, PhoneBook){
			var resp = PhoneBook.query();
			$scope.contacts = resp;

			
			
		}
]);
  
  
  
