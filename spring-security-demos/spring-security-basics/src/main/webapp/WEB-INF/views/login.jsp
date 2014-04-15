<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href='<spring:url value="resources/css/styles.css"/>' />
<script type="text/javascript" src='<spring:url value="resources/jquery/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
	
});
</script>
</head>
<body>
		<div>	
		<c:if test="${ERROR != null}">
             <div>
                 ${ERROR}
             </div>
         </c:if>
         <c:if test="${msg != null}">
             <div>
                 ${msg}
             </div>
         </c:if>	
         </div>  
            
		<div>	
			<h2>User Login Form</h2>
			<form:form id="loginForm" method="post" action="login" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;">
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
		  
		</form:form>
	</div>

	
</body>
</html>