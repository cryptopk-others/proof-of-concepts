<!DOCTYPE html>
<%@ include file="taglib.jsp" %>
<html ng-app="myApp">
<head>
<base href="${rootURL}">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SivaLabs</title>
        
        <script type="text/javascript" src="webjars/jquery/1.9.0/jquery.js"></script>
        <link rel="stylesheet" href="webjars/bootstrap/3.1.0/css/bootstrap.min.css" />
        <link rel="stylesheet" href="webjars/bootstrap/3.1.0/css/bootstrap-theme.min.css" />
        <script type="text/javascript" src="webjars/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.2.14/angular.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.2.14/angular-route.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.2.14/angular-resource.js"></script>
        
        
        <link rel="stylesheet" href="resources/css/styles.css" />
        <script type="text/javascript" src="resources/js/app.js"></script>
        
</head>
<body>

 <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="welcome">SivaLabs</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="welcome">Home</a></li>
            <li><a href="admin">Administration</a></li>
            <li><a href="contact">Contact</a></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->
    
    
    <div class="container" ng-controller="HelloCtrl">    
                 
          <div class="row">
                  <div class="span12">
                 	<span>{{hello}}</span>   
                  </div>
          </div>
    
    </div>
</body>
</html>