<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String keyword = request.getParameter("keyword");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><%= keyword %> - 搜索结果 - Watch-World</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/searchResult.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/searchResult.js"></script>

  </head>
  
  <body>
    <jsp:include page="/customer/header.jsp"></jsp:include>
	<div id="logoSearcherContainer">
		<div id="logoContainer">
			<img src="<%= path %>/customer/IMG/logo.png" />
		</div>
		<div id="searcherContainer">
			<div id="searcher">
				<form action="<%= path %>/customer/searchResult.jsp" method="get" id="searchForm" onsubmit="return checkEmpty()">
					<input type="text" name="keyword" id="inputBox"/>
					<input type="submit" value="搜索" id="submitBtn"/>
				</form>
			</div>
		</div>
	</div>
	<div id="optionContainer">
	</div>
	<div id="resultContainer">
	</div>
	<div id="pageIndexLine">
		<div id="pageIndexContainer" totalPage="0">
			<input type="button" value="首页" id="firstPage" onclick="loadData(1)">
			<input type="button" value="上一页" id="prePage" onclick="">
			<div id="pageNum">
				<p></p>
			</div>
			<input type="button" value="下一页" id="nextPage" onclick="">
			<input type="button" value="尾页" id="lastPage" onclick="">
		</div>
	</div>
	<div id="footer">
		Copyright © 2017
	</div>
  </body>
</html>
