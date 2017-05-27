package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;

@WebServlet("/ActivityAddServlet")
@MultipartConfig
public class ActivityAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public ActivityAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String storeID=request.getParameter("StoreID");
		String activity=request.getParameter("ActivityName");
		String operate=request.getParameter("operate");
		if(operate==null||operate.equals("select")){
			 System.out.println(operate);
			 String sql="select * from activity";
	        List Activity=new ArrayList();
	        AdminInfoService admin=new AdminInfoService();
	        Activity=admin.getList(sql);
	        System.out.println(Activity);
	        request.getSession().setAttribute("Activity", Activity);
	        request.getRequestDispatcher("admin/activity.jsp").forward(request, response);
		}
		else{
		Part activityPart=request.getPart("ActivityPicturePath");
		String header=activityPart.getHeader("Content-Disposition");
		System.out.println("header:"+header);
		String filename=((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
		String extname=filename.substring(filename.lastIndexOf('.'));
		String newfilename=System.currentTimeMillis()+extname;
		String uploadpath=getServletContext().getRealPath("/admin/IMG/Activity");
		System.out.println("filename:"+filename);
		System.out.println("extname:"+extname);
		System.out.println("newfilename:"+newfilename);
		System.out.println("uploadpath:"+uploadpath);
		try {
			activityPart.write(uploadpath+File.separator+newfilename);
			String activityPath="admin/IMG/Activity/"+newfilename;
			int ID=Integer.parseInt(storeID);
			System.out.println(activityPath);
			System.out.println(ID);
			AdminInfoService service=new AdminInfoService();
            if(service.addActivity(ID, activityPath,activity)){
				request.setAttribute("msg","添加成功" );
			}else {
				request.setAttribute("msg","不存在店铺编号" );
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("msg","添加失败" );
		}
		request.getRequestDispatcher("/admin/addactivity.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
