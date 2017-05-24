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

import cn.edu.zhku.hyw.watchworld.customer.Service.AccountSecurityService;

/**
 * Servlet implementation class CheckAccountSecurityServlet
 */
@WebServlet("/customer/accountSecurity/checkData")
public class CheckAccountSecurityServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckAccountSecurityServlet()
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
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("confirmPassword");
		AccountSecurityService service = AccountSecurityService.getInstance();
		Map<String, String> resultMap = service.checkPwd(customerId, password1, password2);
		JSONObject json = new JSONObject();
		json.putAll(resultMap);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
