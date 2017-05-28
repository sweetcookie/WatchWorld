package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.OrderGoodsDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.OrderInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderGoods;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderInfo;

public class PersonalOrderService
{
	private static PersonalOrderService service;
	
	private PersonalOrderService(){}
	
	public static PersonalOrderService getInstance()
	{
		if(service == null)
		{
			service = new PersonalOrderService();
		}
		return service;
	}
	
	/**
	 * 查找指定用户id的订单
	 * @param userId
	 * @param orderStatus
	 * @return
	 */
	public List<OrderInfo> findOrderInfoByUserIdandStatus(String userID, String orderStatus)
	{
		List<OrderInfo> oiList = new ArrayList<OrderInfo>();
		if(orderStatus.equals("所有订单"))
		{
			oiList = (new OrderInfoDao()).findByUserId(userID);
		}
		else
		{
			oiList = (new OrderInfoDao()).findByUserIdandStatus(userID, orderStatus);
		}
		
		return oiList;
	}
	
	/**
	 * 通过订单编号查询订单相关的商品信息
	 * @param orderID
	 * @return
	 */
	public List<OrderGoods> findOrderGoodsByOrderID(String orderID)
	{
		List<OrderGoods> ogList = (new OrderGoodsDao()).findByOrderID(orderID);
		return ogList;
	}
	
	public boolean delOrderInfoByOrderID(String orderID)
	{
		boolean flag = (new OrderInfoDao()).delByOrderID(orderID);
		return flag;
	}
	
	/**
	 * 更新订单状态
	 * @param status
	 * @param orderID
	 * @return
	 */
	public boolean updateStatusByOrderID(String status, String orderID)
	{
		boolean flag = (new OrderInfoDao()).updateStatusByOrderID(status, orderID);
		return flag;
	}
}
