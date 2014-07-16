var myAppServices = angular.module('myAppServices', ['ngResource']);
 
myAppServices.factory('PhoneBook', ['$resource',
  function($resource){
    return $resource('users/list', {}, {
      query: {method:'GET', params:{}, isArray: true}
    });
  }]);