<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品详情</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/goods.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/goods.js"></script>

  </head>
  <body>
	 <jsp:include page="/customer/header.jsp"></jsp:include>
   	<div id="titleContainer">
  		<a href="<%= path %>/index.jsp">
  			<img id="logo" src="<%= path %>/customer/IMG/logo.png">
  		</a>
  		<p id="mainTitle">商品详情</p>
  	</div>
  	<div id="mainContainer">
	  	<div id="picContainer">
	  			<img src="">
	  	</div>
  		<div id="contentContainer">
			<div class="dataItem" id="goodsName">
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="price">
	   			<div class="label">价格：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="brand">
	   			<div class="label">品牌：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="color">
	   			<div class="label">颜色：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="Model">
	   			<div class="label">型号：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="Number">
	   			<div class="label">库存：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="SalesVolumes">
	   			<div class="label">销量：</div>
	   			<p></p>
	   		</div>
	   		<div class="dataItem" id="storeName">
	   			<div class="label">店铺：</div>
	   			<a href=""></a>
	   		</div>
	   		<div class="dataItem" id="amountItem">
	   			<div class="label">数量：</div>
	   			<input type="number"id="amount" min="1" value="1">
	   		</div>
	   		<div id="btnContainer">
	   			<input type="button" value="立即购买" id="buyBtn">
	   			<input type="button" value="加入购物车" id="addBtn">
	   		</div>
  		</div>
  	</div>
  	<div id="footer">
		Copyright © 2017
  	</div>
  </body>
</html>
