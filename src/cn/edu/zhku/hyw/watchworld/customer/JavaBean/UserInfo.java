package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 此类为数据库表user_info的映射
 * @author 曾裕文
 *
 */
public class UserInfo
{
	private String userID;
	private String Pwd;
	public String getUserID()
	{
		return userID;
	}
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	public String getPwd()
	{
		return Pwd;
	}
	public void setPwd(String pwd)
	{
		Pwd = pwd;
	}
}
