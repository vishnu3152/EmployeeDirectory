<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<body>
	<div class="container">
	
	<div>
	<h1>Employee Directory</h1>
	<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
	</div>
	</div>
		
	<br/>
		
		<div class="row">
		
			<div class="col-md-4">
				<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">		<!-- We need to use here root name of the employee directory -->
				
				<div class="form-group">
					<input type="text" name="firstname" value="${employee.name}" placeholder="Enter Name" class="form-control"/><br>
				</div>
				<div class="form-group">
		    		<input type="date" name="dob" value="${employee.dob}" placeholder="Enter Date of Birth" class="form-control"/><br>
		    	</div>
		    	<div class="form-group">
					<input type="text" name="department" value="${employee.department}" placeholder="Enter Department" class="form-control"/><br>
				</div>
				<input type="hidden" value="${employee.id}" name="id"/>
				<button class="btn btn-primary" type="submit">Save Employee</button>    	<!-- For the action to get triggered we need to use button type=Submit -->
				</form>
			
			</div>
		
		</div>
		
	</div>
</body>
</html>