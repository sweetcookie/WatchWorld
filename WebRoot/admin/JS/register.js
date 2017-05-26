
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function IDCheck(RegName)
{
	var RegName=$(RegName).val();
	var f=0;
	if(RegName==""){
		$("#Meg1").html("账号不能为空");
		f=0;
	}
	else{
		$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/AdminIDCheckServlet",//发送请求地址 
        data:{"RegName":RegName} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式 
        async:false, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
        	var flag=data.flag;
        	if(flag=="true"){
        		$("#Meg1").html("已注册");
        		f=0;
        	}
        	else if(flag=="false"){ 
        		$("#Meg1").html("");
        		f=1;
        	}
       },  
       //请求出错的处理  
       error:function(){  
                 alert("请求失败！"); 
                 
       }  
    });
	}
	return f;
}

function PWD1Check(PWD1)
{
	var PWD1=$(PWD1).val();
	var f=0;
	if(PWD1==""){
		$("#Meg2").html("密码不能为空");
		f=0;
	}
	else if(PWD1.length>15){
		$("#Meg2").html("密码长度不能超过15个");
		f=0;
	}
	else{
		$("#Meg2").html("");
		f=1;
		}
	return f;
}

function PWD2Check(PWD1,PWD2)
{
	var PWD2=$(PWD2).val();
	var PWD1=$("#RegPWD1").val();
	if(PWD2==""){
		$("#Meg3").html("密码不能为空");
		return false;
	}
	else if(PWD1!=PWD2){
		$("#Meg3").html("密码不一致");
		return false;
	}
	else{
		$("#Meg3").html("密码正确");
		return true;
	}
}
/*)
&&PWD1Check($("#RegPWD1"))
&&PWD2Check($("#RegPWD1"),$("RegPWD2")))*/
function regCheck()
{
	var RegName=$("#RegName").val();
	var RegPWD=$("#RegPWD1").val();
	var RegPWD2=$("#RegPWD2").val();
	if(IDCheck($("#RegName"))
	   &&PWD1Check($("#RegPWD1"))
	   &&PWD2Check($("#RegPWD1"),$("#RegPWD2")))
	{

		$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/AdminRegServlet",//发送请求地址 
        data:{"RegName":RegName,"RegPWD":RegPWD} ,
        timeout:30000,//超时时间：30秒  
        async:true, 
        success:function(){ 
        	window.location.href=server_context+"/StoreInfoShowServlet";
       },  
       //请求出错的处理  
       error:function(){  
                 alert("注册失败！"); 
                 
       }  
    });
	}
}