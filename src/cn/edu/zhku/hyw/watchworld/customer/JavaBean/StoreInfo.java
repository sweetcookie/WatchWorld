package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

public class StoreInfo
{
	private int storeID;// 店铺编号
	private String loginName;// 用户名
	private String password;// 密码
	private String storeName;// 店名
	private String owner;// 店主
	private String regTime; // 注册时间
	private String telephone; // 联系电话

	public int getStoreID()
	{
		return storeID;
	}

	public void setStoreID(int storeID)
	{
		this.storeID = storeID;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getStoreName()
	{
		return storeName;
	}

	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getRegTime()
	{
		return regTime;
	}

	public void setRegTime(String regTime)
	{
		this.regTime = regTime;
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
