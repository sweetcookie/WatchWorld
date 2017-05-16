<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页-WatchWorld</title>
	<link rel="stylesheet" type="text/css" href="customer/CSS/index.css">
	<script type="text/javascript" src="customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="customer/JS/index.js"></script>
  </head>
  <body>
  	<div id="header">
  		<div id="adminCenter" class="headerFlag">
  			<a href="">运营商中心</a>
  		</div>
  		<div class="headerFlag">|</div>
  		<div id="storeCenter" class="headerFlag">
  			<a href="">商家中心</a>
  		</div>
	 	<div class="headerFlag">|</div>
	 	<div id="shoppingCart" class="headerFlag">
	 		<a href="customer/shoppingCart.jsp">购物车</a>
	 	</div>
		<div id="register" class="headerFlag">
				<a href="customer/register.jsp">免费注册</a>
		</div>
		<%
	  		String customerId = (String)session.getAttribute("customerId");
	  		if(customerId == null)
	  		{
		%>
		  		<div id="loggingStatus" class="headerFlag">
		  			您好！<a href="customer/login.jsp">请登录</a>
		  		</div>
		<%  		
	  		}
	  		else
	  		{
	  	%>
	  			<div id="loggingStatus" class="headerFlag">
	  				欢迎使用！<a href="customer/homePage.jsp"><%= customerId %></a>
	  			</div>
	  	<%
	  		}
	  	%>
  	</div>
  	<div id="container">
  		<div id="logoSearcherContainer">
  			<div id="logoContainer">
  				<img src="customer/IMG/logo.png" />
  			</div>
  			<div id="searcherContainer">
  				<div id="searcher">
	  				<form action="customer/searchResult">
	  					<input type="text" name="keyword" id="inputBox"/>
	  					<input type="submit" value="搜索" id="submitBtn"/>
	  				</form>
  				</div>
  			</div>
  		</div>
  		<div id="activityContainer">
  		</div>
		<div id="picIndexContainer">
		</div>
		<div id="displayContainer">
			<h2>热销产品</h2><hr>
			<div class="brandGoods">
				<div class="brand">
					<h3>欧米伽</h3>
				</div>
				<div class="goods"></div>
			</div>
		</div>
  	</div>
  	<div id="footer"></div>
  </body>
</html>
