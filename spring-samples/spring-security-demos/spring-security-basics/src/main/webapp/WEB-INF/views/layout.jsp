<!DOCTYPE html>
<%@ include file="taglib.jsp" %>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SivaLabs</title>
<base href="${rootUrl}"/>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="resources/css/styles.css" />
<script type="text/javascript" src="resources/js/app.js"></script>
 
<decorator:head/>        
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
        <sec:authorize access="authenticated" var="authenticated"/>
        <div class="collapse navbar-collapse">
        	<ul class="nav navbar-nav navbar-right">
	        <c:choose>
	        	<c:when test="${authenticated}">
			            <li class="active"><a href="#">Welcome <sec:authentication property="principal.name" /></a></li>
			            <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="admin">Administration</a></li></sec:authorize>
			            <li><a href="#contact">Contact</a></li>
			            <li><a href="logout">Logout</a></li>
	        	</c:when>
	        	<c:otherwise>
			            <li class="active"><a href="login/form">Login</a></li>
			            <li><a href="register">Register</a></li>
	        	</c:otherwise>
	        </c:choose>
	        </ul>
        </div>

      </div><!-- /.container -->
    </div><!-- /.navbar -->
    
    
    <div class="container">    
                 
          <div class="row">
                  <div class="span12">
                    <decorator:body/>
                  </div>
          </div>
    
    </div>
</body>
</html>