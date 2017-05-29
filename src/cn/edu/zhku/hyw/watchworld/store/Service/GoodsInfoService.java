package cn.edu.zhku.hyw.watchworld.store.Service;

import cn.edu.zhku.hyw.watchworld.store.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.GoodsInfoDaoImpl;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.PageBean;

public class GoodsInfoService {
	GoodsInfoDao dao=new GoodsInfoDaoImpl();
	public boolean findAllGoods(int StoreID,String key,PageBean<GoodsInfo> pb) {
		return dao.findAllGoodsBykey(StoreID,key,pb);
	}
	public boolean findAllGoods(int StoreID,PageBean<GoodsInfo> pb) {
		return dao.findAllGoods(StoreID, pb);
	}
	
	public boolean addGoods(GoodsInfo goodsInfo) {
		return  dao.addGoods(goodsInfo);
	}
	
	public boolean deleteGoods(int goodsID) {
		return dao.deleteGoods(goodsID);
	}
	
	public boolean updateGoods(GoodsInfo goodsInfo) {
		return dao.updateGoods(goodsInfo);
	}
	public boolean updateGoodsNum(int goodsID,int number) {
		return dao.updateGoodsNum(goodsID, number);
	}
	public boolean updateGoodsSalesvolumes(int goodsID,int number){
	 return	dao.updateGoodsSalesVolumes(goodsID,number);
		
	}
	public GoodsInfo findGoodsByID(int GoodsID,int StoreID) {
		return dao.findGoodsByID(GoodsID,StoreID);
	}
	
}
