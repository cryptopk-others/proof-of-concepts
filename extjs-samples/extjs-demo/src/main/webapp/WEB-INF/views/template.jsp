<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<html>
<head>
<title>ExtJS </title>
<link rel="stylesheet" type="text/css" href="resources/extjs/resources/css/ext-all.css">
<script type="text/javascript" src="resources/extjs/ext-all.js"></script>
<c:forEach var="script" items="${scripts}">
  <script type="text/javascript" src="resources/js/${script}.js"></script>
</c:forEach>


</head>
<body>
  <p><a href="welcome">Home</a> </p>
</body>
</html>