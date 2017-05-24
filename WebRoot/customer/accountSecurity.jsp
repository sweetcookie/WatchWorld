<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>账户安全</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/accountSecurity.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/accountSecurity.js"></script>
  </head>
  
  <body>
   	<p id="title">账户安全</p><hr>
   	<div id="itemContainer">
		<form id="passwordForm">
			<div class="dataItem" id="userIDItem">
	  			<div class="label">账号：</div>
	  			<p id="userID">${customerId}</p>
	  		</div>
	   		<div class="dataItem" id="passwordItem">
	   			<div class="label">密码：</div>
	   			<input type="password" name="password" onblur="checkPassword(this)"><br>
	   			<p class="errorLab"></p>
	   		</div>
	   		<div class="dataItem" id="confirmPasswordItem">
	   			<div class="label">确认密码：</div>
	   			<input type="password" name="confirmPassword" onblur="checkConfirmPassword(this)"><br>
	   			<p class="errorLab"></p>
	   		</div>
	 		<div id="btnContainer">
	 			<input type="button" value="保存" id="saveBtn" onclick="submitForm()">
	 		</div>
		</form>
	</div>
  </body>
</html>
