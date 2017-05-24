<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML ">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>goods_add</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="store/JS/jquery-3.2.0.min.js"></script> 
	 <script type="text/javascript" src="store/JS/goods_manage.js"></script>
		
</head>
  
  <body>
  <div class="tittle">
  <h3>商品添加</h3>
  </div>
  <div class="">
  <form id="form_goodsAdd" action="<%=basePath %>store/GoodsAddServlet" method="post" enctype="multipart/form-data">
   	 商品名 <input type="text" name="GoodsName" id="GoodsName" maxlength="45"/><br>
	商品图片<input type="file" name="GoodsPicturePath" id="GoodsPicturePath" accept="image/*"/><br>
	价格           <input type="text" name="Price" id="Price" maxlength="9"/>$<br>
           品牌    <input type="text" name="Brand" id="Brand" maxlength="15"/><br>
           颜色    <input type="color" name="Color" id="Color" maxlength="15"/><br>
           型号    <input type="text" name="Model" id="Model" maxlength="15"/><br>
           库存    <input type="text" name="Number" id="Number" maxlength="9"/>件<br>
        <input type="text"  style="display:none;" name="StoreID" value="<%=session.getAttribute("StoreID")%>"/>
           <input type="button" value="添加" onclick="checkform(form_goodsAdd)"/><span><font color="red" id="msg">${msg}</font></span><br>
   </form>
   </div>
  </body>
</html>
