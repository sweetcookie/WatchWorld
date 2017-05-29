<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>顾客登录</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/login.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/login.js"></script>
  </head>
  
  <body>
  	<div id="header">
  		<a href="<%= path %>/index.jsp"><img id="logo" src="<%= path %>/customer/IMG/logo.png"></a>
  		<p>欢迎登陆</p>
  	</div>
  	<div id="mainContainer">
  		<img src="<%= path %>/customer/IMG/pic1.jpg">
  		<div id="loginContainer">
  			<p id="loginTitle">账户登陆</p><hr>
  			<div id="inputContainer">
  				<form id="loginForm">
		  			<input type="text" value="" name="loginID" id="loginID" onfocus="focusID()" onblur="blurID()">
		  			<input type="text" value="" name="loginPwd" id="loginPwd" onfocus="focusPwd()" onblur="blurPwd()">
		  			<input type="button" id="submitBtn" onclick="submitForm()" value="登陆">
  				</form>
	  			<p id="loginErr"></p>
  			</div>
  		</div>
  	</div>
  	<div id="footer">Copyright © 2017</div>
  </body>
</html>
