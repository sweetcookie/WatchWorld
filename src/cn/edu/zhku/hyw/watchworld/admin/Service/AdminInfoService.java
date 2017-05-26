package cn.edu.zhku.hyw.watchworld.admin.Service;


import java.util.List;

import cn.edu.zhku.hyw.watchworld.admin.Dao.AdminInfoDao;
import cn.edu.zhku.hyw.watchworld.admin.JavaBean.AdminInfo;
import cn.edu.zhku.hyw.watchworld.admin.JavaBean.PageBean;

public class AdminInfoService {
      AdminInfoDao Admin=new AdminInfoDao();
      
      public void addAdmin(AdminInfo adminInfo)
      {
    	  Admin.addAdmin(adminInfo);
      }
      public void deleteAdmin(String AdminID)
      {
    	  Admin.deleteAdmin(AdminID);
      }
      public void modifyPWD(AdminInfo adminInfo)
      {
    	  Admin.modifyPWD(adminInfo);
      }
      public List<AdminInfo> findAll() 
      {
    	  return Admin.findAll();
      }
      public AdminInfo findByAdminID(String AdminID)
      {
    	  return Admin.findByAdminID(AdminID);
      }
      public int loginCheck(String AdminID,String AdminPWD)
      {
    	  return Admin.loginCheck(AdminID, AdminPWD);
      }
      public int AdminIDCheck(String RegName)
      {
    	  return Admin.AdminIDCheck(RegName);
      }
      public PageBean getStoreInfo_page(String sql,int curPage)
      { 
    	  /*String[] params={"8890"};*/
    	  /*String sql1="select * from store_info where StoreName like '%手%' ";*/
    	  System.out.println(sql);

    	  PageBean pb=Admin.getPageBean(sql,curPage);
    	  return pb;
      }
}
