<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>确认订单</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/order.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/order.js"></script>
  </head>
  <body>
  	<jsp:include page="/customer/header.jsp"></jsp:include>
   	<div id="titleContainer">
  		<a href="<%= path %>/index.jsp">
  			<img id="logo" src="<%= path %>/customer/IMG/logo.png">
  		</a>
  		<p id="mainTitle">确认订单</p>
  	</div>
  	<div id="mainContainer">
  		<div id="addressContainer">
  			<div class="addressPanel">
  				<p id="minTitle">确认收货地址</p>
  				<input type="text" value="${ userData.address }">
  			</div>
  		</div>
  		<div id="goodsContainer">
  			<div id="tableContainer">
	  			<p class="minTitle">确认订单信息</p>
	  			<table>
	  				<tr>
	  					<th>商品名称</th>
	  					<th>商品属性</th>
	  					<th>单价</th>
	  					<th>数量</th>
	  					<th>小计</th>
	  				</tr>
	  				<c:forEach var="i" items="${ dataMap }">
	  					<c:forEach var="j" items="${ i.value }">
	  						<tr>
	  							<td>
	  								<img src="<%= path %>/<c:out value='${ j.goodsPicturePath }' />">
	  								<p class="goodsName"><c:out value="${ j.goodsName }" /></p>
	  							</td>
	  							<td>
	  								<p class="goodsAttr">品牌：<c:out value="${ j.brand  }" /></p>
	  								<p class="goodsAttr">颜色：<c:out value="${ j.color  }" /></p>
	  								<p class="goodsAttr">型号：<c:out value="${ j.model  }" /></p>
	  							</td>
	  							<td>
	  								<p class="goodsPrice"><c:out value="${ j.price  }" /></p>
	  							</td>
	  							<td>
	  								<p class="goodsAmount"><c:out value="${ j.buyAmount  }" /></p>
	  							</td>
	  							<td>
	  								<p class="goodsTotal"><c:out value="${ j.price * j.buyAmount  }" /></p>
	  							</td>
	  						</tr>	
	  					</c:forEach>
	  				</c:forEach>
	  			</table>
  			</div>
  		</div>
  		<div id="submitContain">
  			<div id="submitPanel">
  				<p id="totalMoney">实付款：<span></span></p>
  				<p id="addressBar">寄送至：<span></span></p>
  			</div>
  		</div>
  	</div>
 	<div id="footer">
		Copyright © 2017
  	</div>
  </body>
</html>
