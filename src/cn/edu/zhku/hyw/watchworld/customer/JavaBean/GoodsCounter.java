package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 商品计数类，包含商品编号和数量
 *
 */
public class GoodsCounter
{
	private int goodsID;
	private int amount;
	public int getGoodsID()
	{
		return goodsID;
	}
	public void setGoodsID(int goodsID)
	{
		this.goodsID = goodsID;
	}
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
}
