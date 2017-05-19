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

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsDisplayInfo;
import cn.edu.zhku.hyw.watchworld.customer.Service.IndexService;

@WebServlet(name="FindGoodsDisplayInfoServlet",urlPatterns="/index/goodsDisplayInfo")
public class FindGoodsDisplayInfoServlet extends HttpServlet
{

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
			throws ServletException, IOException
	{
		doPost(request, response);
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
			throws ServletException, IOException
	{
		String brand = request.getParameter("brand");
		IndexService service = IndexService.getInstance();
		List<GoodsDisplayInfo> dataList = service.findGoodsDisplayInfoByBrand(brand);
		JSONArray json = new JSONArray();
		json.addAll(dataList);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
