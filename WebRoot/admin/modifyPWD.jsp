<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员修改密码界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="admin/JS/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="admin/JS/modifyPWD.js"></script>
    <link rel="stylesheet" href="admin/CSS/modifyPWDcss.css" type="text/css">
  </head>
  
  <body>
      	<div id="adminID">
   <%
            String AdminID = (String) session.getAttribute("AdminID");
			String AdminSession = (String) session.getAttribute("AdminSession");
            if(AdminID!=null){%>
			<a  class="a" >管理员：<%=AdminID %></a><a class="a1">&nbsp;| </a>
			<a  class="a2" href="StoreInfoShowServlet">返回主页</a>
			<%
			}
   %>
   </div>
    <div id="header">
        <a href="#" id="logo"></a>
	</div>
    
    <div id="modify">
        <form method="post" id="modifyform" >
        <div class="item">
             <input type="hidden" class="content" id="AdminID" value="<%=AdminID%>">
        </div>
        <div class="item">
             <label class="formlabel">原 密 码</label>
             <input type="password" class="content" id="PWD1">
        </div>
        <div class="item">
             <label class="formlabel">新 密 码</label>
             <input type="password"  id="PWD2" class="content" onkeyup="PWD2Check()" onfocus="clearMeg()">
              <span id="Meg2"></span>
        </div>
        <div id="tips">
              <span id="Meg"></span>
        </div>
        <div class="btn">
             <input type="button" value="确认" id="btn-modify" onclick="modifyCheck()" >
        </div>

        </form>
    </div>
  </body>
</html>
