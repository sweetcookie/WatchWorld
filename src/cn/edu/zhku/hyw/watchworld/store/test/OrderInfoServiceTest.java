package cn.edu.zhku.hyw.watchworld.store.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.edu.zhku.hyw.watchworld.store.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.OrderInfosDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.GoodsInfoDaoImpl;
import cn.edu.zhku.hyw.watchworld.store.Service.OrderInfoService;

public class OrderInfoServiceTest {
	OrderInfoService s=null;
	@Before
	public void init(){
		s = new OrderInfoService();

	}
	@Test
	public void testFindOrderInfoByStoreID() {
		
		 List list= s.findOrderInfoByStoreID(8892, "已发货");
		 System.out.println(list);
		fail("Not yet implemented");
	}

	@Test
	public void testChangeStatus() {
		System.out.println(s.changeStatus("222"));
		
		fail("Not yet implemented");
	}

}
