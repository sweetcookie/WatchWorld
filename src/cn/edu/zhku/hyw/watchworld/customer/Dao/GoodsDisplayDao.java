package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;

public class GoodsDisplayDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GoodsDisplayDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	/**
	 * 查找goods_display表中的所有品牌Brand
	 * @return 品牌字符串
	 */
	public List<String> findAllByBrand()
	{
		List<String> dataList = new ArrayList<String>();
		String sql = "select distinct Brand from goods_display";
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String st = rs.getString("Brand");
				dataList.add(st);
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
