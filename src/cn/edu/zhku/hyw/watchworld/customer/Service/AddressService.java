package cn.edu.zhku.hyw.watchworld.customer.Service;

import cn.edu.zhku.hyw.watchworld.customer.Dao.UserDataDao;

public class AddressService
{
	private static AddressService service;
	
	private AddressService(){}
	
	public static AddressService getInstance()
	{
		if(service == null)
		{
			service = new AddressService();
		}
		return service;
	}
	
	public String findAddressByUserID(String userID)
	{
		String address = (new UserDataDao()).findAddressByUserID(userID);
		return address;
	}
	
	public boolean saveAddress(String userID, String address)
	{
		if(address == null)
		{
			address = "";
		}
		boolean flag = (new UserDataDao()).updateAddressByUserID(userID, address);
		return flag;
	}
}
