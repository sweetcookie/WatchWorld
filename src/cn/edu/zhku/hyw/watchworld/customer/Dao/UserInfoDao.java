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
				info = new UserInfo();
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
	
	/**
	 * 向表user_info插入一条数据
	 * @param info
	 * @return
	 */
	public boolean doCreate(UserInfo info)
	{
		boolean flag = false; //插入成功与否的标志
		String sql = "insert into user_info values (?,?)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getUserID());
			pstmt.setString(2, info.getPwd());
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
	
	/**
	 * 更新账户密码
	 * @param userID
	 * @param password
	 * @return
	 */
	public boolean updatePasswordByUserID(String userID, String password)
	{
		boolean flag = false; //插入成功与否的标志
		String sql = "update user_info set Pwd=? where UserID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, userID);
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
