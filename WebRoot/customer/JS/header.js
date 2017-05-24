var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
function logout()
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/logout",
		success: function(data)
		{
			location.reload();
		}
	});
}