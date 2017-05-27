package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

public class OrderGoods
{
	private String orderID;
	private int goodsID;
	private String goodsName;
	private int storeID;
	private int price;
	private String brand;
	private String color;
	private String model;
	private int buyAmount;
	private String goodsPicturePath;

	public String getOrderID()
	{
		return orderID;
	}

	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}

	public int getGoodsID()
	{
		return goodsID;
	}

	public void setGoodsID(int goodsID)
	{
		this.goodsID = goodsID;
	}

	public String getGoodsName()
	{
		return goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public int getStoreID()
	{
		return storeID;
	}

	public void setStoreID(int storeID)
	{
		this.storeID = storeID;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getBuyAmount()
	{
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount)
	{
		this.buyAmount = buyAmount;
	}

	public String getGoodsPicturePath()
	{
		return goodsPicturePath;
	}

	public void setGoodsPicturePath(String goodsPicturePath)
	{
		this.goodsPicturePath = goodsPicturePath;
	}
}
