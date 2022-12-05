package in.ineuron.prepared.jdbcassignment.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtility {
	
	private JdbcUtility() {
		
	}

	public static Connection getJdbcConnection() throws SQLException
	{
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/javaassing";
		String user = "root";
		String pwd = "akash12345";
		
		con = DriverManager.getConnection(url,user,pwd);
		if(con!=null)
			return con;
		return con;
	}
	
	public static void closeConnection(ResultSet resultSet, Statement statement , Connection connection) throws SQLException
	{
		if(resultSet!=null)
		{
			resultSet.close();
		}
		if(statement!=null)
		{
			statement.close();
		}
		if(connection!=null)
		{
			connection.close();
		}
	}
}
