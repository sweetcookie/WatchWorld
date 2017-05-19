<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css" href="store/CSS/register.css">
<script type="text/javascript" src="store/JS/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="store/JS/register.js"></script>
</head>

<body>
	<div id="header">
		<div id="logo-con">
			<a href="#" id="logo"></a>
			<div id="logo-title">欢迎注册店铺</div>
			<div id="have-account">
				已有账号？ <a href="<%=basePath%>/store/login.jsp">请登录</a>
			</div>
		</div>
	</div>

	<div class="reg-div">
		<form id="form_register">
			<div class="form-item">
				<label>用 &nbsp; &nbsp;户 &nbsp; &nbsp;名</label> <input type="text"
					name="LoginName" id="LoginName" onchange="checkLoginName(this) "
					maxlength="15">
			</div>
			<div class="input-tip">
				<span id="LogCheckMeg"></span>
			</div>

			<div class="form-item">
				<label>设 &nbsp;置 &nbsp;密 &nbsp;码</label> <input type="password"
					name="Pwd" id="Pwd" onchange="checkPwd1(this)" maxlength="15">
			</div>
			<div class="input-tip">
				<span id="Pwd1Check"></span>
			</div>
			<div class="form-item">
				<label>确 &nbsp;认 &nbsp;密 &nbsp;码</label> <input type="password"
					name="Pwd2" id="Pwd2" onchange="checkPwd2(this)" maxlength="15">
			</div>
			<div class="input-tip">
				<span id="Pwd2Check"></span>
			</div>

			<div class="form-item">
				<label>店 &nbsp;铺 &nbsp;名 &nbsp;称</label> <input type="text"
					name="StoreName" id="StoreName" onchange="checkStoreName(this)"
					maxlength="15">
			</div>
			<div class="input-tip">
				<span id="StoreCheck"></span>
			</div>
			<div class="form-item">
				<label>店 &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;主</label> <input
					type="text" name="Owner" id="Owner" onchange="checkOwner(this)"
					maxlength="15">
			</div>
			<div class="input-tip">
				<span id="OwnerCheck"></span>
			</div>
			<div class="form-item">
				<label>手 &nbsp;机 &nbsp;号 &nbsp;码</label> <input type="text"
					name="Telephone" id="Telephone" onchange="checkTelephone(this)"
					maxlength="11">
			</div>
			<div class="input-tip">
				<span id="TelephoneCheck"></span>
			</div>
			<div>
				<input type="button" value="立即注册" id="btn-register"
					onclick="registerStore() ">
			</div>
		</form>
	</div>
</body>
</html>
