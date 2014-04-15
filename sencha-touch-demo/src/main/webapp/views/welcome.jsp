<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<html>
<head>
<title>Welcome</title>
<link rel="stylesheet" href='<spring:url value="resources/touch-2.3.0/resources/css/sencha-touch.css"/>' />
<script type="text/javascript" src='<spring:url value="resources/touch-2.3.0/sencha-touch-all.js"/>'></script>
<script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
<script type="text/javascript">
Ext.Loader.setConfig({
	  enabled : true,
	  paths : {
	      MyApp : 'MyApp'
	  }
	  });
	  
	  Ext.require([
	   'MyApp.MainContainer'
	  ]);
	  
	  Ext.application({
	    launch : function () {
	      Ext.create('MyApp.MainContainer', {
	       fullscreen : true
	      });
	    }
	  });
</script>
</head>
<body>
</body>
</html>