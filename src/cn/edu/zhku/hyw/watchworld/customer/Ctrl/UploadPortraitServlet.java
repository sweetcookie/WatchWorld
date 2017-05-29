package cn.edu.zhku.hyw.watchworld.customer.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.customer.Service.PersonalDataService;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadPortraitServlet
 */
@WebServlet("/customer/personalData/uploadPortrait")
public class UploadPortraitServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadPortraitServlet()
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
		PrintWriter out = response.getWriter();
		String customerId = (String)request.getSession().getAttribute("customerId");
		SmartUpload smart = new SmartUpload();
		ServletConfig config = this.getServletConfig();
		smart.initialize(config, request, response);
		try
		{
			smart.upload();
			File smartFile = smart.getFiles().getFile(0);
			if(smartFile.getFileExt().equals("jpg"))
			{
				String savePath = request.getServletContext().getRealPath("/customer/IMG/portrait/"); 
				java.io.File file = new java.io.File(savePath);
				if(!file.exists())
				{
					file.mkdirs();
				}
				smartFile.saveAs(savePath + "/" + customerId + ".jpg");
				PersonalDataService service = PersonalDataService.getInstance();
				service.updatePortrait("customer/IMG/portrait/" + customerId + ".jpg",
										customerId);
			}
		} catch (SmartUploadException e)
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("/customer/personalData.jsp").forward(request, response);
	}
}
