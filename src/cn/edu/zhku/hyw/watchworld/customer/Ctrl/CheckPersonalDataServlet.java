package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.hyw.watchworld.customer.Service.PersonalDataService;

/**
 * Servlet implementation class CheckPersonalDataServlet
 */
@WebServlet("/customer/personalData/checkData")
public class CheckPersonalDataServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckPersonalDataServlet()
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
		String userID = (String)request.getSession().getAttribute("customerId");
		String userName = request.getParameter("userName");
		String strAge = request.getParameter("age");
		if(strAge == null || strAge == "")
		{
			strAge = "-1";
		}
		int age = Integer.parseInt(strAge);
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		PersonalDataService service = PersonalDataService.getInstance();
		Map<String, String> resultMap = service.checkPersonalData(userID, userName, age, sex, telephone);
		JSONObject json = new JSONObject();
		json.putAll(resultMap);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
