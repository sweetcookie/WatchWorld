package cn.edu.zhku.hyw.watchworld.store.Dao;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.PageBean;

/**
 * 商品信息的dao接口
 * @author Administrator
 *
 */
public interface GoodsInfoDao {
	
	public boolean findAllGoods(int StoreID, PageBean<GoodsInfo> pb);//查找某店铺所有的商品
	public int getTotalCount(int StoreID);
	public boolean addGoods(GoodsInfo GoodsInfo);//增加商品
	public boolean deleteGoods(int GoodsID);//商品下架
	public boolean updateGoods(GoodsInfo GoodsInfo);//修改商品
	public List<GoodsInfo>  findGoodsByName(String GoodsName);//通过名称查找商品
	public List<GoodsInfo> findGoodsByBrand(String GoodsName);
	public GoodsInfo findGoodsByID(int GoodsID, int StroeID);//通过ID查找单个商品
	public boolean updateGoodsNum(int GoodsID,int BuyAmount);//更新商品数量
	boolean updateGoodsSalesVolumes(int GoodsID, int salesvolumes);//更新商品销量
	
}
