package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.admin.JavaBean.PageBean;
import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;
@WebServlet(name="StoreInfoSearchServlet",urlPatterns="/StoreInfoSearchServlet")
public class StoreInfoSearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public StoreInfoSearchServlet() {
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
		/*String page=request.getParameter("page");*/
		String choose=request.getParameter("Choose");
        String searchContent=request.getParameter("searchContent");
        if(searchContent==null){
        	searchContent="1";
        }
        if(choose==null){
        	choose="1";
        }
        System.out.println(choose);
        System.out.println(searchContent);
        int curPage=1;
        String sql="1";
        AdminInfoService storeInfo=new AdminInfoService();
        PageBean pageBean=new PageBean();
        if(choose.equals("name")){
            sql="select * from store_info where StoreName like '%"+searchContent+"%' ";
        }
        else if(choose.equals("owner")){
        	sql="select * from store_info where Owner like '%"+searchContent+"%' ";
        }
       /* else if(choose.equals("ID")&&searchContent.length()>0){
                int ID=Integer.parseInt(searchContent);
        	    sql="select * from store_info where StoreID="+ID+" ";
        	    searchContent=String.valueOf(ID);
        }*/
        else{
        	sql="select * from store_info ";
        }
        
        System.out.println(sql);
        pageBean=storeInfo.getStoreInfo_page(sql,curPage);//报错
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("choose", choose);
        request.setAttribute("search", searchContent);
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
