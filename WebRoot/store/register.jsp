<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>店铺注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="store/CSS/styles.css">
	<script type="text/javascript" src="store/JS/jquery-1.11.1.js"></script> 
	 <script type="text/javascript" src="store/JS/base.js"></script>
  </head>
  
  <body>
    <div class="reg-form">
    <form action="" method="post">
    <div >
    <label>用户名</label>
    <input type="text" name="LoginName" id="LoginName" onblur="checkLoginName(this)">
    </div>
    <div>
    <label>设置密码</label>
    <input type="password" name="Pwd" id="Pwd">
    </div>
    <div>
    <label>登录密码</label>
    <input type="password" name="Pwd2" id="Pwd2">
    </div>
    <div>
    <label>店铺名称</label>
    <input type="text" name="StoreName" id="StoreName">
    </div>
    <div>
    <label>手机号码</label>
    <input type="number" name="Telephone" id="Telephone">
    </div>
    <div>
    <input type="submit" value="立即注册" id="submit">
    </div>
    </form>
    </div>
  </body>
</html>
