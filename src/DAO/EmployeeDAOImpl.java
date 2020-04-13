package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Employee;
import Util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement=null;
	ResultSet resultSet=null;
	PreparedStatement preparedStatement=null;
	
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

	@Override
	public boolean save(Employee e) {
		boolean flag=false;
		
		try {
			String sql="INSERT into tbl_employee(name,dob,department) VALUES('"+e.getName()+"','"+e.getDob()+"','"+e.getDepartment()+"')";
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}catch(SQLException e1) {
		e1.printStackTrace();
	}
		return flag;
}

	@Override
	public Employee get(int id) {
		Employee employee=null;
		try {
			employee=new Employee();
			String sql="SELECT * from tbl_employee where id="+id;
			connection=DBConnectionUtil.openConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
			{
				employee=new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
				
			}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return employee;
		
	}

	@Override
	public boolean update(Employee e) {
		boolean flag=false;
		try {
			String sql="update tbl_employee SET name='"+e.getName()+"',dob='"+e.getDob()+"',department='"+e.getDepartment()+"'where id="+e.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean delete(int id) {
		boolean flag=false;
		try {
			String sql="DELETE from tbl_employee where id="+id;	
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
			
		return flag;
	}
}