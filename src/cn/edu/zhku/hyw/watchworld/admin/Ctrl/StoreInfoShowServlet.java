package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import net.sf.json.JSONObject;*/

import cn.edu.zhku.hyw.watchworld.admin.JavaBean.PageBean;
import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;

@WebServlet(name="StoreInfoShowServlet",urlPatterns="/StoreInfoShowServlet")
public class StoreInfoShowServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public StoreInfoShowServlet() {
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
		 out.println("asasa");
        String page=request.getParameter("page");
       /* String choose=request.getParameter("Choose");
        String searchContent=request.getParameter("searchContent");
        System.out.println(page);
        System.out.println(choose);
        System.out.println(searchContent);*/
        int curPage=1;
        if(page!=null&&page.length()>0){
        	curPage=Integer.parseInt(page);
        }
        AdminInfoService storeInfo=new AdminInfoService();
        PageBean pageBean4=new PageBean();
        String sql="select * from store_info ";
        pageBean4=storeInfo.getStoreInfo_page(sql,curPage);//报错
        request.setAttribute("pageBean", pageBean4);
        request.getRequestDispatcher("admin/adminhomepage.jsp").forward(request, response);
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
