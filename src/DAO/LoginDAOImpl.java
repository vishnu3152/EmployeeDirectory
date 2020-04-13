package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Login;
import Util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public String authenticate(Login login) {
		String sql="select * from tbl_login where email=? and password=?";
		try {
			Connection connection=DBConnectionUtil.openConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,login.getEmail());
			ps.setString(2, login.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				return "true";
			}
			else
			{
				return "false";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}

}
