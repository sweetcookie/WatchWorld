package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.hyw.watchworld.customer.Dao.GoodsDisplayInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.GoodsInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsDisplayInfo;

public class SearchResultService
{
	private static SearchResultService service;
	
	private SearchResultService(){}
	
	public static SearchResultService getInstance()
	{
		if(service == null)
		{
			service = new SearchResultService();
		}
		return service;
	}

	/**
	 * 通过商品名对数据库进行模糊查找
	 * @param goodsName
	 * @param pageIdx
	 * @param len
	 * @return
	 */
	public List<GoodsDisplayInfo> findByGoodsName(String goodsName, int pageIdx, int len)
	{
		List<GoodsDisplayInfo> dataList = (new GoodsDisplayInfoDao()).
				findByGoodsName(goodsName, pageIdx, len);
		return dataList;
	}
	
	/**
	 * 得到商品模糊查找结果的数量
	 * @param goodsName
	 * @return
	 */
	public int getAmountOfDataByGoodsName(String goodsName)
	{
		int amount = (new GoodsInfoDao()).getAmountOfDataByGoodsName(goodsName);
		return amount;
	}
	
	/**
	 * 通过每一页的数据量获取分页页数
	 * @param goodsName
	 * @param len
	 * @return
	 */
	public int getTotalPageNum(String goodsName, int len)
	{
		int amount = this.getAmountOfDataByGoodsName(goodsName);
		int pageNum = amount / len;
		if((amount % len) > 0 ) //分页有余数，则多加一页
		{
			pageNum++;
		}
		return pageNum;
	}
}
