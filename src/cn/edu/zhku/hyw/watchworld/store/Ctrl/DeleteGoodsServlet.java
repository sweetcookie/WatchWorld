package cn.edu.zhku.hyw.watchworld.store.Ctrl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.Service.GoodsInfoService;
@WebServlet("/store/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String storeIDString = (String)session.getAttribute("StoreID");
		int StoreID=Integer.parseInt(storeIDString);
		String goodsIDString=request.getParameter("GoodsID");
		int GoodsID=Integer.parseInt(goodsIDString);
		GoodsInfoService service=new GoodsInfoService();
		GoodsInfo goodsInfo=service.findGoodsByID(GoodsID, StoreID);
		if(service.deleteGoods(GoodsID)){
			String url= getServletContext().getRealPath("/store/IMG/GoodsPicture");
			File file = new File(url+File.separator+goodsInfo.getGoodsPicturePath());
			file.delete();
			request.setAttribute("msg", "删除成功!");
			request.getRequestDispatcher("/store/GoodsShowServlet").forward(request, response);
		}
	}

}
