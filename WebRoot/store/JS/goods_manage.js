var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var server_context = localObj.protocol + "//" + localObj.host + "/" + contextPath;

function checkform(form){
	var GoodsName=$("#GoodsName").val();
	var GoodsPicturePath=$("#GoodsPicturePath").val();
	var Price=$("#Price").val();
	var Brand=$("#Brand").val();
	var Color=$("#Color").val();
	var Model=$("#Model").val();
	var Number=$("#Number").val();
	if(GoodsName==""){
		$("#msg").html("请输入商品名");
		$("#GoodsName").focus();
	}else if(GoodsPicturePath==""||!(/(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/g.test(GoodsPicturePath))){
		$("#msg").html("请上传图片");
		$("#GoodsPicturePath").focus();
	}else if(!(/^\+?[1-9][0-9]*$/g.test(Price))){
		$("#msg").html("价格须为正整数");
		$("#Price").focus();
	}else if(Brand==""){
		$("#msg").html("请输入品牌");
		$("#Brand").focus();
	}else if(Color==""){
		$("#msg").html("请选择颜色");
		$("#Color").focus();
	}else if(Model==""){
		$("#msg").html("请输入商品型号");
		$("#Model").focus();
	}else if(!(/^\+?[1-9][0-9]*$/g.test(Number))){
		$("#msg").html("库存须为正整数");
		$("#Number").focus();
	}else{
		$(form).submit();
	}
}
function findGoods(){
	var GoodsID=$("#GoodsID").val();
	if(/^\+?[1-9][0-9]*$/g.test(GoodsID)){
		$("#form_findgoods").submit();
		
	}else if(GoodsID.trim()==""){
		$("#Mesg").html("请输入编号");
	}else{
		$("#Mesg").html("格式有误");
	}
}

function updateGoods(form){
	var GoodsName=$("#GoodsName").val();
	var GoodsPicturePath=$("#GoodsPicturePath").val();
	var Price=$("#Price").val();
	var Brand=$("#Brand").val();
	var Color=$("#Color").val();
	var Model=$("#Model").val();
	var Number=$("#Number").val();
	if(GoodsName==""){
		$("#Mesg").html("请输入商品名");
		$("#GoodsName").focus();
	}else if(!(/^\+?[1-9][0-9]*$/g.test(Price))){
		$("#Mesg").html("价格须为正整数");
		$("#Price").focus();
	}else if(Brand==""){
		$("#Mesg").html("请输入品牌");
		$("#Brand").focus();
	}else if(Color==""){
		$("#Mesg").html("请选择颜色");
		$("#Color").focus();
	}else if(Model==""){
		$("#Mesg").html("请输入商品型号");
		$("#Model").focus();
	}else if(!(/^\+?[1-9][0-9]*$/g.test(Number))){
		$("#Mesg").html("库存须为正整数");
		$("#Number").focus();
	}else{
		$(form).submit();
	}
}
