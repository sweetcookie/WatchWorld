<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>store_update</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="store/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="store/JS/store_update.js"></script>
  </head>
  
  <body>
  	<h3>基本信息</h3>
  	<label>店铺编号:${StoreInfo.storeID}</label>
  	<label >用户名:${StoreInfo.loginName}</label>
  	<label>店主:${StoreInfo.owner}</label>
  	<label>注册时间:${StoreInfo.regTime}</label>
	<form action="<%=basePath%>store/StoreUpdateServlet" method="post" id="form_updateStore">
	<input type="hidden" id="storeID" name="StoreID" value="${StoreInfo.storeID}">
	<input type="hidden" id="loginName" value="${StoreInfo.loginName}">
	<input type="hidden" id="f_storeName" value="${StoreInfo.storeName}">
	<input type="hidden" id="f_telephone" value="${StoreInfo.telephone}">
	原密码:<input type="text" id="f_pwd"><br>
	新密码:<input type="password" id="n_pwd" name="Pwd"><br>
	店铺名称:<input type="text" id="storeName" name="StoreName" value="${StoreInfo.storeName}"><br>
	手机号码:<input type="text" id="telephone" name="Telephone" value="${StoreInfo.telephone}"><br>
	<input type="button" value="保存" onclick="updateStore()"> <span ><font color="red" id="msg">${requestScope.msg}</font></span>
	</form>
  </body>
</html>

