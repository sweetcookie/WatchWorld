package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.customer.Service.GoodsService;

/**
 * Servlet implementation class GetGoodsInfoServlet
 */
@WebServlet("/customer/goods/getData")
public class GetGoodsInfoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetGoodsInfoServlet()
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
		String goodsID = request.getParameter("goodsID");
		GoodsService service = GoodsService.getInstance();
		GoodsInfo info = service.findByGoodsID(goodsID);
		String storeName = service.findStoreNameByStoreID(info.getStoreID());
		JSONObject json = JSONObject.fromObject(info);
		json.element("storeName", storeName);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
