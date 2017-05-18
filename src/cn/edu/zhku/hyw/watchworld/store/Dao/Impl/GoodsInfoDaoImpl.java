package cn.edu.zhku.hyw.watchworld.store.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.store.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;

public class GoodsInfoDaoImpl implements GoodsInfoDao {

	@Override
	public void addGoods(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = 
					"INSERT INTO goods_info(" +
					"GoodsName,GoodsPicturePath,Price,Brand," +
					"MovementStyle,Color,Material,Shape,Waterproof,Style," +
					"Model,Number,StoreID,SalesVolumes) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, goodsInfo.getGoodsName());
			stmt.setString(2, goodsInfo.getGoodsPicturePath());
			stmt.setInt(3, goodsInfo.getPrice());
			stmt.setString(4, goodsInfo.getBrand());
			stmt.setString(5, goodsInfo.getMovementStyle());
			stmt.setString(6, goodsInfo.getColor());
			stmt.setString(7, goodsInfo.getMaterial());
			stmt.setString(8, goodsInfo.getShape());
			stmt.setString(9, goodsInfo.getWaterproof());
			stmt.setString(10, goodsInfo.getStyle());
			stmt.setString(11, goodsInfo.getModel());
			stmt.setInt(12, goodsInfo.getNumber());
			stmt.setInt(13, goodsInfo.getStoreID());
			stmt.setInt(14, goodsInfo.getSalesVolumes());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	
		
	
	}

		
	

	@Override
	public void deleteGoods(int goodsID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "DELETE FROM goods_info WHERE GoodsID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setInt(1, goodsID);

			// 执行
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}

	@Override
	public void updateGoods(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "UPDATE goods_info SET GoodsName=?,GoodsPicturePath=?,Price=?,Brand=?," +
					"MovementStyle=?,Color=?,Material=?,Shape=?,Waterproof=?,Style=?," +
					"Model=?,Number=?,SalesVolumes=? WHERE GoodsID=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数
			stmt.setString(1,  goodsInfo.getGoodsName());
			stmt.setString(2,  goodsInfo.getGoodsPicturePath());
			stmt.setInt(3,  goodsInfo.getPrice());
			stmt.setString(4,  goodsInfo.getBrand());
			stmt.setString(5,  goodsInfo.getMovementStyle());
			stmt.setString(6,  goodsInfo.getColor());
			stmt.setString(7,  goodsInfo.getMaterial());
			stmt.setString(8,  goodsInfo.getShape());
			stmt.setString(9,  goodsInfo.getWaterproof());
			stmt.setString(10, goodsInfo.getStyle());
			stmt.setString(11, goodsInfo.getModel());
			stmt.setInt(12, goodsInfo.getNumber());
			stmt.setInt(13, goodsInfo.getSalesVolumes());
			stmt.setInt(14, goodsInfo.getGoodsID());
			
		
			
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}

	@Override
	public List<GoodsInfo> findAllGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsInfo findGoodsByID(int GoodsID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsInfo> findGoodsByName(String GoodsName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsInfo> findGoodsByBrand(String GoodsName) {
		// TODO Auto-generated method stub
		return null;
	}

}
