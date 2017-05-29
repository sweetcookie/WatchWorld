package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderGoods;

public class OrderGoodsDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public OrderGoodsDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	public boolean doCreate(OrderGoods od)
	{
		boolean flag = false; //插入成功与否的标志
		String sql = "insert into order_goods values (?,?,?,?,?,?,?,?,?,?)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, od.getOrderID());
			pstmt.setInt(2, od.getGoodsID());
			pstmt.setString(3, od.getGoodsName());
			pstmt.setString(4, String.valueOf(od.getStoreID()));
			pstmt.setInt(5, od.getPrice());
			pstmt.setString(6, od.getBrand());
			pstmt.setString(7, od.getColor());
			pstmt.setString(8, od.getModel());
			pstmt.setInt(9, od.getBuyAmount());
			pstmt.setString(10, od.getGoodsPicturePath());
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
	
	public List<OrderGoods> findByOrderID(String orderID)
	{
		List<OrderGoods> ogList = new ArrayList<OrderGoods>();
		String sql = "select * from order_goods where OrderID=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderID);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				OrderGoods info = new OrderGoods();
				info.setOrderID(rs.getString("OrderID"));
				info.setGoodsID(rs.getInt("GoodsID"));
				info.setGoodsName(rs.getString("GoodsName"));
				info.setStoreID((Integer.parseInt(rs.getString("StoreID"))));
				info.setPrice(rs.getInt("Price"));
				info.setBrand(rs.getString("Brand"));
				info.setColor(rs.getString("Color"));
				info.setModel(rs.getString("Model"));
				info.setBuyAmount(rs.getInt("BuyAmount"));
				info.setGoodsPicturePath(rs.getString("GoodsPicturePath"));
				ogList.add(info);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return ogList;
	}
}
