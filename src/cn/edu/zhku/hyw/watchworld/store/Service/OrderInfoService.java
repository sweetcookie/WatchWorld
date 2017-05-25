package cn.edu.zhku.hyw.watchworld.store.Service;

import java.util.List;

import cn.edu.zhku.hyw.watchworld.store.Dao.OrderInfosDao;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.OrderGoods;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.OrderInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;

public class OrderInfoService {
	OrderInfosDao dao=new OrderInfosDao();
	GoodsInfoService goodsInfoService= new GoodsInfoService();
	/**
	 * 查找该店铺某状态下所有的订单
	 * @param storeID
	 * @param orderStatus
	 * @return  该店铺订单为状态orderStatus的list
	 */
	public List<OrderInfo> findOrderInfoByStoreID(int storeID,String orderStatus){
		
		StoreInfoService storeInfoService=new StoreInfoService();
		StoreInfo storeInfo = storeInfoService.findStoreByID(storeID);
		if (storeInfo==null) {
			return null;
		}
		List<OrderInfo> list=dao.findOrderInfoByStoreName(storeInfo.getStoreName(), orderStatus);
		for (OrderInfo orderInfo : list) {
			if (dao.findOrderGoodsByOrderID(orderInfo)==false) {
				break;
			}
			
		}
		return list;
		
	}
	/**把订单状态改为已发货状态,并把相应的商品的库存减去购买量,销量加上购买量
	 * 
	 * @param orderID
	 * @return
	 */
	public boolean changeStatus(String orderID) {
		OrderInfo<OrderGoods> orderInfo = new OrderInfo<OrderGoods>();
		orderInfo.setOrderID(orderID);
			if(dao.changeStatus(orderID)==false){
				System.out.println("改变订单"+orderID+"状态失败");
				return false;
			}
			dao.findOrderGoodsByOrderID(orderInfo);
			List<OrderGoods> orderList = orderInfo.getOrderGoods();
			for (OrderGoods orderGoods : orderList) {
				int buyAmount = orderGoods.getBuyAmount();
				int goodsID=Integer.parseInt(orderGoods.getGoodsID());
				int storeID=Integer.parseInt(orderGoods.getStoreID());
//				System.out.println("buyAmount:"+buyAmount+"   goodsID:"+goodsID+"      storeID:"+storeID);
				GoodsInfo goodsInfo = goodsInfoService.findGoodsByID(goodsID, storeID);
				 int goodsNumber=goodsInfo.getNumber();
//				 System.out.println("goodsNumber:"+goodsNumber);
				 int number=goodsNumber-buyAmount;
				 if(number<0){
					 System.out.println("商品:"+goodsID+"库存不足");
					 return false;
				 }
				 if(goodsInfoService.updateGoodsNum(goodsID, number)==false){
					 System.out.println("更新失败");
				 }
				 goodsInfoService.updateGoodsSalesvolumes(goodsID, buyAmount);
			}
			return true;
			
	}
}
