<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
<script type="text/javascript">
	$(document).ready(function() {
	
		
	});
</script>
</head>
<body>
	Welcome
	<c:url var="logoutUrl" value="/logout"/>
	<a href="${logoutUrl}">Logout</a>

    
</body>
</html>