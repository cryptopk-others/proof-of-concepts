angular.module('myApp.controllers',[])

.controller('HomeController', [ '$scope', function ($scope) {
	$scope.hello = 'Im Home';
}])


.controller('ContactController', [ '$scope', 'ContactService', function ($scope, ContactService) {
	$scope.contacts = ContactService.getAll();	
}])

.controller('TodoController', [ '$scope', '$state','$stateParams', 'Restangular', 
    function ($scope, $state, $stateParams, Restangular) {
       var Todos = Restangular.all('todos');
       
       //console.log('ctrl $stateParams.id ->'+$stateParams.id+":"+$state.params.id);
       if($state.params.id){
           Todos.get($state.params.id).then(function(todo){
               $scope.editTodoObj = Restangular.copy(todo);
                //console.log($scope.editTodoObj);
           });
           
       }
       
       $scope.newTodo = {};
       $scope.loadTodos = function(){
           $scope.todos = Todos.getList().$object;
       };
       $scope.createTodo = function(todo){
                console.log('new Todo: '+todo.description);
                Todos.post(todo).then(function(data){
                        //alert('Saved successfully');
                        $scope.newTodo = {};
                        $scope.loadTodos();
                },function(data){
                        alert('Failed to save Todo');
                });
        };
        $scope.editTodo = function(todo){
            $scope.editTodoObj = Restangular.copy(todo);
            $state.transitionTo('todos.edit',{id: $scope.editTodoObj.id});
        };
        
        $scope.saveTodo = function(todo){
            console.log('Update Todo: '+todo.description);
                        todo.put().then(function(data){
                        //alert('Saved successfully');
                        $scope.editTodoObj = {};
                        $scope.loadTodos();
                },function(data){
                        alert('Failed to save Todo');
                });
        };
        $scope.deleteTodo = function(todo){
            todo.remove().then(function(){
                //$state.transitionTo('todos');
                $scope.loadTodos();
            });
            
        };
       $scope.loadTodos();
}])

;
