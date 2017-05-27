package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.ShoppingCartInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.UserGoodsDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.ShoppingCartInfo;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserGoods;

public class ShoppingCartService
{
	private static ShoppingCartService service;
	
	private ShoppingCartService(){}
	
	public static ShoppingCartService getInstance()
	{
		if(service == null)
		{
			service = new ShoppingCartService();
		}
		return service;
	}
	
	public boolean InsertIntoShoppingCart(int goodsID, String userID, int number)
	{
		boolean flag = false; //添加购物车成功与否的标志
		int amount = (new UserGoodsDao()).countByGoodsIDandUserID(goodsID, userID);
		if(amount > 0) //此商品已经在购物车中，则更新此条数据
		{
			boolean f1 = (new UserGoodsDao()).updateByGoodsIDandUserID(goodsID, userID, number);
			if(f1 == true) //更新成功
			{
				flag = true;
			}
		}
		else //此商品尚未加入购物车，则插入一条新的数据
		{
			UserGoods data = new UserGoods();
			data.setGoodsID(goodsID);
			data.setUserID(userID);
			data.setNumber(number);
			boolean f2 = (new UserGoodsDao()).doCreate(data);
			if(f2 == true)
			{
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 通过用户账号查找其购物车信息
	 * @param userID
	 * @return
	 */
	public List<ShoppingCartInfo> findByUserID(String userID)
	{
		List<ShoppingCartInfo> dataList = (new ShoppingCartInfoDao()).findByUserID(userID);
		return dataList;
	}

	/**
	 * 根据商品编号和用户编号删除购物车指定的信息
	 * @param goodsID
	 * @param userID
	 * @return
	 */
	public boolean delInfoByGoodsID(int goodsID, String userID)
	{
		boolean flag = (new UserGoodsDao()).delByGoodsID(goodsID, userID);
		return flag;
	}
}
