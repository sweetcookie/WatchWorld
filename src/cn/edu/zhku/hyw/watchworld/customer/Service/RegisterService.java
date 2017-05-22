package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.zhku.hyw.watchworld.customer.Dao.UserDataDao;
import cn.edu.zhku.hyw.watchworld.customer.Dao.UserInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.RegisterForm;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserData;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserInfo;

public class RegisterService
{
	private static RegisterService service;
	
	private RegisterService(){}
	public static RegisterService getInstance()
	{
		if(service == null)
		{
			service = new RegisterService();
		}
		return service;
	}
	
	/**
	 * 验证表单，返回各输入框字段的验证结果
	 * 键值对<"status", "true">表示表单数据全部合法，通过验证
	 * 键值对<"status", "false">表示表单中存在不合法的数据，不通过验证
	 * @param form 表单对象
	 * @return 以键值对的形式返回验证结果
	 */
	public Map<String, String> checkForm(RegisterForm form)
	{
		Map<String, String> resultMap = new HashMap<String, String>();
		boolean flag = true; //判断表单中的所有数据是否有效
		resultMap.put("userID", checkUserID(form.getUserID()));
		resultMap.put("password1", checkPassword(form.getPassword1()));
		resultMap.put("password2", checkconfirmPwd(form.getPassword1(), form.getPassword2()));
		resultMap.put("userName", checkUserName(form.getUserName()));
		resultMap.put("age", checkAge(form.getAge()));
		resultMap.put("address", checkAddress(form.getAddress()));
		resultMap.put("telephone", checkTelephone(form.getTelephone()));
		for(String val: resultMap.values())
		{
			if(!val.equals("")) //存在字符串非空，表示表单中存在非法数据
			{
				flag = false;
			}
		}
		if(flag == false)
		{
			resultMap.put("status", "false");
		}
		else //数据有效，则将表单数据保存到数据库中
		{
			resultMap.put("status", "true");
			boolean f = this.saveRegister(form);
			if(f == true) //数据保存成功
			{
				resultMap.put("saved", "true");
			}
			else
			{
				resultMap.put("saved", "false");
			}
		}
		
		return resultMap;
	}
	
	public String checkUserID(String userID)
	{
		String result = "";
		if(userID == null || userID.equals(""))
		{
			result = "请输入账号！";
		}
		else
		{
			Pattern pattern = Pattern.compile("[\\w]{6,15}");
			Matcher matcher = pattern.matcher(userID);
			if(matcher.matches() == true)
			{
				UserInfo info = (new UserInfoDao()).findByUserID(userID);
				if(info != null)
				{
					result = "此账号已被注册！";
				}
			}
			else
			{
				result = "账号必须由6-15位字母、数字或下划线构成！";
			}
		}
		
		return result;
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
	
	public String checkUserName(String userName)
	{
		String result = "";
		if(userName == null || userName.equals(""))
		{
			result = "请输入昵称！";
		}
		
		return result;
	}
	
	public String checkAge(int age)
	{
		String result = "";
		if(age < 0)
		{
			result = "请输入年龄！";
		}
		
		return result;
	}
	
	public String checkAddress(String address)
	{
		String result = "";
		if(address == null || address.equals(""))
		{
			result = "请输入收货地址!";
		}
		
		return result;
	}
	
	public String checkTelephone(String telephone)
	{
		String result = "";
		if(telephone == null || telephone.equals(""))
		{
			result = "请输入联系方式！";
		}
		else
		{
			Pattern pattern = Pattern.compile("[\\d]+");
			Matcher matcher = pattern.matcher(telephone);
			if(matcher.matches() == false)
			{
				result = "请输入正确的联系方式！";
			}
		}
		return result;
	}
	
	/**
	 * 将提交的表单保存到数据库中
	 * @param form
	 * @return 是否保存成功
	 */
	public boolean saveRegister(RegisterForm form)	
	{
		boolean flag = true; //保存成功与否的标志
		UserInfo userInfo = new UserInfo();
		UserData userData = new UserData();
		
		userInfo.setUserID(form.getUserID());
		userInfo.setPwd(form.getPassword1());
		userData.setUserID(form.getUserID());
		userData.setUserName(form.getUserName());
		userData.setAge(form.getAge());
		userData.setSex(form.getSex());
		userData.setPortrait("");
		userData.setAddress(form.getAddress());
		userData.setTelephone(form.getTelephone());
		
		boolean f1 = (new UserInfoDao()).doCreate(userInfo);
		boolean f2 = (new UserDataDao()).doCreate(userData);
		
		if(f1 == false || f2 == false)
		{
			flag = false;
		}
		
		return flag;
	}
}
