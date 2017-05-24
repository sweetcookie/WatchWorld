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
@WebServlet("/store/StoreUpdateServlet")
public class StoreUpdateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String storeIDString=request.getParameter("StoreID");
		String pwd      =request.getParameter("Pwd");
		String storeName=request.getParameter("StoreName");
		String telephone=request.getParameter("Telephone");
		int storeID=Integer.parseInt(storeIDString);
		StoreInfo storeInto = new StoreInfo();
		storeInto.setStoreID(storeID);
		storeInto.setPassword(pwd);
		storeInto.setStoreName(storeName);
		storeInto.setTelephone(telephone);
		StoreInfoService service = new StoreInfoService();
		
		if(service.updateStore(storeInto)){
			request.setAttribute("msg", "修改成功");
		}else {
			request.setAttribute("msg", "修改失败");
		}
		request.getRequestDispatcher("/store/FindStoreServlet").forward(request, response);
	}

}
