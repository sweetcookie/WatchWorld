<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="admin/JS/jquery-3.2.0.min.js"></script> 
    <script type="text/javascript" src="admin/JS/login.js"></script>
    <link rel="stylesheet" href="admin/CSS/adminlogincss.css" type="text/css">
    
  </head>
  
  <body onload="javascript:document.getElementByld('search').focus();">
  	<div id="header">
        <a href="#" id="logo"></a>
	</div>
  
    <div id="loginform">
        <form method="post" name="loginform" class="loginform" >
        <div class="item">
             <label class="formlabel">账 号</label>
             <input type="text" class="content" id="LoginName" onfocus="clearMeg()">
        </div>
        <div class="item">
             <label class="formlabel">密 码</label>
             <input type="password" class="content" id="LoginPWD" onfocus="clearMeg()">
        </div>
        <div id="tips">
             <span id="Meg"></span>
        </div>
        <div id="loginbtn">
             <input type="button" value="登录" id="btn-login" onclick="loginCheck()" >
        </div>
        </form>
    </div>
  </body>
</html>
