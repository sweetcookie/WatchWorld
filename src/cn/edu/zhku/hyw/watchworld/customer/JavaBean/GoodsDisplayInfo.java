package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 该类用于存储首页以及搜索结果需要展示的商品信息，包括商品的图片路径、商品名和商品价格
 * @author 曾裕文
 *
 */

public class GoodsDisplayInfo
{
	private int GoodsID;
	private String GoodsName;
	private String GoodsPicturePath;
	private float Price;
	
	public int getGoodsID()
	{
		return GoodsID;
	}
	public void setGoodsID(int goodsID)
	{
		GoodsID = goodsID;
	}
	public String getGoodsName()
	{
		return GoodsName;
	}
	public void setGoodsName(String goodsName)
	{
		GoodsName = goodsName;
	}
	public String getGoodsPicturePath()
	{
		return GoodsPicturePath;
	}
	public void setGoodsPicturePath(String goodsPicturePath)
	{
		GoodsPicturePath = goodsPicturePath;
	}
	public float getPrice()
	{
		return Price;
	}
	public void setPrice(float price)
	{
		Price = price;
	}
}
