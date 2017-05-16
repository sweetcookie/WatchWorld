package cn.edu.zhku.hyw.watchworld.store.test;

import org.junit.Before;
import org.junit.Test;

import cn.edu.zhku.hyw.watchworld.store.Dao.GoodsDao;
import cn.edu.zhku.hyw.watchworld.store.Dao.Impl.GoodsDaoImpl;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;

public class TestGoodsDaoImpl {
	/**
	 * 初始化对象实例
	 */
	GoodsDao goodsDao=null;
	@Before
	public void init(){
		goodsDao = new GoodsDaoImpl();
	}
	@Test
	public void addGoods(){
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoodsName("手表");
		goodsInfo.setGoodsPicturePath("url");
		goodsInfo.setPrice(999);
		goodsInfo.setBrand           ("劳力士");
		goodsInfo.setMovementStyle   ("机芯类型");
		goodsInfo.setColor           ("颜色");
		goodsInfo.setMaterial        ("材质");
		goodsInfo.setShape           ("形状");
		goodsInfo.setWaterproof      ("防水深度");
		goodsInfo.setStyle           ("风格");
		goodsInfo.setModel           ("型号");
		goodsInfo.setNumber          (100);
		goodsInfo.setStoreID         (8888);
		goodsInfo.setSalesVolumes    (0);
		
		goodsDao.addGoods(goodsInfo);
	}
	@Test
	public void deleteGoods(){
		goodsDao.deleteGoods(4);
	}
	@Test
	public void updateGoods(){
		int i=1;
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoodsName("手表"+i);
		goodsInfo.setGoodsPicturePath("url"+i);
		goodsInfo.setPrice(999+i);
		goodsInfo.setBrand           ("劳力士"+i);
		goodsInfo.setMovementStyle   ("机芯类型"+i);
		goodsInfo.setColor           ("颜色"+i);
		goodsInfo.setMaterial        ("材质"+i);
		goodsInfo.setShape           ("形状"+i);
		goodsInfo.setWaterproof      ("防水深度"+i);
		goodsInfo.setStyle           ("风格"+i);
		goodsInfo.setModel           ("型号"+i);
		goodsInfo.setNumber          (100+i);
		goodsInfo.setGoodsID         (3);
		goodsInfo.setSalesVolumes    (0+i);
		goodsDao.updateGoods(goodsInfo);
		
	}
}
