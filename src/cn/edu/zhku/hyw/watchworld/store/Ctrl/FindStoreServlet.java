package cn.edu.zhku.hyw.watchworld.store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.StoreInfo;
import cn.edu.zhku.hyw.watchworld.store.Service.StoreInfoService;
@WebServlet("/store/FindStoreServlet")
public class FindStoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=UTF-8"); 
        String storeString = (String) request.getSession().getAttribute("StoreID");
        int storeID = Integer.parseInt(storeString);
        StoreInfoService service = new StoreInfoService();
        StoreInfo storeInfo = service.findStoreByID(storeID);
        if (storeInfo!=null) {
			request.setAttribute("StoreInfo", storeInfo);
			request.setAttribute("msg", request.getAttribute("msg"));
			request.getRequestDispatcher("/store/store_update.jsp").forward(request, response);
		}
	}

}
