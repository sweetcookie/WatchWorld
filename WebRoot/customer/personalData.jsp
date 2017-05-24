<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人资料</title>
	<link rel="stylesheet" type="text/css" href="<%= path %>/customer/CSS/personalData.css">
	<script type="text/javascript" src="<%= path %>/customer/JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%= path %>/customer/JS/personalData.js"></script>
  </head>
  
  <body>
	<p id="title">个人资料</p><hr>
   	<div id="itemContainer">
   		<div id="portraitData">
   			<div class="label">头像：</div>
   			<div id="portraitContainer">
   				<img id="portraitIMG" src="">
   			</div>
   			<div id="upLoadContainer">
   				<form id="portraitForm" action="<%= path %>/customer/personalData/uploadPortrait" method="post" enctype="multipart/form-data">
	   				<input type="submit" id="portraitBtn" value="上传">
	   				<input type="file" name="pic" id="uploadPic">
   				</form>
   			</div>
   		</div>
		<form id="personalForm">
	  		<div class="dataItem" id="userIDItem">
	  			<div class="label">账号：</div>
	  			<p id="userID"></p>
	  		</div>
	  		<div class="dataItem" id="userNameItem">
	  			<div class="label">昵称：</div>
	  			<input type="text" name="userName"><br>
	  			<p class="errorLab"></p>
	  		</div>
	  		<div class="dataItem" id="ageItem">
	  			<div class="label">年龄：</div>
	  			<input type="text" name="age" onblur="checkAge(this)"><br>
	  			<p class="errorLab"></p>
	  		</div>
	  		<div class="dataItem" id="sexItem">
	  			<div class="label">性别：</div>
	  			<div style="width:60px;padding:0px;height:25px;float:left">
	   			<input type="radio" name="sex" value="男" style="width:20px;height:25px;">男
	  			</div>
	  			<div style="width:60px;padding:0px;height:25px;float:left">
	   			<input type="radio" name="sex" value="女" style="width:20px;height:25px;">女
	  			</div>
	  			<p class="errorLab"></p>
	  		</div>
	  		<div class="dataItem" id="telephoneItem">
	  			<div class="label">联系方式：</div>
	  			<input type="text" name="telephone"><br>
	  			<p class="errorLab"></p>
	  		</div>
	 			<div id="btnContainer">
	 				<input type="button" value="保存" id="saveBtn" onclick="submitForm()">
	 		</div>
		</form>
	</div>
  </body>
</html>