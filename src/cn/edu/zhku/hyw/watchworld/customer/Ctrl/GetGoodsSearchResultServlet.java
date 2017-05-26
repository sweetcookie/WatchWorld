package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.directory.SearchControls;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.GoodsDisplayInfo;
import cn.edu.zhku.hyw.watchworld.customer.Service.SearchResultService;

/**
 * Servlet implementation class GetGoodsSearchResultServlet
 */
@WebServlet("/customer/searchResult/getResult")
public class GetGoodsSearchResultServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetGoodsSearchResultServlet()
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
		String keyword = request.getParameter("keyword");
		int pageIdx = Integer.parseInt(request.getParameter("pageIdx"));
		int len = 10; //每一页的数据量
		SearchResultService service = SearchResultService.getInstance();
		List<GoodsDisplayInfo> dataList = service.findByGoodsName(keyword, pageIdx, len);
		int pageAmount = service.getTotalPageNum(keyword, len);
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(dataList);
		JSONObject json = new JSONObject();
		json.put("data", jsonArray);
		json.put("pageAmount", pageAmount);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
