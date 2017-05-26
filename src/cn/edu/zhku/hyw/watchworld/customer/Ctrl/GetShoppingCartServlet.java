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

import cn.edu.zhku.hyw.watchworld.customer.Dao.ShoppingCartInfoDao;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.ShoppingCartInfo;
import cn.edu.zhku.hyw.watchworld.customer.Service.ShoppingCartService;

/**
 * Servlet implementation class GetShoppingCartServlet
 */
@WebServlet("/customer/shoppingCart/getData")
public class GetShoppingCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShoppingCartServlet()
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
		String customerId = (String)request.getSession().getAttribute("customerId");
		ShoppingCartService service = ShoppingCartService.getInstance();
		List<ShoppingCartInfo> dataList = service.findByUserID(customerId);
		JSONArray json = new JSONArray();
		json.addAll(dataList);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
