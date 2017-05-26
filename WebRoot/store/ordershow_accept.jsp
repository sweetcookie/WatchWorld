<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>order_show</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
            

	<c:choose>
		<c:when test="${not empty requestScope.OrderInfo}">
		<table border="1">
			<c:forEach var="orderInfo" items="${requestScope.OrderInfo}">
			<tr>
			<td>
                                     订单编号:${orderInfo.orderID}
                                     付款时间:${orderInfo.paymentTime}
                                     发货时间:${orderInfo.sendGoodsTime}
			</td>
			</tr>
			
   				<c:forEach var="orderGoods" items="${orderInfo.orderGoods}">
   				<tr>
   				<td>
		                                商品图片:${orderGoods. goodsPicturePath}
		                                商品ID:${orderGoods.goodsID}
		                               商品名称: ${orderGoods.goodsName}
		                                价格:${orderGoods.price}
		                                购买数量:${orderGoods.buyAmount}
		                                品牌:${orderGoods.brand}
		                               颜色: ${orderGoods.color}
		                               型号: ${orderGoods.model}
   				</td>
   				</tr>
  				 </c:forEach>
  				 
  				 <tr>
			<td>
                                    收货人:${orderInfo.userName}
                                    收货地址:${orderInfo.address}
                                    总价格: ${orderInfo.totalPrice}
			</td>
			</tr>
   </c:forEach>
   </table>
		</c:when>
		<c:otherwise>
				<tr>
					<td>没有已发货订单</td>
				</tr>
		</c:otherwise>
	</c:choose>
</body>
</html>
