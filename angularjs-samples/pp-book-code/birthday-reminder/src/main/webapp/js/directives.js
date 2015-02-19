'use strict';

angular.module('myApp.directives', []).
  directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
  }])
.directive('myFacebook', [
  function() {
    return {
      link: function(scope, element, attrs) {

        // Load the SDK asynchronously
        (function(d) {
          var js, id = 'facebook-jssdk',
            ref = d.getElementsByTagName('script')[0];
          if (d.getElementById(id)) {
            return;
          }
          js = d.createElement('script');
          js.id = id;
          js.async = true;
          js.src = "//connect.facebook.net/en_US/all.js";
          ref.parentNode.insertBefore(js, ref);
        }(document));

        // Initialize FB
		window.fbAsyncInit = function() {
          FB.init({
            appId: '1468931716711592',
            status: true, // check login status
            cookie: true, // enable cookies to access the session
            xfbml: false // parse XFBML
          });

          //Check FB Status

          FB.getLoginStatus(function(response) {
            console.log(response);
			if (response.status == 'connected') {
				scope.logged = true;
				FB.api('/me', function(response) {
					scope.$apply(function() {
						scope.username = response.name;
					});
					console.log(scope.username);
					scope.loadFriends();
				});
			} else {
				FB.login(function(response) { }, { scope: scope.permissions });
			}
          });

        };

        scope.username = "John Doe";
      },
	  scope: {
		  permissions: '@',
		  myFriends: '=friends'
	  },
      templateUrl: 'partials/greeting.html',
	  controller: function($scope) {
        $scope.loadFriends = function() {

          FB.api('/me/friends?fields=birthday,name,picture', function(response) {
            $scope.$apply(function() {
				var birthdayDate, day;
				var currentYear = new Date().getFullYear();
				var today = new Date().valueOf();
				response.data.forEach(function(data) {
					if (data.birthday) {
						day = data.birthday.split("/");
						birthdayDate = new Date(currentYear, day[0] - 1, day[1]);
						if (birthdayDate.valueOf() < today) {
							birthdayDate.setFullYear(currentYear + 1);
						}
						data.fromToday = birthdayDate.valueOf() - today;
						data.birthdayDate = birthdayDate;
					}
				});
              $scope.myFriends = response.data;
              console.log($scope.myFriends);
            });

          });
        };
		
		$scope.myLogin = function() {
			FB.login(function(response) {
			   }, {
				scope: $scope.permissions
			  });
		};
  
  
      }
	  
    };
  }
]);