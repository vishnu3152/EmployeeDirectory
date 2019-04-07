package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Employee;
import Util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	@Override
	public List<Employee> get() {
		
		// create a reference variable
		
		List<Employee> list=null;
		Employee employee=null;
		
		try {
		
			list=new ArrayList<Employee>();
		
		// Create a sql query
			
			String query="select * from tbl_employee";
		
		// Get the DB connection
			connection=DBConnectionUtil.openConnection();
		
		// Create a statement
			statement=connection.createStatement();
		
		// Execute the SQL query
			resultSet = statement.executeQuery(query);
			
		//process the resultSet
			while(resultSet.next())
			{
				
				employee=new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
				
				
				// Add employee to the list
				list.add(employee);
				
			}

		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// return the list
		
		return list;
	}

}
