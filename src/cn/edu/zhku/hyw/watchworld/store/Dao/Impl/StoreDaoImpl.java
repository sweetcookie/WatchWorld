package cn.edu.zhku.hyw.watchworld.store.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.store.Dao.StoreDao;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;

public class StoreDaoImpl implements StoreDao {

	@Override
	public void  addStore(StoreInfo storeInfo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "INSERT INTO store_info(LoginName,Pwd,StoreName,Owner,RegTime,Telephone) VALUES(?,?,?,?,?,?)";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, storeInfo.getLoginName());
			stmt.setString(2, storeInfo.getPassword());
			stmt.setString(3, storeInfo.getStoreName());
			stmt.setString(4, storeInfo.getOwner());
			stmt.setString(5, storeInfo.getRegTime());
			stmt.setString(6, storeInfo.getTelephone());
			
			stmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
		
		
	
	}

	@Override
	public void deleteStore(int StoreID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStore(StoreInfo storeInfo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "UPDATE store_info SET Pwd=?,StoreName=?,Telephone=? WHERE StoreID=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数
			stmt.setString(1,  storeInfo.getPassword());
			stmt.setString(2,  storeInfo.getStoreName());
			stmt.setString(3,  storeInfo.getTelephone());
			stmt.setInt(4,  storeInfo.getStoreID());
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
	public List<StoreInfo> findStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreInfo findStoreByID(int StoreID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean checkLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { // 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM store_info where LoginName=? ";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, loginName);

			// 执行
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public boolean checkStoreName(String storeName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { // 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM store_info where StoreName=? ";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, storeName);

			// 执行
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return false;
	}

	@Override
	public boolean checkTelephone(String telephone) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { // 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM store_info where Telephone=? ";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, telephone);

			// 执行
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return false;
	}
}
