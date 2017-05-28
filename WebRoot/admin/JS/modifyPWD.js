var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function modifyCheck(){
	var pwd1=$("#PWD1").val();
	var pwd2=$("#PWD2").val();
	var ID=$("#AdminID").val();
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/ModifyCheckServlet",//发送请求地址 
        data:{"pwd1":pwd1 , "pwd2":pwd2 , "ID":ID} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式 
        async:true, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
        	var flag=data.flag;
        	if(flag=="WrongPWD"){
        		$("#Meg").html("密码错误");
        	}
        	else if(flag=="Success"){ 
        		alert("修改成功");
        		window.location.href=server_context+"/StoreInfoShowServlet";

        	}
       },  
       //请求出错的处理  
       error:function(){  
                 alert("请求失败"); 
                 
       }  
    });
}
function PWD2Check(){
	var pwd2=$("#PWD2").val();
	if(pwd2.length>15){
		$("#Meg").html("新密码长度不能超过15");
	}
}