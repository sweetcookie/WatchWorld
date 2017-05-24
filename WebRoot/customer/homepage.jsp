<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人中心</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/homepage.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/homepage.js"></script>
  </head>
  
  <body>
  	<jsp:include page="/customer/header.jsp"></jsp:include>
  	<div id="titleContainer">
  		<a href="<%= path %>/index.jsp">
  			<img id="logo" src="<%= path %>/customer/IMG/logo.png">
  		</a>
  		<p id="mainTitle">个人中心</p>
  		<a id="backToIndex" href="<%= path %>/index.jsp">返回首页</a>
  	</div>
  	<div id="mainContainer">
  		<div id="sidebar">
  			<p class="itemTitle">账户设置</p>
  			<a class="item" href="<%= path %>/customer/personalData.jsp" target="contentFrame">个人资料</a><br>
  			<a class="item" href="<%= path %>/customer/accountSecurity.jsp" target="contentFrame">账户安全</a><br>
  			<a class="item" href="<%= path %>/customer/address.jsp" target="contentFrame">收货地址</a><br>
  			<p class="itemTitle">订单中心</p>
  			<a class="item">我的订单</a><br>
  			<p class="itemTitle">售后服务</p>
  			<a class="item">退货</a><br>
  		</div>
  		<div id="contentContainer">
  			<iframe src="" name="contentFrame" width="1000px" height="100%" frameborder="0"></iframe>
  		</div>
  	</div>
  	<div id="footer">
  		Copyright © 2017
  	</div>
  </body>
</html>
