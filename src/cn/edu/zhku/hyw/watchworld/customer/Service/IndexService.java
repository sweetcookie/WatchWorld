package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.ActivityDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.Activity;

public class IndexService
{
	public List<Activity> findAllActivity()
	{
		List<Activity> dataList = null;
		dataList = (new ActivityDao()).findAll();
		return dataList;
	}
}
