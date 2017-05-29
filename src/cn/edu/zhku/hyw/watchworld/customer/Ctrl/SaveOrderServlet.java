package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.Service.OrderService;

/**
 * Servlet implementation class SaveOrderServlet
 */
@WebServlet("/customer/order/saveOrder")
public class SaveOrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveOrderServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String para = request.getParameter("para");
		String address = request.getParameter("addressPara");
		String customerId = (String)request.getSession().getAttribute("customerId");
		OrderService service = OrderService.getInstance();
		boolean flag = service.saveOrder(para, customerId, address);
		request.setAttribute("flag", String.valueOf(flag));
		request.getRequestDispatcher("/customer/orderSubmitStatus.jsp").forward(request, response);
	}

}
