package cn.edu.zhku.hyw.watchworld.customer.Service;

import cn.edu.zhku.hyw.watchworld.customer.Dao.UserInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserInfo;

public class LoginService
{
	private static LoginService service;
	
	private LoginService(){}
	
	public static LoginService getInstance()
	{
		if(service == null)
		{
			service = new LoginService();
		}
		return service;
	}
	
	/**
	 * 验证登录表单信息
	 * @param loginID 登录账号
	 * @param loginPwd 登录密码
	 * @return 验证结果，字符串表示验证失败的原因，空字符串表示验证成功
	 */
	public String checkLogin(String loginID, String loginPwd)
	{
		String result = "";
		if(loginID == null || loginID.equals(""))
		{
			result = "请输入账号！";
		}
		else if(loginPwd == null || loginPwd.equals(""))
		{
			result = "请输入密码！";
		}
		else
		{
			UserInfo info = (new UserInfoDao()).findByUserID(loginID);
			if(info == null)
			{
				result = "此账号不存在！";
			}
			else
			{
				if(!info.getPwd().equals(loginPwd))
				{
					result = "密码不正确！";
				}
			}
		}
		return result;
	}
}