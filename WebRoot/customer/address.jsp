<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>收货地址</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/address.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/address.js"></script>
  </head>
  
  <body>
    <p id="title">收货地址</p><hr>
   	<div id="itemContainer">
		<form id="addressForm">
	   		<div class="dataItem" id="addressItem">
	   			<div class="label">默认收货地址：</div>
	   			<input type="text" name="addressInput"><br>
	   		</div>   	
	 		<div id="btnContainer">
	 			<input type="button" value="保存" id="saveBtn" onclick="submitForm()">
	 		</div>
		</form>
	</div>
  </body>
</html>
