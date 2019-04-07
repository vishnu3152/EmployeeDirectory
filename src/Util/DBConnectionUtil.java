package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	
	// Define the database properties
	
	private static final String URL = "jdbc:mysql://localhost:3306/employeedirectory";
	
	private static final String Driver="com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "Vishnu@3152";
	
	private static Connection connection = null;
	
	// Define the static method
	
	public static Connection openConnection()
	{
		
		//check the connection
		if(connection!=null)
		{
			return connection;
		}
		
		else {
			try {
		// load the connection
		
		Class.forName(Driver);
		
		// get the connection
		
		connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			// return the connection
			return connection;
		
		}
		
		
		
	}
	
}
