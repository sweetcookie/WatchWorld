package cn.edu.zhku.hyw.watchworld.store.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import cn.edu.zhku.hyw.watchworld.store.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.GoodsInfoDaoImpl;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.PageBean;
import cn.edu.zhku.hyw.watchworld.store.Service.GoodsInfoService;

public class TestGoodsDaoImpl {
	/**
	 * 初始化对象实例
	 */

	GoodsInfoDao goodsDao=null;
	@Before
	public void init(){
		goodsDao = new GoodsInfoDaoImpl();

	}
	@Test
	public void addGoods(){
		GoodsInfo goodsInfo = new GoodsInfo();
		for (int i = 0; i <10; i++) {
			
		
		goodsInfo.setGoodsName("手表"+i);
		goodsInfo.setGoodsPicturePath("url"+i);
		goodsInfo.setPrice(999+i);
		goodsInfo.setBrand           ("劳力士"+i);
		goodsInfo.setColor           ("颜色"+i);
		goodsInfo.setModel           ("型号"+i);
		goodsInfo.setNumber          (100+i);
		goodsInfo.setStoreID         (8890);
		goodsInfo.setSalesVolumes    (0+i);
		
		System.out.println("增加:"+goodsDao.addGoods(goodsInfo));
		}
		
	}
	@Test
	public void deleteGoods(){
		
		System.out.println("删除:"+goodsDao.deleteGoods(4)); 
	}
	@Test
	public void updateGoods(){
		int i=2;
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoodsName("手表"+i);
		goodsInfo.setGoodsPicturePath("url"+i);
		goodsInfo.setPrice(999+i);
		goodsInfo.setBrand           ("劳力士"+i);
		goodsInfo.setColor           ("颜色"+i);
		goodsInfo.setModel           ("型号"+i);
		goodsInfo.setNumber          (100+i);
		goodsInfo.setGoodsID         (i);
		goodsInfo.setSalesVolumes    (0+i);
		System.out.println("更新:"+goodsDao.updateGoods(goodsInfo));
		
	}
	@Test
	public void findAllGoods(){
		PageBean<GoodsInfo> pageBean= new PageBean<GoodsInfo>();
		GoodsInfoService dao = new GoodsInfoService();
		boolean flag = dao.findAllGoods(9999, pageBean);
		List<GoodsInfo> list = pageBean.getPageData();
		System.out.println(flag);
		for (GoodsInfo goodsInfo : list) {
			System.out.println(goodsInfo);
		}
	}
	@Test
	public void findGoodsByID(){
		GoodsInfo goodsInfo=goodsDao.findGoodsByID(24,8901);
		System.out.println(goodsInfo);
	}
}
