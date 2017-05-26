package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;

public class StoreInfoDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public StoreInfoDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	/**
	 * 通过店铺账号查找店铺名
	 * @param storeID
	 * @return
	 */
	public String findStoreNameByStoreID(int storeID)
	{
		String storeName = "";
		String sql = "select StoreName from store_info where StoreID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				storeName = rs.getString("StoreName");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return storeName;
	}
}
