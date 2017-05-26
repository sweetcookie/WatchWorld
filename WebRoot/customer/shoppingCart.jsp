<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>购物车</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/shoppingCart.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/shoppingCart.js"></script>
  </head>
  
  <body>
  	<jsp:include page="/customer/header.jsp"></jsp:include>
   	<div id="titleContainer">
  		<a href="<%= path %>/index.jsp">
  			<img id="logo" src="<%= path %>/customer/IMG/logo.png">
  		</a>
  		<p id="mainTitle">我的购物车</p>
  	</div>
  	<div id="mainContainer">
  		<div id="tableContainer">
  			<table id="contentTable">
  				<tr>
  					<th>商品信息</th>
  					<th>单价</th>
  					<th>数量</th>
  					<th>金额</th>
  					<th>操作</th>
  					<th>选定</th>
  				</tr>
  			</table>
  		</div>
  		<div id="accountBar">
  			<div>
  				<input type="button" value="结算" id="accountBtn" onclick="">
  			</div>
  			<div>
  				<p>合计：<span id="total">￥111111</span></p>
  			</div>
  			<div>
  				<p>已选择<span id="selectedAccount">111</span>件商品</p>
  			</div>
  		</div>
  	</div>
  	<div id="footer">
  		Copyright © 2017
  	</div>
  </body>
</html>
