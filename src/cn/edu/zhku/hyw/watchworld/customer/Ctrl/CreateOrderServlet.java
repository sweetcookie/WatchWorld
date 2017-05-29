package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsCounter;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserData;
import cn.edu.zhku.hyw.watchworld.customer.Service.OrderService;
import cn.edu.zhku.hyw.watchworld.customer.Service.PersonalDataService;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderGoods;

/**
 * Servlet implementation class CreateOrderServlet
 */
@WebServlet("/customer/order/createOrder")
public class CreateOrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateOrderServlet()
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
		String customerId = (String)request.getSession().getAttribute("customerId");
		OrderService service = OrderService.getInstance();
		List<GoodsCounter> gcList = service.translateToGoodsCounter(para);
		List<OrderGoods> ogList = service.createOrderGoods(gcList); //分类前
		Map<String, List<OrderGoods>> dataMap = service.createStoreGoodsMap(ogList); //分类后
		PersonalDataService pdService = PersonalDataService.getInstance();
		UserData userData = pdService.findUserDataByUserID(customerId);
		int totalMoney = service.calcTotalMoney(ogList);
		request.setAttribute("dataMap", dataMap);
		request.setAttribute("userData", userData);
		request.setAttribute("totalMoney", totalMoney);
		request.getRequestDispatcher("/customer/order.jsp").forward(request, response);
		
System.out.println(userData.getAddress());
System.out.println((dataMap.get("8891")).get(0).getBrand());
	}
}
