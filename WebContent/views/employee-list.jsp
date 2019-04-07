<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
		
		<th>Name</th>
		<th>DOB</th>
		<th>Department</th>
		
		</tr>
		
		<c:forEach items="${list}" var="employee">
		
		<tr>
			<td>${employee.name}</td>
			<td>${employee.dob}</td>
			<td>${employee.department}</td>
		</tr>
		
		</c:forEach>
	
	</table>
	
</body>
</html>