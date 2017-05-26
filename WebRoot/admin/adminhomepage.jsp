<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminhomepage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="admin/JS/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="admin/JS/adminhomepage.js"></script>
    <link rel="stylesheet" href="admin/CSS/homepagecss.css" type="text/css">
  </head>
  
  <body>
<!--   <p><img border="0" src="admin/IMG/bg05.jpg" width="120" height="151"></p> -->
    <div id="float">
        <%
            String AdminID = (String) session.getAttribute("AdminID");
			String AdminSession = (String) session.getAttribute("AdminSession");
            if(AdminID!=null){%>
			<a  class="a" >你好：<%=AdminID %></a>
			<%
			}
	     if (AdminSession=="root") {
		%>
		<a  class="a" href="admin/register.jsp">创建新账号&nbsp; </a><a>| </a>
		<%
		}
		 %>
		 <a  class="a" href="admin/login.jsp">退出登录&nbsp;</a><a>|</a>
		 <a  class="a" href="admin/register.jsp">修改密码&nbsp;</a>
		</div>
		<div class="div1">
		<h2 align="center">店铺信息</h2>
		<div class="Search" align="center">
		<form >
		  <select id="choose" >
		  <option  value="ID" ${choose=="ID"?'selected':""}> 店铺ID</option>
		  <option value="name" ${choose=="name"?'selected':""}> 店铺名</option>
		  <option value="owner" ${choose=="owner"?'selected':""}> 店主</option>
		  </select>
		  <input type="text" id="search" id="searchtext" >
		  <input type="button" id="sbtn" value="搜索" onclick="storeSearch(search)">	
		  <a  class="a" href="StoreInfoShowServlet">显示所有店铺</a>	
		  </form>  
		  </div>
		<div>
		<table align="center">
		<tr><th>店铺ID</th><th>店铺名</th><th>店主</th><th>联系电话</th><th>注册时间</th><th>网址</th><th>注销店铺</th></tr>
		<c:forEach var="store" items = "${pageBean.data }" varStatus="vs">
		<tr>
		<td align="center"><c:out value ="${store.StoreID } "/></td>
		<td align="center"><c:out value ="${store.StoreName }"/></td>
		<td align="center"><c:out value ="${store.Owner }"/></td>
		<td align="center"><c:out value ="${store.Telephone }"/></td>
		<td align="center"><c:out value ="${store.RegTime }"/></td>
		<td align="center"><a  class="a" href="login.jsp">进铺逛逛</a></td>
		<td align="center"><input type="button" value="封铺" id=“destroy”></td>
		</tr>
		</c:forEach>
		</table >
		</div>
		<p align="center">
		每页${pageBean.pageSize }行
		共${pageBean.totalRows }行
		页数${pageBean.curPage }/${pageBean.totalPages }
		<br/>
		<c:choose>
		    <c:when test="${pageBean.curPage==1 }">首页 上一页</c:when>
		    <c:otherwise>
		        <a href="StoreInfoShowServlet?page=1">首页</a>
		        <a href="StoreInfoShowServlet?page=${pageBean.curPage-1 }">上一页</a>
		    </c:otherwise>
		</c:choose>
		<c:choose>
		    <c:when test="${pageBean.curPage==pageBean.totalPages }">下一页 尾页</c:when>
		    <c:otherwise>
		        <a href="StoreInfoShowServlet?page=${pageBean.curPage+1 }">下一页</a>
		        <a href="StoreInfoShowServlet?page=${pageBean.totalPages }">尾页</a>
		    </c:otherwise>
		</c:choose>
		</p>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
  </body>
</html>
