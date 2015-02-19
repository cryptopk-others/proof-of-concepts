'use strict';

/**
 * @ngdoc function
 * @name hlApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the hlApp
 */
angular.module('hlApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
