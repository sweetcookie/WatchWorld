<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>店铺登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="store/CSS/login.css">
	
	<script type="text/javascript" src="store/JS/jquery-3.2.0.min.js"></script> 
	 <script type="text/javascript" src="store/JS/login.js"></script>

  </head>
  
  <body>
  <div id="header" >
  	<div id="logo-con">
        <a href="#" id="logo"></a>
        <div id="logo-title">店铺登录</div>
        <div id="reg-store"> <a href="<%=basePath %>/store/register.jsp">注册新用户</a></div>
	</div>
  </div>
  
    <div class="login-div">
    <form id="form_login">
    <div class="form-item">
    <label>用 &nbsp; &nbsp;户 &nbsp; &nbsp;名</label>
    <input type="text" name="LoginName" id="LoginName"  maxlength="15" >
    </div>
    <div id="div-placeholder"></div>
    <div class="form-item">
    <label>&nbsp; &nbsp;密&nbsp; &nbsp;&nbsp; &nbsp;码</label>
    <input type="password" name="Pwd" id="Pwd"  maxlength="15">
    </div>
    <div class="input-tip">
    <span id="Meg"></span>
    </div>
    <div>
    <input type="button" value="登录" id="btn-login" onclick="loginStore() ">
    </div>
    </form>
    </div>
  </body>
</html>
