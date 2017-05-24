package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.zhku.hyw.watchworld.customer.Dao.UserInfoDao;

public class AccountSecurityService
{
	private static AccountSecurityService service;
	
	private AccountSecurityService(){}
	
	public static AccountSecurityService getInstance()
	{
		if(service == null)
		{
			service = new AccountSecurityService();
		}
		return service;
	}
	
	public Map<String, String> checkPwd(String userID, String password1, String password2)
	{
		Map<String, String> resultMap = new HashMap<String, String>();
		boolean flag = true; //判断表单中的所有数据是否有效
		resultMap.put("password1", checkPassword(password1));
		resultMap.put("password2", checkconfirmPwd(password1, password2));
		for(String val: resultMap.values())
		{
			if(!val.equals("")) //存在字符串非空，表示表单中存在非法数据
			{
				flag = false;
				break;
			}
		}
		if(flag == false)
		{
			resultMap.put("status", "false");
		}
		else //数据有效，则将表单数据保存到数据库中
		{
			resultMap.put("status", "true");
			boolean f = this.saveForm(userID, password1);
			if(f == true) //数据保存成功
			{
				resultMap.put("saved", "保存成功！");
			}
			else
			{
				resultMap.put("saved", "系统错误，保存失败！");
			}
		}
		
		return resultMap;
	}
	
	public String checkPassword(String password1)
	{
		String result = "";
		if(password1 == null || password1.equals(""))
		{
			result = "请输入密码！";
		}
		else
		{
			Pattern pattern = Pattern.compile("[\\w]{6,}");
			Matcher matcher = pattern.matcher(password1);
			if(matcher.matches() == false)
			{
				result = "密码必须由6位以上的字母、数字或下划线构成！";
			}
		}
		return result;
	}
	
	public String checkconfirmPwd(String password1, String password2)
	{
		String result = "";
		if(password2 == null || password2.equals(""))
		{
			result = "请再次输入密码！";
		}
		else
		{
			if(password1 != null && password1 != "")
			{
				if(!password1.equals(password2))
				{
					result = "密码不一致！";
				}
			}
		}
		
		return result;
	}
	
	public boolean saveForm(String userID, String password)
	{
		boolean flag = (new UserInfoDao()).updatePasswordByUserID(userID, password);
		return flag;
	}
}
