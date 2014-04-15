var phonebookServices = angular.module('phonebookServices', ['ngResource']);
 
phonebookServices.factory('PhoneBook', ['$resource',
  function($resource){
    return $resource('users/list', {}, {
      query: {method:'GET', params:{}, isArray: true}
    });
  }]);