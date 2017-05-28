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
      public void modifyPWD(String AdminID,String newPWD)
      {
    	  Admin.modifyPWD(AdminID,newPWD);
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
      public List getList(String sql){
    	  List list=Admin.getList(sql);
    	  return list;
      }
      public boolean addActivity(int storeID,String path,String activity){
    	  return Admin.addActivity(storeID,path,activity);
      }
      public boolean deleteActivity(String ActivityName){
    	  return Admin.deleteActivity(ActivityName);
      }
      public boolean deleteFiles(String path){
    	  return Admin.deleteFiles(path);
      }
      public boolean deleteGoods(int GoodsID){
    	  return Admin.deleteGoods(GoodsID);
      }
      public String findGoodsByID(int GoodsID){
    	  return Admin.findGoodsByID(GoodsID);
      }
      public boolean addGoodsID(int GoodsID,String Brand){
    	  return Admin.addGoods(GoodsID, Brand);
      }
}
