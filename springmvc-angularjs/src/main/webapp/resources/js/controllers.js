var phonebookControllers = angular.module('phonebookControllers', []);
 
phonebookControllers.controller('PhonebookListCtrl', ['$scope', 'PhoneBook', 
        function($scope, PhoneBook){
			var resp = PhoneBook.query();
			$scope.contacts = resp;

			$scope.someObject = {
					'id':'1', 'name':'siva', 'address':{'city':'Hyd', 'state':'AP'}, 'emails':['a@mail.com','b@mail.com']
				};
			
		}
]);
  
  
  
