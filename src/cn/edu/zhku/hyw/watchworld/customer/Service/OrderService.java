package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import cn.edu.zhku.hyw.watchworld.customer.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsCounter;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderGoods;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserGoods;

public class OrderService
{
	private static OrderService service;
	
	private OrderService(){}
	
	public static OrderService getInstance()
	{
		if(service == null)
		{
			service = new OrderService();
		}
		return service;
	}
	
	/**
	 * 将json数据转换为GoodsCounter数据类型
	 * @param str
	 * @param userID
	 * @return
	 */
	public List<GoodsCounter> translateToGoodsCounter(String str)
	{
		List<GoodsCounter> list = new ArrayList<GoodsCounter>();
		JSONArray json = JSONArray.fromObject(str);
		list = (List<GoodsCounter>) JSONArray.toCollection(json, GoodsCounter.class);
		return list;
	}
	
	/**
	 * 通过商品ID和购买数量获取OrderGoods对象
	 * @param paraList
	 * @return
	 */
	public List<OrderGoods> createOrderGoods(List<GoodsCounter> paraList)
	{
		List<OrderGoods> dataList = new ArrayList<OrderGoods>();
		for(GoodsCounter counter : paraList)
		{
			GoodsInfo info = (new GoodsInfoDao()).findByGoodsID(counter.getGoodsID());
			int amount = counter.getAmount();
			OrderGoods orderGoods = new OrderGoods();
			orderGoods.setGoodsID(info.getGoodsID());
			orderGoods.setGoodsName(info.getGoodsName());
			orderGoods.setStoreID(info.getStoreID());
			orderGoods.setPrice((int)info.getPrice());
			orderGoods.setBrand(info.getBrand());
			orderGoods.setColor(info.getColor());
			orderGoods.setModel(info.getModel());
			orderGoods.setGoodsPicturePath(info.getGoodsPicturePath());
			orderGoods.setBuyAmount(amount);
			dataList.add(orderGoods);
		}
		return dataList;
	}
	
	/**
	 * 获取按店铺分类的订单键值对
	 * @param paraList 源预订单数据
	 * @return 分类后的预订单数据
	 */
	public Map<String, List<OrderGoods>> createStoreGoodsMap(List<OrderGoods> paraList)
	{
		Map<String, List<OrderGoods>> dataMap = new HashMap<String, List<OrderGoods>>();
		Set<String> storeIDSet = new HashSet<String>();
		for(OrderGoods od : paraList) //抽取出paraList中所有商店的编号
		{
			storeIDSet.add(String.valueOf(od.getStoreID()));
		}
		List<String> storeIDList = new ArrayList<String>(storeIDSet);
		for(String id : storeIDList)
		{
			List<OrderGoods> odList = new ArrayList<OrderGoods>();
			for(OrderGoods od : paraList)
			{
				if(id.equals(String.valueOf(od.getStoreID())))
				{
					odList.add(od);
				}
			}
			dataMap.put(id, odList); //id是店铺的编号，odList是订单中该店铺下的商品信息
		}
		return dataMap;
	}
	
	/**
	 * 计算订单的总价
	 * @param paraList
	 * @return
	 */
	public int calcTotalMoney(List<OrderGoods> paraList)
	{
		int totalMoney = 0;
		for(OrderGoods od : paraList)
		{
			totalMoney = totalMoney + od.getPrice();
		}
		return totalMoney;
	}
}
