package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserData;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserInfo;

public class UserDataDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDataDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	public boolean doCreate(UserData data)
	{
		boolean flag = false; //插入成功与否的标志
		String sql = "insert into user_data values (?,?,?,?,?,?,?)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getUserID());
			pstmt.setString(2, data.getUserName());
			pstmt.setInt(3, data.getAge());
			pstmt.setString(4, data.getSex());
			pstmt.setString(5, data.getPortrait());
			pstmt.setString(6, data.getAddress());
			pstmt.setString(7, data.getTelephone());
			if(pstmt.executeUpdate() == 1)
			{
				flag = true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt);
		return flag;
	}
}
