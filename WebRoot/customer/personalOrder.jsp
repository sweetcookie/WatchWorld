<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单中心</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/personalOrder.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/personalOrder.js"></script>

  </head>
  
  <body>
  	 <p id="title">订单中心</p><hr>
   	<div id="mainContainer">
		<div id="contentContainer">
			<div id="ctrlBar">
				<p>筛选：</p>
				<select id="selection" onchange="loadData()">
					<option value="所有订单">所有订单</option>
					<option value="未发货">未发货</option>
					<option value="已发货">已发货</option>
					<option value="已签收">已签收</option>
				</select>
			</div>
		</div>
	</div>
  </body>
</html>
