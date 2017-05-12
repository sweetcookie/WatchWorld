package cn.edu.zhku.hyw.watchworld.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private Connection conn = null;
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String DBURL = 
			"jdbc:mysql://localhost:3306/jobdb?autoReconnection=true&useSSL=false";
	private static final String DBUSER = "root";
	private static final String DBPWD = "";
	
	public DBConnection() throws Exception
	{
		try
		{
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
	
	public void close()
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}