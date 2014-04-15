<!doctype html>
<html lang="en" ng-app="phonebookApp">
<head>
  <meta charset="utf-8">
  <title>My HTML File</title>
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
  <script src="resources/jquery/jquery-1.10.2.js"></script>
  <script src="resources/bootstrap/js/bootstrap.js"></script>
  
  <script src="resources/angularjs/angular.js"></script>
  <script src="resources/angularjs/angular-resource.js"></script>
  
  <link rel="stylesheet" href="resources/css/styles.css">
  <script src="resources/js/controllers.js"></script>
  <script src="resources/js/services.js"></script>
  <script src="resources/js/app.js"></script>
  
  <script type="text/javascript">
	
  </script>
</head>
<body >
 
 
 
 <div ng-controller="PhonebookListCtrl">
 <ul >
    <li ng-repeat="contact in contacts">
      
      <p>{{contact.firstName}} {{contact.lastName}}</p>
    </li>
  </ul>
  
  <pre>{{someObject | json}}</pre>.
  
 </div>
 

 
</body>
</html>