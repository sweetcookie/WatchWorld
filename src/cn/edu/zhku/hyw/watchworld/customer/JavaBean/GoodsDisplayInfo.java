package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 该类用于存储首页需要展示的商品信息，包括商品的图片路径、商品名和商品价格
 * @author 曾裕文
 *
 */

public class GoodsDisplayInfo
{
	private String GoodsName;
	private String GoodsPicturePath;
	private float Price;
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
