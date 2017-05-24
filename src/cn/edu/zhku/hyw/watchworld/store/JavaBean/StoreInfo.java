package cn.edu.zhku.hyw.watchworld.store.JavaBean;
/**
 * 店铺实体类
 * @author Administrator
 *
 */
public class StoreInfo {
	
	private int storeID;//店铺编号
	private String loginName;//用户名
	private String password;//密码
	private String storeName;//店名
	private String owner;//店主
	private String regTime; // 注册时间	
	private String telephone; // 联系电话	
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	public StoreInfo(int storeID, String password, String storeName,
			String owner, String regTime, String telephone) {
		super();
		this.storeID = storeID;
		this.password = password;
		this.storeName = storeName;
		this.owner = owner;
		this.regTime = regTime;
		this.telephone = telephone;
	}
	public StoreInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StoreInfo [StoreID=" + storeID + ", loginName=" + loginName
				+ ", Password=" + password + ", StoreName=" + storeName
				+ ", Owner=" + owner + ", RegTime=" + regTime + ", Telephone="
				+ telephone + "]";
	}
	
	
}
