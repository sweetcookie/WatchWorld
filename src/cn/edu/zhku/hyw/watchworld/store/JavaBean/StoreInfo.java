package cn.edu.zhku.hyw.watchworld.store.JavaBean;
/**
 * 店铺实体类
 * @author Administrator
 *
 */
public class StoreInfo {
	
	private int StoreID;//店铺编号
	private String loginName;//用户名
	private String Password;//密码
	private String StoreName;//店名
	private String Owner;//店主
	private String RegTime; // 注册时间	
	private String Telephone; // 联系电话	
	
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getRegTime() {
		return RegTime;
	}
	public void setRegTime(String regTime) {
		RegTime = regTime;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		this.Telephone = telephone;
	}
	
	
	public StoreInfo(int storeID, String password, String storeName,
			String owner, String regTime, String telephone) {
		super();
		StoreID = storeID;
		Password = password;
		StoreName = storeName;
		Owner = owner;
		RegTime = regTime;
		this.Telephone = telephone;
	}
	public StoreInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
