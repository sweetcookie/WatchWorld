package cn.edu.zhku.hyw.watchworld.store.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.store.Service.OrderInfoService;
@WebServlet("/store/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderID = request.getParameter("OrderID");
		OrderInfoService service = new OrderInfoService();
		if( service.changeStatus(orderID)){
			request.setAttribute("msg", "成功发货!");
			request.getRequestDispatcher("/store/OrderShowServlet?status=noaccepted").forward(request, response);
		}
		
	}

}
