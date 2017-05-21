<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>顾客注册</title>
	<link rel="stylesheet" type="text/css" href="CSS/register.css">
	<script type="text/javascript" src="JS/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="JS/register.js"></script>
  </head>
  
  <body>
   	<div id="mainContainer">
	 	<a href="/WatchWorld/index.jsp"><img id="logo" src="IMG/logo.png"></a>
   		<h1>顾客注册</h1><hr>
   		<div id="itemContainer">
   			<form id="regForm">
		   		<div class="dataItem" id="userIDItem">
		   			<div class="label">账号：</div>
		   			<input type="text" name="userID" onblur="checkUserID(this)"><br>
		   			<p class="errorLab"></p>
		   		</div>
		   		<div class="dataItem" id="passwordItem">
		   			<div class="label">密码：</div>
		   			<input type="password" name="password" onblur="checkPassword(this)"><br>
		   			<p class="errorLab"></p>
		   		</div>
		   		<div class="dataItem" id="confirmPasswordItem">
		   			<div class="label">确认密码：</div>
		   			<input type="password" name="confirmPassword" onblur="checkConfirmPassword(this)"><br>
		   			<p class="errorLab"></p>
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
			   			<input type="radio" name="sex" value="男" style="width:20px;height:25px;" checked>男
		   			</div>
		   			<div style="width:60px;padding:0px;height:25px;float:left">
			   			<input type="radio" name="sex" value="女" style="width:20px;height:25px;">女
		   			</div>
		   			<p class="errorLab"></p>
		   		</div>
		   		<div class="dataItem" id="addressItem">
		   			<div class="label">收货地址：</div>
		   			<input type="text" name="address"><br>
		   			<p class="errorLab"></p>
		   		</div>
		   		<div class="dataItem" id="telephoneItem">
		   			<div class="label">联系方式：</div>
		   			<input type="text" name="telephone"><br>
		   			<p class="errorLab"></p>
		   		</div>
	   			<input type="button" value="注册" id="regBtn" onclick="submitForm()">
   			</form>
   		</div>
   	</div>
  </body>
</html>
