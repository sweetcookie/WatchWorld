package cn.edu.zhku.hyw.watchworld.store.JavaBean;

import java.sql.Timestamp;
import java.util.List;

public class OrderInfo<E> {
	private    String            orderID      ;
	 private   String            orderStatus  ;
	 private   Timestamp         paymentTime  ;
	 private   Timestamp         sendGoodsTime;
	 private   String            storeName    ;
	 private   String            userName     ;
	 private   int               totalPrice   ;
	 private   String  				address;
	 public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private   List<OrderGoods>  orderGoods   ;
	 
	 
	 public List<OrderGoods> getOrderGoods() {
		return orderGoods;
	}
	public void setOrderGoods(List<OrderGoods> orderGoods) {
		this.orderGoods = orderGoods;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Timestamp getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}
	public Timestamp getSendGoodsTime() {
		return sendGoodsTime;
	}
	public void setSendGoodsTime(Timestamp sendGoodsTime) {
		this.sendGoodsTime = sendGoodsTime;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderInfo [orderID=" + orderID + ", orderStatus=" + orderStatus
				+ ", paymentTime=" + paymentTime + ", sendGoodsTime="
				+ sendGoodsTime + ", storeName=" + storeName + ", userName="
				+ userName + ", totalPrice=" + totalPrice + ", address="
				+ address + ", orderGoods=" + orderGoods + "]";
	}
	
	
	
	
	
	
	
}
