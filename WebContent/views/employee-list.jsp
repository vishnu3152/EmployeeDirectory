<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!--<link href="https://unpkg.com/browse/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
 
<body>

	<%
		
		String email=(String)session.getAttribute("email");
	
		if(email == null)
		{
			response.sendRedirect("index.jsp");
		}
	
	%>
	
	<div class="container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
		<table border="1" class="table table-striped table-bordered" id="datatable">
		<thead>
			<tr class="thead-dark">
			<th>Name</th>
			<th>DOB</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="employee">
		
		<tr>
			<td>${employee.name}</td>
			<td>${employee.dob}</td>
			<td>${employee.department}</td>
			<td>
				<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
				|
				<a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
			</td>
		</tr>
		
		</c:forEach>
		</tbody>
	
	</table>
	
	</div>
	
	<script src="https://unpkg.com/jquery@3.4.0/dist/jquery.min.js"></script> <!-- This should be first before Data tables as Data tables depends in jquerymin.js -->
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
	<!-- Anonymous function which is a callback function, Here Data table is the Zero Configuration -->
	<script>
		$(document).ready(function(){
			$("#datatable").DataTable();
		})
	</script>
	
</body>
</html>