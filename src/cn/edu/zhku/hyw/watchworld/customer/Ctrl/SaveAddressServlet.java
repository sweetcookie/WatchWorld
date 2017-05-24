package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.Service.AddressService;

/**
 * Servlet implementation class SaveAddressServlet
 */
@WebServlet("/customer/address/saveData")
public class SaveAddressServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveAddressServlet()
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
		String address = (String)request.getParameter("addressInput");
		AddressService service = AddressService.getInstance();
		boolean flag = service.saveAddress(customerId, address);
		PrintWriter out = response.getWriter();
		if(flag == true)
		{
			out.print("保存成功！");
		}
		else
		{
			out.print("系统错误，保存失败！");
		}
	}

}
