var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function deleteGoods(GoodsID){
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/GoodsDeleteServlet",//发送请求地址 
        data:{"GoodsID":GoodsID} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:false, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
        	var flag = data.flag;
           if(flag == "true"){
        	   alert("修改成功！");
        	   window.location.href=server_context+"/GoodsShowServlet";
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

function addGoods(){
	var GoodsID=$("#GoodsID").val();
	$.ajax({  
        type:"POST",//请求方式  
        url:server_context+"/GoodsAddServlet",//发送请求地址 
        data:{"GoodsID":GoodsID} ,
        timeout:30000,//超时时间：30秒  
        dataType:"json",//设置返回数据的格式  
        async:false, 
        success:function(data){  //请求成功后的回调函数 data为json格式 
        	var flag = data.flag;
           if(flag == "true"){
        	   alert("添加成功！");
        	   window.location.href=server_context+"/GoodsShowServlet";
               }
           else if(flag=="NotGoodsID"){
        	   alert("没有此商品！");
           }
           else alert("添加失败！");
       },  
       //请求出错的处理  
       error:function(){  
                 alert("请求失败"); 
                 
       }  
    });
}