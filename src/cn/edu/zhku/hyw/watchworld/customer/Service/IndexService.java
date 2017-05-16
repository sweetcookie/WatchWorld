package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.ActivityDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.GoodsDisplayInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.Activity;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsDisplayInfo;

public class IndexService
{
	private static IndexService service;
	
	private IndexService(){}
	
	public static IndexService getInstance()
	{
		if(service == null)
		{
			service = new IndexService();
		}
		return service;
	}
	
	/**
	 * 获取所有活动图片
	 * @return 包含图片路径和商店编号的数组列表
	 */
	public List<Activity> findAllActivity()
	{
		List<Activity> dataList = null;
		dataList = (new ActivityDao()).findAll();
		return dataList;
	}
	
	/**
	 * 调用dao层获取首页热销产品的信息
	 * @param brand 品牌
	 * @return 包含商品名称、图片路径、商品价格的数组列表
	 */
	public List<GoodsDisplayInfo> findGoodsDisplayInfoByBrand(String brand)
	{
		List<GoodsDisplayInfo> dataList = (new GoodsDisplayInfoDao()).findByBrand(brand);
		return dataList;
	}
}
