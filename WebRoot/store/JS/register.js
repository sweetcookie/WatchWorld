
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;






function checkNull(Pwd){
	var pwd=$(Pwd).val();
	
	if(pwd==""){
		return 0;
	}else{
		return 1;
	}
}
function registerStore(){
	var form=$('#form_register').serialize();
	if(checkLoginName($("#LoginName"))
			&&checkPwd1($("#Pwd"))
			&&checkPwd2($("#Pwd2"))
			&&checkStoreName($("#StoreName"))
			&&checkTelephone($("#Telephone"))
			&&checkOwner($("#Owner"))){
		$.ajax({  
        type: "POST",  
        url:server_context+"/servlet/AddStoreServlet",//发送请求地址 
        data:$('#form_register').serialize(),// 序列化表单值  
        error: function(request) {  
            alert("服务器出错");  
        },  
        success: function() {  
            window.location.href=server_context+"/store/storemanage.jsp";  
        }  
    }); 
	}
}



function checkPwd1(Pwd){
	var pwd=$(Pwd).val();
	var pwd2=$("#Pwd2").val();
//	alert(pwd.length);
	if(pwd==""){
		$("#Pwd1Check").html("不能为空");
	}else if(pwd.length>15){
		$("#Pwd1Check").html("密码长度不能超过15个字符");
	}else {
		$("#Pwd1Check").html("");
		if(pwd!=pwd2){
			$("#Pwd2Check").html("密码不一致");
		}else if(pwd==pwd2){
			$("#Pwd2Check").html("");
			$("#Pwd1Check").html("");
			return 1;
		}
	}
	return 0;
	
}

function checkPwd2(Pwd2){
	var pwd=$("#Pwd").val();
    var pwd2 = $(Pwd2).val();
    if(pwd!=""){
    	if(pwd.length>15){
    		$("#Pwd1Check").html("密码长度不能超过15个");
    	}else if(pwd2==""){
    		$("#Pwd2Check").html("不能为空");
    	}else if(pwd==pwd2){
    			$("#Pwd2Check").html("");
    			$("#Pwd1Check").html("");
    			return 1;
		}else{
    			$("#Pwd2Check").html("密码不一致");
		}
    }
    return 0;
}

function checkLoginName(LoginName){
    var loginName = $(LoginName).val();
    var retn=0;
    if(loginName==""){
    	$("#LogCheckMeg").html("不能为空");
	}else{
		 $.ajax({  
             type:"post",//请求方式  
             url:server_context+"/servlet/CheckLoginNameServlet",//发送请求地址 
             data:{"LoginName":loginName} ,
             timeout:30000,//超时时间：30秒  
             dataType:"json",//设置返回数据的格式  
             async:false, //
             success:function(data){  //请求成功后的回调函数 data为json格式 
                var flag = data.flag;
                if(flag == "true"){
                   $("#LogCheckMeg").html("已注册");
                }else{
                	 $("#LogCheckMeg").html("");
                	 retn=1;
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

function checkStoreName(StoreName){
	var storeName=$(StoreName).val();
	var retn=0;
	if(storeName==""){
    	$("#StoreCheck").html("不能为空");
	}else{
		 $.ajax({  
             type:"post",//请求方式  
             url:server_context+"/servlet/CheckStoreNameServlet",//发送请求地址 
             data:{"StoreName":storeName} ,
             timeout:30000,//超时时间：30秒  
             dataType:"json",//设置返回数据的格式  
             async:false, 
             success:function(data){  //请求成功后的回调函数 data为json格式 
                var flag = data.flag;
                if(flag == "true"){
                   $("#StoreCheck").html("已存在");
                }else{
                	 $("#StoreCheck").html("");
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
function checkTelephone(Telephone){
	var telephone=$(Telephone).val();
	var patrn=/^1[3,4,5,7,8]\d{9}$/g;//手机号码正则表达式
	var retn=0;
	if(telephone==""){
    	$("#TelephoneCheck").html("不能为空");
	}else if(patrn.test(telephone)){
		
		 $.ajax({  
             type:"post",//请求方式  
             url:server_context+"/servlet/CheckTelephoneServlet",//发送请求地址 
             data:{"Telephone":telephone} ,
             timeout:30000,//超时时间：30秒  
             dataType:"json",//设置返回数据的格式  
             async:false, 
             success:function(data){  //请求成功后的回调函数 data为json格式 
                var flag = data.flag;
                if(flag == "true"){
                   $("#TelephoneCheck").html("已存在");
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
	}else{
		$("#TelephoneCheck").html("格式有误");
	}
	return retn;
}

function checkOwner(Owner){
	var owner=$(Owner).val();
	var retn=0;
	if(owner==""){
    	$("#OwnerCheck").html("不能为空");
	}else{
		 $.ajax({  
             type:"post",//请求方式  
             url:server_context+"/servlet/CheckOwnerServlet",//发送请求地址 
             data:{"Owner":owner} ,
             timeout:30000,//超时时间：30秒  
             dataType:"json",//设置返回数据的格式  
             async:false, 
             success:function(data){  //请求成功后的回调函数 data为json格式 
                var flag = data.flag;
                if(flag == "true"){
                   $("#OwnerCheck").html("已存在");
                }else{
                	 $("#OwnerCheck").html("");
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