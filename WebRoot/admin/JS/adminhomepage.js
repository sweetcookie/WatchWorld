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