<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<base href="${rootUrl}"/>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="resources/css/styles.css" />
<script type="text/javascript" src="resources/js/app.js"></script>
        
        
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
	
});
</script>
</head>
<body>
		<div class="col-md-6 col-md-offset-3">
			<c:if test="${param.error != null}">
				<div class="alert alert-error">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
						Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</c:if>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
		</div>  
        <c:url value="/login" var="loginUrl"/>    
		<div class="col-md-6 col-md-offset-3">	
			<form id="loginForm" method="post" action="${loginUrl}">
			<h2>User Login Form</h2>
			<table>
			  <tr>
			    <td>UserName</td>
			    <td><input type="text" id="username" name="username" placeholder="UserName" /></td>
			  </tr>
			  <tr>
			    <td>Password</td>
			    <td><input type="password" id="password" name="password" placeholder="Password" /></td>
			  </tr>
			  <tr>
			    <td><input type="submit" value="Login"></td>
			    <td></td>
			  </tr>
			  <tr>
			    <td>New User? <a href="register">Register</a></td>
			    <td></td>
			  </tr>
			  
			</table>
		  
		</form>
	</div>

	
</body>
</html>