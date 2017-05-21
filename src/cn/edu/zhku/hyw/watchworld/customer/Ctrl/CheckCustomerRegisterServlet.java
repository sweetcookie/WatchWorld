package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.Activity;
import cn.edu.zhku.hyw.watchworld.customer.JavaBean.RegisterForm;
import cn.edu.zhku.hyw.watchworld.customer.Service.IndexService;
import cn.edu.zhku.hyw.watchworld.customer.Service.RegisterService;

/**
 * Servlet implementation class CheckCustomerRegisterServlet
 */
@WebServlet("/customer/register/checkRegister")
public class CheckCustomerRegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckCustomerRegisterServlet()
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
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		RegisterForm regForm = new RegisterForm();
		regForm.setUserID(request.getParameter("userID"));
		regForm.setPassword1(request.getParameter("password"));
		regForm.setPassword2(request.getParameter("confirmPassword"));
		regForm.setUserName(request.getParameter("userName"));
		String strAge = request.getParameter("age");
		if(strAge == null || strAge == "")
		{
			strAge = "-1";
		}
		regForm.setAge(Integer.parseInt(strAge));
		regForm.setSex(request.getParameter("sex"));
		regForm.setAddress(request.getParameter("address"));
		regForm.setTelephone(request.getParameter("telephone"));
		
		RegisterService service = RegisterService.getInstance();
		Map<String, String> resultMap = service.checkForm(regForm);
		JSONObject json = new JSONObject();
		json.putAll(resultMap);
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
