var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function storeSearch(search)
{
	var Content=$(search).val();
	var Choose=$("#choose").val();
	
//	$("#as").html("哈哈");
	window.location.href=server_context+"/StoreInfoSearchServlet?searchContent="+Content+"&Choose="+Choose;
}
function deleteStore(StoreID){
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/DeleteStoreServlet",//发送请求地址 
        data:{"StoreID":StoreID} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:true, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
           var flag = data.flag;
           if(flag == "Success"){
        	       window.location.href=server_context+"/StoreInfoShowServlet";
               }
       },  
       //请求出错的处理  
       error:function(){  
                 alert("请求失败"); 
                 
       }  
    });
}