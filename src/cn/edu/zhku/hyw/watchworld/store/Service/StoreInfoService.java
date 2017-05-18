package cn.edu.zhku.hyw.watchworld.store.Service;

import cn.edu.zhku.hyw.watchworld.store.Dao.StoreInfoDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.StoreInfoDaoImpl;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;
/**
 * 业务逻辑层
 * 处理项目中出现的业务逻辑
 * @author 
 *
 */
public class StoreInfoService {
	StoreInfoDao dao=new StoreInfoDaoImpl();
	
	public boolean checkLoginName(String loginName){
		return dao.checkLoginName(loginName);
	}
	
	public boolean checkStoreName(String storeName){
		return dao.checkStoreName(storeName);
	}
	
	public boolean checkTelephone(String telephone){
		return dao.checkTelephone(telephone);
	}
	public boolean checkOwner(String owner){
		return dao.checkOwner(owner);
	}
	public void  addStore(StoreInfo storeInfo){
		dao.addStore(storeInfo);
	}
	public boolean checkLoginNameAndPwd(String loginName,String pwd) {
		return dao.checkLoginNameAndPwd(loginName,pwd);
	}
}
