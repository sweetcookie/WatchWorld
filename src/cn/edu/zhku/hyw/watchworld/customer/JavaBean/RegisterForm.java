package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 此类为顾客注册表单信息的映射
 * @author 曾裕文
 *
 */
public class RegisterForm
{
	private String userID;
	private String password1;
	private String password2;
	private String userName;
	private int age;
	private String sex;
	private String address;
	private String telephone;
	
	public String getUserID()
	{
		return userID;
	}
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	public String getPassword1()
	{
		return password1;
	}
	public void setPassword1(String password1)
	{
		this.password1 = password1;
	}
	public String getPassword2()
	{
		return password2;
	}
	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
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
