
angular.module('myApp.controllers', [])
.controller('MovieListCtrl', ['$scope', 'rtmFactory',
    function($scope, rtmFactory) {
		$scope.countries = rtmFactory.getCountries();
		$scope.loadMovies = function(countryCode) {
			rtmFactory.getMovies(countryCode).then(
				function(response) {
					var movieArray = response.data.movies;
					console.log(JSON.stringify(movieArray))
					$scope.movies = movieArray;
				},
				function(response) {
					alert('error');
				}
		);
    };
	$scope.loadMovies('us');
	}
])

;