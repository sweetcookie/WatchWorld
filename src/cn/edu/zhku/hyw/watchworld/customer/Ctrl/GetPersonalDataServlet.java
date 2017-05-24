package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.hyw.watchworld.customer.JavaBean.UserData;
import cn.edu.zhku.hyw.watchworld.customer.Service.PersonalDataService;

/**
 * Servlet implementation class GetPersonalDataServlet
 */
@WebServlet("/customer/personalData/getData")
public class GetPersonalDataServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPersonalDataServlet()
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
		PersonalDataService service = PersonalDataService.getInstance();
		UserData data = service.findUserDataByUserID(customerId);
		JSONObject json = JSONObject.fromObject(data);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
