package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.Activity;

public class ActivityDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ActivityDao()
	{
		conn = JdbcUtil.getConn();
	}

	public List<Activity> findAll()
	{
		List<Activity> dataList = new ArrayList<Activity>();
		String sql = "select * from activity";
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				Activity activity = new Activity();
				activity.setActivityPicturePath(rs.getString("ActivityPicturePath"));
				activity.setStoreId(rs.getInt("StoreID"));
				dataList.add(activity);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return dataList;
	}
}
