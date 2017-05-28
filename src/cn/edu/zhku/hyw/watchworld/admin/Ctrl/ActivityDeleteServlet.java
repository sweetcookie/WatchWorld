package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;

import net.sf.json.JSONObject;
@WebServlet(name="ActivityDeleteServlet",urlPatterns="/ActivityDeleteServlet")
public class ActivityDeleteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public ActivityDeleteServlet() {
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

		doPost(request,response);
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String ActivityName=request.getParameter("ActivityName");
		JSONObject resultJson=new JSONObject();
		AdminInfoService service=new AdminInfoService();
		 String sql="select * from activity where ActivityName='"+ActivityName+"'";
	        List Activity=new ArrayList();
	        Map<String,String> m=new HashMap<String,String>();
	        Activity=service.getList(sql);
	        m=(Map)Activity.get(0);
	        String path=m.get("ActivityPicturePath");
	        String absPath=getServletContext().getRealPath("/"+path);
	        System.out.println(absPath);
	        if(service.deleteFiles(absPath)){
	        	System.out.println("true");
	        }
	        else{
	        	System.out.println("false");
	        }
	        
	    if(service.deleteActivity(ActivityName)){
	    	resultJson.put("flag", "true");
	    }
	    else{
	    	resultJson.put("flag", "false");
	    }
	    System.out.println(resultJson);
	    out.print(resultJson);
		out.flush();
		out.close();
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
