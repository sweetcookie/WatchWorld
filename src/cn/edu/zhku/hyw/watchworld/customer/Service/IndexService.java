package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.ActivityDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.Activity;

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
	
	public List<Activity> findAllActivity()
	{
		List<Activity> dataList = null;
		dataList = (new ActivityDao()).findAll();
		return dataList;
	}
}
