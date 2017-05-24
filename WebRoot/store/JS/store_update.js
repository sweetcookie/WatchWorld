var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;
function updateStore(){
	var pwd = $("#f_pwd").val(); 
	var n_pwd=$("#n_pwd").val();
	var storeName=$("#storeName").val();
	var telephone=$("#telephone").val();
	
	if(pwd==""){
		$("#msg").html("原密码为空");
		$("#f_pwd").focus();
		return;
	}if(n_pwd==""){
		$("#msg").html("新密码为空");
		$("#n_pwd").focus();
		return;
	}
	if(storeName==""){
		$("#msg").html("店铺名为空");
		$("#storeName").focus();
		return;
	}
	if(!(/^1[3,4,5,7,8]\d{9}$/g.test(telephone))){
		$("#msg").html("手机号码格式不正确");
		return;
	}
	if(checkPwd(pwd)==0){
		$("#msg").html("原密码不正确");
		return;
	}
	if( checkStoreName(storeName)==0){
		$("#msg").html("店铺名已存在");
		return;
	}
	if( checkTelephone(telephone)==0){
		$("#msg").html("手机号已被使用");
		return;
	}
	$("#form_updateStore").submit();
	
}
function checkPwd(pwd){
	var loginName = $("#loginName").val();
	 var retn=0;
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/store/LoginStoreServlet",//发送请求地址 
        data:
        {"LoginName":loginName,"Pwd":pwd} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:false, //
        success:function(data){  //请求成功后的回调函数 data为json格式 
           var flag = data.flag;
            if(flag=="PasswordCorrect"){
        	  retn=1;
           }
       },  
       //请求出错的处理  
       error:function(){  
                 alert("服务器错误");  
       }  
    });
	return retn;
}
function checkStoreName(storeName){
	var retn=0;
	var f_storeName=$("#f_storeName").val();
	if(storeName==f_storeName){
		return 1;
	}else{
		 $.ajax({  
             type:"post",//请求方式  
             url:server_context+"/store/CheckStoreNameServlet",//发送请求地址 
             data:{"StoreName":storeName} ,
             timeout:30000,//超时时间：30秒  
             dataType:"json",//设置返回数据的格式  
             async:false, 
             success:function(data){  //请求成功后的回调函数 data为json格式 
                var flag = data.flag;
                if(flag == "false"){
                	 retn = 1;
                }
            },  
            //请求出错的处理  
            error:function(){  
                      alert("服务器错误");  
            }  
         }); 
	}
	return retn;
}

function checkTelephone(telephone){
	var retn=0;
	var f_telephone=$("#f_telephone").val();
	if(telephone==f_telephone){
		return 1;
	}else{
	 $.ajax({  
         type:"post",//请求方式  
         url:server_context+"/store/CheckTelephoneServlet",//发送请求地址 
         data:{"Telephone":telephone} ,
         timeout:30000,//超时时间：30秒  
         dataType:"json",//设置返回数据的格式  
         async:false, 
         success:function(data){  //请求成功后的回调函数 data为json格式 
            var flag = data.flag;
            if(flag == "true"){
               $("#TelephoneCheck").html("已被使用");
            }else{
            	 $("#TelephoneCheck").html("");
            	 retn = 1;
            }
        },  
        //请求出错的处理  
        error:function(){  
                  alert("服务器错误");  
        }  
     });
	}
	return retn;
}