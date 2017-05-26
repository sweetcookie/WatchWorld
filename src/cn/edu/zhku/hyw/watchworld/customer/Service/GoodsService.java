package cn.edu.zhku.hyw.watchworld.customer.Service;

import cn.edu.zhku.hyw.watchworld.customer.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.StoreInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsInfo;

public class GoodsService
{
	private static GoodsService service;
	
	private GoodsService(){}
	
	public static GoodsService getInstance()
	{
		if(service == null)
		{
			service = new GoodsService();
		}
		return service;
	}
	
	/**
	 * 通过商品ID查找商品的具体信息
	 * @param goodsID
	 * @return
	 */
	public GoodsInfo findByGoodsID(String goodsID)
	{
		GoodsInfo info = (new GoodsInfoDao()).findByGoodsID(goodsID);
		return info;
	}
	
	/**
	 * 通过店铺账号查找店铺名
	 * @param storeID
	 * @return
	 */
	public String findStoreNameByStoreID(int storeID)
	{
		String storeName = (new StoreInfoDao()).findStoreNameByStoreID(storeID);
		return storeName;
	}
}
