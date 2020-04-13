<html>
	<head>
		<title>
		
		</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">	
	</head>
	<body>
	
	<%
	
		String email=(String)request.getAttribute("email");
	
		// If user is already logged in redirect it to List Employees
		if(email !=null)
		{
			response.sendRedirect("EmployeeController?action=LIST");
		}
	
		String status=request.getParameter("status");
		
		if(status!=null)
		{
			if(status.equals("false"))
			{
				out.print("Bad Credentials");
			}
			else if(status.equals("error"))
			{
				out.print("Some error Occured");
			}
		}
	%>
	
		<div class="container">
		<form action="loginprocess" method="POST">
			<div class="card">
				<div class="card-header">
					Login
				</div>
				<div class="card-body">
					<div class="form-group">
						<input type="text" name="email" class="form-control" placeholder="Enter Email"/><br>
					</div>
					<div class="form-group">
						<input type="password" name="password" class="form-control" placeholder="Enter Password"/><br>
					</div>
				</div>
				<div class="card-footer">
					<input type="submit" value="login" class="btn btn-primary"/>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>