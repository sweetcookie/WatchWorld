package cn.edu.zhku.hyw.watchworld.admin.JavaBean;

public class AdminInfo {
	private String   AdminID;       //管理员ID
	private String   AdminPWD;      //管理员密码
	private int      Session;       //管理员权限；有两个取值：1代表最高管理员，无法删除本身，只有一个；2代表管理员，只能由最高管理员创建和删除；
	public int getSession() {
		return Session;
	}
	public void setSession(int session) {
		Session = session;
	}
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getAdminPWD() {
		return AdminPWD;
	}
	public void setAdminPWD(String adminPWD) {
		AdminPWD = adminPWD;
	}

	public AdminInfo(String adminID, String adminPWD, int session) {
		super();
		AdminID = adminID;
		AdminPWD = adminPWD;
		Session = session;
	}
	public AdminInfo() {
		super();
	}
	
} 
