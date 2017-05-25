<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品详情</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/goods.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/goods.js"></script>

  </head>
  <body>
	 <jsp:include page="/customer/header.jsp"></jsp:include>
	 <div></div>
  </body>
</html>
