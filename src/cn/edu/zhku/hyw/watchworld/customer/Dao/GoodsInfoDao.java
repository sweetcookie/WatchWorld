package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;

public class GoodsInfoDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GoodsInfoDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	/**
	 * 获取通过商品名模糊查找的到的结果的数量
	 * @param goodsName
	 * @return
	 */
	public int getAmountOfDataByGoodsName(String goodsName)
	{
		int amount = 0;
		String sql = "select count(*) as amount from goods_info where GoodsName like ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + goodsName + "%");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				amount = rs.getInt("amount");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return amount;
	}
}
