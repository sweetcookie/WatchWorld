package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.Service.LoginService;

/**
 * Servlet implementation class CheckCustomerLoginServlet
 */
@WebServlet("/customer/login/checkLogin")
public class CheckCustomerLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCustomerLoginServlet()
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
		String loginID = request.getParameter("loginID");
		String loginPwd = request.getParameter("loginPwd");
		LoginService service = LoginService.getInstance();
		String result = service.checkLogin(loginID, loginPwd);
		if(result.equals(""))
		{
			request.getSession().setAttribute("customerId", loginID);
		}
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
