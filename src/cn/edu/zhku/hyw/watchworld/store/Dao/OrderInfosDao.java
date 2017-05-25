package cn.edu.zhku.hyw.watchworld.store.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.OrderGoods;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.OrderInfo;

/**
 * 订单信息的dao接口
 * @author Administrator
 *
 */
public class OrderInfosDao {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public List<OrderInfo> findOrderInfoByStoreName(String storeName,String orderStatus){
		String sql = "select * from order_info where StoreName=? and OrderStatus=?";
	try {
		conn=JdbcUtil.getConn();
	    stmt=conn.prepareStatement(sql);
		stmt.setString(1, storeName);
		stmt.setString(2, orderStatus);
		rs = stmt.executeQuery();
		List<OrderInfo> orderIDs=new ArrayList<OrderInfo>();
		while(rs.next()){
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrderID(rs.getString("OrderID"));
			orderInfo.setOrderStatus(rs.getString("OrderStatus"));
			orderInfo.setPaymentTime(rs.getTimestamp("PaymentTime"));
			orderInfo.setSendGoodsTime(rs.getTimestamp("SendGoodsTime"));
			orderInfo.setStoreName(rs.getString("StoreName"));
			orderInfo.setUserName(rs.getString("UserName"));
			orderInfo.setTotalPrice(rs.getInt("TotalPrice"));
			orderIDs.add(orderInfo);
		}
		return orderIDs;
	} catch (Exception e) {
		e.printStackTrace();
	}finally { 
		JdbcUtil.close(conn, stmt, rs);	 
	}
		return null;
		
	}
	public boolean changeStatus(String orderID) {
		try {
			conn = JdbcUtil.getConn();
			String sql = "UPDATE order_info SET OrderStatus=? where OrderID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "已发货");
			stmt.setString(2,orderID);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt);
		}
		return false;
	}
	
	public boolean findOrderGoodsByOrderID(OrderInfo<OrderGoods> orderInfo){
		
		String sql = "select * from order_goods where OrderID=? ";
		try {
			conn=JdbcUtil.getConn();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, orderInfo.getOrderID());
			rs = stmt.executeQuery();
			List<OrderGoods> list=new ArrayList<OrderGoods>();
			while (rs.next()) {
				OrderGoods orderGoods = new OrderGoods();
				orderGoods.setGoodsID(rs.getString("GoodsID"));
				orderGoods.setGoodsName(rs.getString("GoodsName"));
				orderGoods.setStoreID(rs.getString("StoreID"));
				orderGoods.setPrice(rs.getInt("Price"));
				orderGoods.setBrand(rs.getString("Brand"));
				orderGoods.setColor(rs.getString("Color"));
				orderGoods.setModel(rs.getString("Model"));
				orderGoods.setBuyAmount(rs.getInt("BuyAmount"));
				orderGoods.setGoodsPicturePath(rs.getString("GoodsPicturePath"));
				list.add(orderGoods);
			}
			orderInfo.setOrderGoods(list);
			return true;
			}catch (Exception e) {
				e.printStackTrace();
			}finally { 
				JdbcUtil.close(conn, stmt, rs);	 
			}
		return false;
		
	}
}
