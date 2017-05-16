package cn.edu.zhku.hyw.watchworld.store.test;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.edu.zhku.hyw.watchworld.store.Dao.StoreDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.StoreDaoImpl;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;

public class TestStoreDaoImpl {
	
	/**
	 * 初始化对象实例
	 */
	StoreDao storeDao=null;
	boolean flag;
	@Before
	public void init(){
		 storeDao = new StoreDaoImpl();
	}
	
	@Test
	public void addStore(){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		StoreInfo storeInfo = new StoreInfo();
		storeInfo.setLoginName("哈哈4");
		storeInfo.setPassword("123456");
		storeInfo.setStoreName("手表店");
		storeInfo.setOwner("张");
		storeInfo.setTelephone("1888887");
		storeInfo.setRegTime(date);
		storeDao.addStore(storeInfo);
	}
	
	@Test
	public void updateStore(){
		StoreInfo storeInfo = new StoreInfo();
		storeInfo.setStoreID(8888);
		storeInfo.setPassword("123456");
		storeInfo.setStoreName("手表店");
		storeInfo.setTelephone("188888");
		
		storeDao.updateStore(storeInfo);
		
	}
	
	@Test
	public void checkLoginName(){
		
		flag=storeDao.checkLoginName("哈哈2");
		System.out.println(flag);
	}
	@Test
	public void checkStoreName(){
		
		flag=storeDao.checkStoreName("手表店");
		System.out.println(flag);
		
	}
	
	@Test
	public void checkTelephone(){
		
		flag=storeDao.checkTelephone("188888");
		System.out.println(flag);
	}
}
