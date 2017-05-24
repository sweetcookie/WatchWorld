<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页-WatchWorld</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/index.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/index.js"></script>
  </head>
  <body>
	<jsp:include page="/customer/header.jsp"></jsp:include>
  	<div id="container">
  		<div id="logoSearcherContainer">
  			<div id="logoContainer">
  				<img src="customer/IMG/logo.png" />
  			</div>
  			<div id="searcherContainer">
  				<div id="searcher">
	  				<form action="customer/searchResult">
	  					<input type="text" name="keyword" id="inputBox"/>
	  					<input type="submit" value="搜索" id="submitBtn"/>
	  				</form>
  				</div>
  			</div>
  		</div>
  		<div id="activityContainer">
  		</div>
		<div id="picIndexContainer">
		</div>
		<div id="displayContainer">
			<h2>热销产品</h2><hr>
		</div>
  	</div>
  	<div id="footer">
  		Copyright © 2017
  	</div>
  </body>
</html>
