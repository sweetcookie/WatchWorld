var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
function checkUserID(e)
{
	if(e.value!="")
	{
		var flag=e.value.match(/[\w]{6,15}/);
		if(flag==null)
		{
			$("#userIDItem .errorLab").text("账号必须由6-15位字母、数字或下划线构成！");
		}
		else
		{
			$("#userIDItem .errorLab").text("");
		}
	}
}

function checkPassword(e)
{
	if(e.value!="")
	{
		var flag=e.value.match(/[\w]{6,}/);
		if(flag==null)
		{
			$("#passwordItem .errorLab").text("密码必须由6位以上的字母、数字或下划线构成！");
		}
		else
		{
			$("#passwordItem .errorLab").text("");
		}
	}
}

function checkConfirmPassword(e)
{
	if(e.value!="")
	{
		var flag=($("#passwordItem input").val()==e.value); 
		if(flag==false)
		{
			$("#confirmPasswordItem .errorLab").text("密码不一致！");
		}
		else
		{
			$("#confirmPasswordItem .errorLab").text("");
		}
	}
}

function checkAge(e)
{
	if(e.value!="")
	{
		var flag=e.value.search(/[^(0-9)]/);
		if(flag > -1)
		{
			$("#ageItem .errorLab").text("年龄必须是纯数字！");
			e.value=e.value.replace(/[^(0-9)]/g,"");
		}
		else
		{
			$("#ageItem .errorLab").text("");
		}
	}
}

function submitForm()
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/register/checkRegister",
		data: $("#regForm").serialize(),
		async: false,
		dataType: "json",
		success: function(data)
		{
			if(data.status=="true" && data.saved=="true") //表单数据合法且已经保存到数据库中
			{
				window.location.href=hostpath+"customer/register/success";
			}
			else if(data.status=="true" && data.saved=="false")
			{
				alert("服务器发生错误，注册信息保存失败！");
			}
			else
			{
				$("#userIDItem .errorLab").text(data.userID);
				$("#passwordItem .errorLab").text(data.password1);
				$("#confirmPasswordItem .errorLab").text(data.password2);
				$("#userNameItem .errorLab").text(data.userName);
				$("#ageItem .errorLab").text(data.age);
				$("#addressItem .errorLab").text(data.address);
				$("#telephoneItem .errorLab").text(data.telephone);
			}
		}
	});
}