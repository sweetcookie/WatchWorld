package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserInfo;

public class UserInfoDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserInfoDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	public UserInfo findByUserID(String userID)
	{
		UserInfo info = null;
		String sql = "select * from user_info where UserID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				info.setUserID(rs.getString("UserID"));
				info.setPwd(rs.getString("Pwd"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return info;
	}
}
