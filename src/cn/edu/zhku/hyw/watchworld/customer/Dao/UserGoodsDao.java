package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserGoods;

public class UserGoodsDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserGoodsDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	/**
	 * 通过商品编号和用户账号查找数据库表user_goods,用于指定商品是否已经加入了购物车
	 * @param goodsID
	 * @param userID
	 * @return
	 */
	public int countByGoodsIDandUserID(int goodsID, String userID)
	{
		int amount = 0;
		String sql = "select count(*) as amount from user_goods where GoodsID=? and UserID=? limit 1";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsID);
			pstmt.setString(2, userID);
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

	/**
	 * 更新购物车中指定商品的数量
	 * @param goodsID
	 * @param userID
	 * @param number
	 * @return
	 */
	public boolean updateByGoodsIDandUserID(int goodsID, String userID, int number)
	{
		boolean flag = false;
		String sql = "update user_goods set Number=? where GoodsID=? and UserID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, goodsID);
			pstmt.setString(3, userID);
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
	 * 向购物车添加一条数据
	 * @param data
	 * @return
	 */
	public boolean doCreate(UserGoods data)
	{
		boolean flag = false; //插入成功与否的标志
		String sql = "insert into user_goods values (?,?,?)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data.getGoodsID());
			pstmt.setString(2, data.getUserID());
			pstmt.setInt(3, data.getNumber());
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
	 * 根据商品编号和用户编号删除购物车指定的信息
	 * @param goodsID
	 * @return
	 */
	public boolean delByGoodsID(int goodsID, String userID)
	{
		boolean flag = false; //删除成功与否的标志
		String sql = "delete from user_goods where GoodsID=? and UserID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsID);
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
