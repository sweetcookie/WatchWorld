package cn.edu.zhku.hyw.watchworld.admin.Dao;

// 此class用于对WatchWorld数据库的admin_info表进行管理
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.edu.zhku.hyw.watchworld.Utils.JdbcUtil;
import cn.edu.zhku.hyw.watchworld.admin.JavaBean.AdminInfo;
import cn.edu.zhku.hyw.watchworld.admin.JavaBean.PageBean;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSetMetaData;


public class AdminInfoDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int pageSize=6;
	
 	public void addAdmin(AdminInfo adminInfo)                //函数：创建管理员
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
        try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "INSERT INTO admin_info(AdminID,Pwd,Session) VALUES(?,?,?)";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setString(1,adminInfo.getAdminID());
			stmt.setString(2, adminInfo.getAdminPWD());
			stmt.setInt(3, 2);
	
			
			stmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	} 
	public void deleteAdmin(String AdminID)                  //函数：删除管理员
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			// 获取连接
		    conn = JdbcUtil.getConn();
		    String sql = "DELETE FROM admin_info WHERE AdminID=?";
		    // 创建PreparedStatement
			stmt = conn.prepareStatement(sql);			
					stmt.executeUpdate();
						
			} catch (Exception e) {
			        e.printStackTrace();
						
			} finally {
					JdbcUtil.close(conn, stmt);
			}
	}	
	public void modifyPWD(String AdminID,String newPWD)               //函数：修改密码
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "UPDATE admin_info SET Pwd=? where AdminID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setString(1,newPWD);
			stmt.setString(2,AdminID);
			// 执行
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}
    public List<AdminInfo> findAll()                         //函数：查找所有管理员数据
    {
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM admin_info";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 执行
			rs=stmt.executeQuery();
			List<AdminInfo> list=new ArrayList<AdminInfo>();
			while(rs.next())
			{   
				if(rs.getInt("Session")==2)
				{
					AdminInfo adminInfo=new AdminInfo();
     			    adminInfo.setAdminID(rs.getString("AdminID"));
     			    adminInfo.setAdminPWD(rs.getString("Pwd"));
     			    adminInfo.setSession(2);
     			    list.add(adminInfo);
				}
			}
			return list;
			} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
    }
    public AdminInfo findByAdminID(String AdminID)           //函数：根据管理员ID查找相应该管理员数据
    {
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM admin_info where AdminID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setString(1,AdminID);
			// 执行
			rs=stmt.executeQuery();
			if(rs.next())
			{
				AdminInfo adminInfo=new AdminInfo();
				adminInfo.setAdminID(rs.getString(1));
				adminInfo.setAdminPWD(rs.getString(2));
				adminInfo.setAdminPWD(rs.getString(3));
				return adminInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt,rs);
		}
		return null;
    }
    public int loginCheck(String AdminID,String AdminPWD)    //函数：登录时，管理员ID和密码都正确，且权限为1，即root，返回0，权限为2，即2，返回-1，密码错误，返回1，不存在此管理员ID，返回2
    {
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM admin_info where AdminID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setString(1,AdminID);
			// 执行
			rs=stmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("Pwd").equals(AdminPWD))
					if(rs.getInt("Session")==1)
						return 0;
					else 
						return -1;
				else 
					return 1;
			}
			else 
				return 2;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt,rs);
		}
    }
    public int AdminIDCheck(String RegName)                                //函数：数据库是否已存在此管理员，是，返回1，否，返回0
    {
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM admin_info where AdminID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setString(1,RegName);
			// 执行
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return 1;
			}
			else 
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt,rs);
		}
    }
    private PreparedStatement getPrepareStatment(String sql)
    {
    	/*Connection conn = null;*/
		PreparedStatement pstmt = null;
    	try{
    		conn = JdbcUtil.getConn();
    		pstmt = conn.prepareStatement(sql); 
    	}catch(Exception e){
			e.printStackTrace();		
    	}
    	return pstmt;
    }
    private void setParams(String sql)
    {
    	/*String sql1="select * from store_info limit 0,6";*/
    	pstmt=this.getPrepareStatment(sql);
    	System.out.println(sql);
    	
    	/*for(int i=0;i<params.length;i++){
    		try{
    			pstmt.setString(i+1,params[i]);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}*/
    	
    }
    public List getList(String sql)
    {
    	List<Map> list=new ArrayList<Map>();
    	try{
    		this.setParams(sql);       //报错
    		ResultSet rs=pstmt.executeQuery();
    		ResultSetMetaData rsmd=rs.getMetaData();
    		while(rs.next()){
    			Map<String,String> m=new HashMap<String,String>();
    			for(int i=1;i<=rsmd.getColumnCount();i++){
    				String colName=rsmd.getColumnName(i);
    				m.put(colName, rs.getString(colName));
    			}
    			list.add(m);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally {
			JdbcUtil.close(conn, pstmt,rs);
		}
    	return list;
    }
    public Map getMap(String sql)
    {
 
    	List<Map> list=new ArrayList<Map>();
        list=getList(sql);
    	if(list.isEmpty())
    		return null;
    	else
    		return (Map)list.get(0);
    }
    private int getTotalRows(String sql)
    {
    	int totalRows=0;
    	sql=sql.toLowerCase();
    	String countSql="";
    	if(sql.indexOf("group")>=0){
    		countSql="select count(*) from( "+sql+") as tempNum";
    	}
    	else{
    		countSql="select count(*) as tempNum "+sql.substring(sql.indexOf("from"));
    	}
    	Map m=getMap(countSql);
    	String count=(String)m.get("tempNum");

    	totalRows=Integer.parseInt(count);
    	System.out.println(totalRows);
    	return totalRows;
    }
    public PageBean getPageBean(String sql,int curPage)
    {
    	List<Map> data=new ArrayList<Map>();
    	String newSql=sql+"limit "+(curPage-1)*pageSize+","+pageSize;
    	data=this.getList(newSql);            //报错了
    	
    	PageBean pb=new PageBean();
    	pb.setCurPage(curPage);
    	pb.setPageSize(pageSize);
    	pb.setTotalRows(getTotalRows(sql));
    	pb.setData(data);
    	return pb;
    }
    public boolean addActivity(int storeID,String path,String activity){
    	Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println("true");
        try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "INSERT INTO activity(ActivityPicturePath,StoreID,ActivityName) VALUES(?,?,?)";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setString(1,path);
			stmt.setInt(2,storeID);
			stmt.setString(3,activity);
	
			
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
    return false;
    }
    public boolean deleteActivity(String ActivityName){
    	Connection conn = null;
		PreparedStatement stmt = null;
        try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "DELETE FROM activity WHERE ActivityName=?";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setString(1,ActivityName);
			
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
    return false;
    }
    public boolean deleteFiles(String path){
    	File file=new File(path);
    	System.out.println(path);
        	file.delete();
        	return true;
    }
    public boolean deleteGoods(int GoodsID){
    	Connection conn = null;
		PreparedStatement stmt = null;
        try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "DELETE FROM goods_display WHERE GoodsID=?";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setInt(1,GoodsID);
			
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
    return false;
    }
    public String findGoodsByID(int GoodsID){
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String Brand;
		try {
			// 获取连接
			conn = JdbcUtil.getConn();
			String sql = "SELECT * FROM goods_info where GoodsID=?";

			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			// 设置参数
			stmt.setInt(1,GoodsID);
			// 执行
			rs=stmt.executeQuery();
			if(rs.next()){
		        Brand=rs.getString("Brand");
		        return Brand;
			}
			else return Brand="1";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt,rs);
		}
    }
    public boolean addGoods(int GoodsID,String Brand){
    	Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println("DaoaddGoods");
        try {
			
			// 获取连接
			conn = JdbcUtil.getConn();
			
			String sql = "INSERT INTO goods_display(GoodsID,Brand) VALUES(?,?)";
			// 创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			//设置参数
			stmt.setInt(1,GoodsID);
			stmt.setString(2,Brand);	
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(conn, stmt);
		}
    return false;
    }
}
   