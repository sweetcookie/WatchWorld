package cn.edu.zhku.hyw.watchworld.store.Ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.hyw.watchworld.store.JavaBean.GoodsInfo;
import cn.edu.zhku.hyw.watchworld.store.JavaBean.PageBean;
import cn.edu.zhku.hyw.watchworld.store.Service.GoodsInfoService;
@WebServlet("/store/GoodsShowServlet")
public class GoodsShowServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			HttpSession session = request.getSession(false);
			int StoreID= Integer.parseInt((String) session.getAttribute("StoreID"));	
			//1. 获取“当前页”参数；  (第一次访问当前页为null) 
			System.out.println("StoreID:"+StoreID);
			String currPage = request.getParameter("currentPage");
			// 判断
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "0";  	// 第一次访问，设置当前页为0;后续在dao层设置为1;
			}
			// 转换
			System.out.println("currPage:"+currPage);
			int currentPage = Integer.parseInt(currPage);
			
			//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
			PageBean<GoodsInfo> pageBean =new PageBean<GoodsInfo>();
			pageBean.setCurrentPage(currentPage);
			
			//3. 调用service  
			GoodsInfoService service = new GoodsInfoService(); // 【pageBean已经被dao填充了数据】
			boolean flag = service.findAllGoods(StoreID, pageBean);
			
			//4. 保存pageBean对象，到request域中
			if(flag==true){
				request.setAttribute("pageBean", pageBean);
			}
			//5. 跳转 
			request.setAttribute("msg", request.getAttribute("msg"));
			request.getRequestDispatcher("/store/goods_show.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();  
		
		}
		
		
	}

}
