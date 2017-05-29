package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.OrderGoods;
import cn.edu.zhku.hyw.watchworld.customer.Service.PersonalOrderService;

/**
 * Servlet implementation class GetOrderGoodsServlet
 */
@WebServlet("/customer/personalOrder/getGoods")
public class GetOrderGoodsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOrderGoodsServlet()
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
		String orderID = request.getParameter("orderID");
		PersonalOrderService service = PersonalOrderService.getInstance();
		List<OrderGoods> ogList = service.findOrderGoodsByOrderID(orderID);
		JSONArray json = JSONArray.fromObject(ogList);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
