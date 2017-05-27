var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function checkform(form){
	var StoreID=$("#StoreID").val();
	var ActivityPicturePath=$("#ActivityPicturePath").val();
	if(StoreID==""){
		$("#msg").html("请输入店铺ID");
	}
	else if(ActivityPicturePath==""||!(/(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/g.test(ActivityPicturePath))){
		$("#msg").html("请上传图片");
	}
	else if(ActivityName==""){
		$("#msg").html("请输入活动名称");
	}
	else if(ActivityName.length>16){
		$("#msg").html("活动名称长度不能超过15");
	}
	else{
		$(form).submit();
	}
}

function deleteActivity(ActivityName){
	
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/ActivityDeleteServlet",//发送请求地址 
        data:{"ActivityName":ActivityName} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:false, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
        	var flag = data.flag;
           if(flag == "true"){
        	   alert("修改成功！");
        	   window.location.href=server_context+"/ActivityAddServlet?operate=select";
               }
           else{
        	   alert("删除失败！");
           }
       },  
       //请求出错的处理  
       error:function(){  
                 alert("请求失败"); 
                 
       }  
    });
}
