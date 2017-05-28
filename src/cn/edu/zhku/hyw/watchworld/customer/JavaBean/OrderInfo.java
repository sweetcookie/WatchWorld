package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

public class OrderInfo
{
	private String orderID;
	private String orderStatus;
	private String paymentTime;
	private String sendGoodsTime;
	private String storeName;
	private String userName;
	private int totalPrice;
	private String address;
	private String telephone;
	private String userID;
	public String getUserID()
	{
		return userID;
	}
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	public String getOrderID()
	{
		return orderID;
	}
	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}
	public String getOrderStatus()
	{
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	public String getPaymentTime()
	{
		return paymentTime;
	}
	public void setPaymentTime(String paymentTime)
	{
		this.paymentTime = paymentTime;
	}
	public String getSendGoodsTime()
	{
		return sendGoodsTime;
	}
	public void setSendGoodsTime(String sendGoodsTime)
	{
		this.sendGoodsTime = sendGoodsTime;
	}
	public String getStoreName()
	{
		return storeName;
	}
	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
}
