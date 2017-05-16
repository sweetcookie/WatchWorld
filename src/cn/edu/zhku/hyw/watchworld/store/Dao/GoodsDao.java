package cn.edu.zhku.hyw.watchworld.store.Dao;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;

/**
 * 店铺信息的dao接口
 * @author Administrator
 *
 */
public interface GoodsDao {
	
	public void addGoods(GoodsInfo GoodsInfo);//增加商品
	public void deleteGoods(int GoodsID);//商品下架
	public void updateGoods(GoodsInfo GoodsInfo);//修改商品
	public List<GoodsInfo>  findAllGoods();//查找所有商品
	public GoodsInfo findGoodsByID(int GoodsID);//通过ID查找单个商品
	public List<GoodsInfo>  findGoodsByName(String GoodsName);//通过名称查找商品
	public List<GoodsInfo>  findGoodsByBrand(String GoodsName);//通过名称查找商品
	
}
