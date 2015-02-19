angular.module('login',[])

.controller('LoginController', [ '$scope', 'Auth', '$location', function ($scope, Auth, $location) {
	  //submit
	
	console.log('LoginController');
	  $scope.doLogin = function () {
		  console.log('doLogin');
	    // Ask to the server, do your job and THEN set the user
		  var user = {username: 'siva', password: 'siva'};
	    Auth.setUser(user); //Update the state of the user in the app
	  };
	  
	  console.log('mainCtrl123');
	  $scope.$watch(Auth.isLoggedIn, function (value, oldValue) {
		console.log('$watch:'+value+":"+oldValue);
	    if(!value && oldValue) {
	      console.log("Disconnect");
	      $location.path('/login');
	    }

	    if(value) {
	      console.log("Connect");
	      $location.path('/users');
	    }

	  }, true);
}]);