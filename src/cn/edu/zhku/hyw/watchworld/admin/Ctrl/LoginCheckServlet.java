package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;
@WebServlet(name="LoginCheckServlet",urlPatterns="/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public LoginCheckServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String LoginName=request.getParameter("LoginName");
		String LoginPWD=request.getParameter("LoginPWD");
		AdminInfoService service=new AdminInfoService();
		JSONObject resultJson=new JSONObject();
		int flag=service.loginCheck(LoginName,LoginPWD);
	   // out.print(flag);
		if (flag==2) 
		{
			resultJson.put("flag", "LoginNameNoFound");
		} 
		else if(flag==1)
		{
			resultJson.put("flag", "LoginPWDWrong");
		}
		else if(flag==0)
		{
			resultJson.put("flag", "Correct1");
			request.getSession().setAttribute("AdminID", LoginName);
			request.getSession().setAttribute("AdminSession","root"); 	
		}
		else if(flag==-1)
		{
			resultJson.put("flag", "Correct2");
			request.getSession().setAttribute("AdminID", LoginName);
			request.getSession().setAttribute("AdminSession","leave"); 
		}

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
