package cn.edu.zhku.hyw.watchworld.store.Dao;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;

/**
 * 店铺信息的dao接口
 * @author Administrator
 *
 */
public interface StoreDao {
	public void addStore(StoreInfo storeInfo);//注册用户,返回ID
	public void deleteStore(int StoreID);//删除店铺
	public void updateStore(StoreInfo storeInfo);//修改店铺
	public List<StoreInfo>  findStore();//查找所有店铺
	public StoreInfo findStoreByID(int storeID);//查找单个店铺,通过ID
	public boolean checkLoginName(String loginName);//判断店铺登录名
	public boolean checkStoreName(String storeName);//判断店铺名
	public boolean checkTelephone(String telephone);//判断号码
}
