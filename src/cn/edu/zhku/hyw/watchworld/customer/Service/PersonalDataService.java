package cn.edu.zhku.hyw.watchworld.customer.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.zhku.hyw.watchworld.customer.Dao.UserDataDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserData;

public class PersonalDataService
{
	private static PersonalDataService service;
	
	private PersonalDataService(){}
	
	public static PersonalDataService getInstance()
	{
		if(service == null)
		{
			service = new PersonalDataService();
		}
		return service;
	}
	
	public UserData findUserDataByUserID(String UserID)
	{
		UserData data = null;
		data = (new UserDataDao()).findByUserID(UserID);
		return data;
	}
	
	/**
	 * 修改头像存储的路径
	 * @param portraitPath
	 * @param userID
	 * @return
	 */
	public boolean updatePortrait(String portraitPath, String userID)
	{
		boolean flag = (new UserDataDao()).updatePortraitByUserID(portraitPath, userID);
		return flag;
	}
	
	public Map<String, String> checkPersonalData(String userID, String userName, int age, String sex, String telephone)
	{
		boolean flag = true; //判断表单中的所有数据是否有效
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("userName", checkUserName(userName));
		resultMap.put("age", checkAge(age));
		resultMap.put("telephone", checkTelephone(telephone));
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
			resultMap.put("status", "false"); //数据非法，需要修改
		}
		else
		{
			resultMap.put("status", "true");  //数据符合规范，保存到数据库
			boolean f = this.saveForm(userID, userName, age, sex, telephone); //将数据更新到数据库
			if(f == true) //保存成功
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
			result = "请输入正确的年龄！";
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
	 * 保存用户更改后的账户信息
	 * @param userID
	 * @param userName
	 * @param age
	 * @param sex
	 * @param telephone
	 * @return
	 */
	public boolean saveForm(String userID, String userName, int age, String sex, String telephone)
	{
		boolean flag = (new UserDataDao()).updateUserDataByUserID(userID, userName, age, sex, telephone);
		return flag;
	}
}
