<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html ng-app="bookwormsApp">
<head>
<title>Welcome</title>
<c:url var="rootURL" value="/"/>

<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript" src="${rootURL}resources/angularjs/angular.js"></script>
<script type="text/javascript" src="${rootURL}resources/angularjs/angular-resource.js"></script>
<script type="text/javascript" src="${rootURL}resources/angularjs/angular-route.js"></script>
<script type="text/javascript" src="${rootURL}resources/angularjs/angular-cookies.js"></script>

<script type="text/javascript" src="${rootURL}resources/js/app.js"></script>

<script type="text/javascript">
	/*
	var AuthorCtrl = function($scope)
	{
		$scope.name = 'Siva Prasad';	

	};
*/
	 
</script>
</head>
<body ng-controller="AuthorCtrl">

	<div class="col-md-6 col-md-offset-3">
	
	Total : {{totalRecords}}
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Edit/Delete</th>
			</tr>
		</thead>
		<tbody>
		<tr ng-repeat="author in authors">
			<td>{{author.id}}</td>
			<td>{{author.name}}</td>
			<td>{{author.email}}</td>
			<td>
				<button ng-click="edit(author)">Edit</button>
				<button ng-click="deleteA(author)">Delete</button>
				
			</td>
		</tr>
		
		</tbody>
	</table>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Author Detail</h3>
			</div>
			<div class="panel-body">
				<form id="registrationForm" method="post" action="#"
					style="width: 800px; margin: 0 auto;" class="form-horizontal"
					role="form">
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email*</label>
						<div class="col-sm-4">
							<input type="text" id="email" name="email" ng-model="editAuthor.email"
								class="form-control" placeholder="Email" />
							<form:errors path="email" />
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name*</label>
						<div class="col-sm-4">
							<input type="text" id="name" name="name" ng-model="editAuthor.name"
									 class="form-control" placeholder="Name" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-4">
							<input type="submit" class="btn btn-primary" value="Register">
						</div>
					</div>


				</form>

			</div>
		</div>

	</div>


	</body>
	</html>