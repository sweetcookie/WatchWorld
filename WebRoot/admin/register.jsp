<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>root管理员创建账户界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="admin/JS/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="admin/JS/register.js"></script>
    <link rel="stylesheet" href="admin/CSS/registercss.css" type="text/css">
  </head>
  
  <body>
  	<div id="adminID">
   <%
            String AdminID = (String) session.getAttribute("AdminID");
			String AdminSession = (String) session.getAttribute("AdminSession");
            if(AdminID!=null){%>
			<a  class="a" >管理员：<%=AdminID %></a><a class="a1">&nbsp;| </a>
			
			<%
			}
   %>
   <a  class="a2" href="StoreInfoShowServlet">返回主页</a>
   </div>
  	<div id="header">
        <a href="#" id="logo"></a>
	</div>

    <div id="regform">
        <form method="post" name="regform">
        <div class="item">
             <label class="formlabel">账 号</label>
             <input type="text"  class="content" id="RegName" onkeyup="IDCheck(this)">
             <span class="tips" id="Meg1"></span>
        </div>
        <div class="item">
             <label class="formlabel">密 码</label>
             <input type="password"  class="content" id="RegPWD1" onkeyup="PWD1Check(this)">
              <span class="tips" id="Meg2"></span>
        </div>
        <div class="item" id="long">
             <label class="formlabel">确 认 密 码</label>
             <input type="password"  class="content" id="RegPWD2" onkeyup="PWD2Check(RegPWD1,this)">
              <span class="tips" id="Meg3"></span>
        </div>

        <div class="btn">
             <input type="button" value="确认" id="btn-reg" onclick="regCheck()" >
        </div>
        </form>
    </div>
  </body>
</html>
