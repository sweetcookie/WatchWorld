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
	
	/**
	 * 通过账号获取账户信息
	 * @param UserID
	 * @return
	 */
	public UserData findByUserID(String UserID)
	{
		UserData data = null;
		String sql = "select * from user_data where UserId=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				data = new UserData();
				data.setUserID(rs.getString("UserId"));
				data.setUserName(rs.getString("UserName"));
				data.setAge(rs.getInt("Age"));
				data.setSex(rs.getString("Sex"));
				data.setPortrait(rs.getString("Portrait"));
				data.setAddress(rs.getString("Address"));
				data.setTelephone(rs.getString("Telephone"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return data;
	}
	
	/**
	 * 通过账号修改个人头像的存储路径
	 * @param portraitPath 头像的存储路径
	 * @param userID 账号
	 * @return 修改成功与否，true表示成功
	 */
	public boolean updatePortraitByUserID(String portraitPath, String userID)
	{
		boolean flag = false;
		String sql = "update user_data set Portrait=? where UserId=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, portraitPath);
			pstmt.setString(2, userID);
			if(pstmt.executeUpdate() > 0)
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
	 * 更新指定账号的账户信息
	 * @param userID 指定账号
	 * @param userName 更新后昵称
	 * @param age 更新后年龄
	 * @param sex 更新后性别
	 * @param telephone 更新后联系方式
	 * @return 更新成功与否
	 */
	public boolean updateUserDataByUserID(String userID, String userName, int age, String sex, String telephone)
	{
		boolean flag = false; //数据更新成功与否的标志
		String sql = "update user_data set UserName=?,Age=?,Sex=?,Telephone=? where UserId=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setInt(2, age);
			pstmt.setString(3, sex);
			pstmt.setString(4, telephone);
			pstmt.setString(5, userID);
			if(pstmt.executeUpdate() > 0)
			{
				flag = true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return flag;
	}
	
	/**
	 * 通过账号查找默认收货地址
	 * @param userID
	 * @return
	 */
	public String findAddressByUserID(String userID)
	{
		String address = "";
		String sql = "select Address from user_data where UserId=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				address = rs.getString("Address");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return address;
	}
	
	/**
	 * 更新指定用户的收货地址
	 * @param userID
	 * @param address
	 * @return
	 */
	public boolean updateAddressByUserID(String userID, String address)
	{
		boolean flag = false; //数据更新成功与否的标志
		String sql = "update user_data set Address=? where UserId=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, userID);
			if(pstmt.executeUpdate() > 0)
			{
				flag = true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return flag;
	}
}
