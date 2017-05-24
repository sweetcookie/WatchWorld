var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	$("#loginID").val("");
	$("#loginPwd").val("");
	blurID();
	blurPwd();
});

//账号输入框得到焦点
function focusID()
{
	if($("#loginID").val()=="账号")
	{
		$("#loginID").val("");
		$("#loginID").css("color","#000000");
	}
}

//账号输入框失去焦点
function blurID()
{
	if($("#loginID").val()=="")
	{
		$("#loginID").val("账号");
		$("#loginID").css("color","#999999");
	}
}

//密码输入框得到焦点
function focusPwd()
{
	if($("#loginPwd").attr("type")=="text")
	{
		$("#loginPwd").val("");
		$("#loginPwd").css("color","#000000");
		$("#loginPwd").attr("type","password");
	}
}

//密码输入框失去焦点
function blurPwd()
{
	if($("#loginPwd").val()=="")
	{
		$("#loginPwd").val("密码");
		$("#loginPwd").css("color","#999999");
		$("#loginPwd").attr("type","text");
	}
}

//提交登陆表单
function submitForm()
{
	if($("#loginID").val()=="账号")
	{
		$("#loginID").val("");
	}
	if($("#loginPwd").val()=="密码")
	{
		$("#loginPwd").val("");
	}
	
	$.ajax({
		type: "post",
		url: hostpath+"customer/login/checkLogin",
		data: $("#loginForm").serialize(),
		async: false,
		success: function(data)
		{
			if(data == "")
			{
				location.href = hostpath+"customer/homepage.jsp";
			}
			else
			{
				$("#loginErr").text(data);
			}
		},
	});
}