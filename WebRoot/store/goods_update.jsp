<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="store/CSS/goods_manage.css" />
	<script type="text/javascript" src="store/JS/jquery-3.2.0.min.js"></script> 
	<script type="text/javascript" src="store/JS/goods_manage.js"></script>
	
  </head>

  <body>
  	<h3>商品修改</h3>
			<c:if test="${not empty requestScope.goodsInfo}">
						<form id="form_goodsUpdate" action="<%=basePath %>store/GoodsUpdateServlet" method="post" enctype="multipart/form-data">
						商品编号:<input type="text" name="GoodsID" id="GoodsID"  readonly="readonly" value="${requestScope.goodsInfo.goodsID}"><br>
						商品名称:<input type="text" name="GoodsName" id="GoodsName"  value="${requestScope.goodsInfo.goodsName}"><br>
						商品图片:<img alt="加载失败" src="./store/IMG/GoodsPicture/${requestScope.goodsInfo.goodsPicturePath}" height="70px" width="70px"><br>
						<input type="text"  style="display:none;" name="f_GoodsPicturePath" value="${requestScope.goodsInfo.goodsPicturePath}">
						<input type="file" name="GoodsPicturePath" id="GoodsPicturePath" accept="image/*" ><br>
						价格:<input type="text" name="Price" id="Price" value="${requestScope.goodsInfo.price}"><br>
						品牌:<input type="text" name="Brand" id="Brand" value="${requestScope.goodsInfo.brand}"><br>
						颜色:<input type="color" name="Color"id="Color" value="${requestScope.goodsInfo.color}"><br>
						型号:<input type="text" name="Model" id="Model" value="${requestScope.goodsInfo.model}"><br>
						库存:<input type="text" name="Number"id="Number" value="${requestScope.goodsInfo.number}"><br>
						销量:<input type="text" name="SalesVolumes" id="SalesVolumes" readonly="readonly" value="${requestScope.goodsInfo.salesVolumes}"><br>
						<input type="button" value="修改"  onclick="updateGoods(form_goodsUpdate)"><span ><font color="red" id="Mesg">${requestScope.msg}</font></span>
					</form>
			</c:if>
  </body>
</html>
