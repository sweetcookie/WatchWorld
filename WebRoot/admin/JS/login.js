
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function clearMeg()
{
	$("#Meg").html("");
}
function loginCheck()
{
/*	var LoginName=document.loginform.name.value;
	var LoginPWD=document.loginform.pwd.value;*/
	var LoginName=$("#LoginName").val();
	var LoginPWD=$("#LoginPWD").val();
    if(LoginName==""){
    	$("#Meg").html("请输入用户名");
    }
    else if(LoginPWD==""){
    	$("#Meg").html("请输入密码");
    }
    else
    {
		$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/LoginCheckServlet",//发送请求地址 
        data:{"LoginName":LoginName,"LoginPWD":LoginPWD} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:true, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
           var flag = data.flag;
           if(flag == "LoginNameNoFound"){
        	   $("#Meg").html("用户名不存在");
           }else if(flag=="LoginPWDWrong"){
        	   $("#Meg").html("密码错误");
           }else if(flag=="Correct1"){  
        	       window.location.href=server_context+"/StoreInfoShowServlet";
        	   }
           else if(flag=="Correct2"){
        	       window.location.href=server_context+"/StoreInfoShowServlet";
               }
       },  
       //请求出错的处理  
       error:function(){  
                 alert(server_context+"/LoginCheckServlet"); 
                 
       }  
    });
    }
}