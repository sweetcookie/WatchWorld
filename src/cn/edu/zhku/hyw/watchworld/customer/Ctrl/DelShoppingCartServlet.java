package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.Service.ShoppingCartService;

/**
 * Servlet implementation class DelShoppingCartServlet
 */
@WebServlet("/customer/shoppingCart/delData")
public class DelShoppingCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelShoppingCartServlet()
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
		int goodsID = Integer.parseInt(request.getParameter("goodsID"));
		String userID = (String)request.getSession().getAttribute("customerId");
		ShoppingCartService service = ShoppingCartService.getInstance();
		service.delInfoByGoodsID(goodsID, userID);
	}

}
