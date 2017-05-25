package cn.edu.zhku.hyw.watchworld.customer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsDisplayInfo;

public class GoodsDisplayInfoDao
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GoodsDisplayInfoDao()
	{
		conn = JdbcUtil.getConn();
	}
	
	/**
	 * 通过品牌查找相应的热销产品的图片、名称和价格
	 * @param brand 品牌
	 * @return 含有图片路径、商品名称、价格的数组列表
	 */
	public List<GoodsDisplayInfo> findByBrand(String brand)
	{
		List<GoodsDisplayInfo> dataList = new ArrayList<GoodsDisplayInfo>();
		String sql = "select GoodsID,GoodsName,GoodsPicturePath,Price " +
				"from goods_info " +
				"where GoodsID in " +
				"(select GoodsID from goods_display where Brand = ?)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				GoodsDisplayInfo data = new GoodsDisplayInfo();
				data.setGoodsID(rs.getInt("GoodsID"));
				data.setGoodsName(rs.getString("GoodsName"));
				data.setGoodsPicturePath(rs.getString("GoodsPicturePath"));
				data.setPrice(rs.getFloat("Price"));
				dataList.add(data);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, pstmt, rs);
		return dataList;
	}
	
	/**
	 * 通过goodsName对数据库进行模糊查找商品
	 * @param goodsName
	 * @param pageIdx
	 * @param len
	 * @return
	 */
	public List<GoodsDisplayInfo> findByGoodsName(String goodsName, int pageIdx, int len)
	{
		List<GoodsDisplayInfo> dataList = new ArrayList<GoodsDisplayInfo>();
		String sql = "select GoodsID,GoodsName,GoodsPicturePath,Price " +
				"from goods_info " +
				"where GoodsName like ? " +
				"limit ?,?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + goodsName + "%");
			pstmt.setInt(2, ((pageIdx - 1) * 10)); //limit的第一个参数起始为0
			pstmt.setInt(3, len);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				GoodsDisplayInfo data = new GoodsDisplayInfo();
				data.setGoodsID(rs.getInt("GoodsID"));
				data.setGoodsName(rs.getString("GoodsName"));
				data.setGoodsPicturePath(rs.getString("GoodsPicturePath"));
				data.setPrice(rs.getFloat("Price"));
				dataList.add(data);
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
