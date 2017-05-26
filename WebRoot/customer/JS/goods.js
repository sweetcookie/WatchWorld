var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	getData();
});

function getData()
{
	var para=location.search;
	$.ajax({
		type: "post",
		url: hostpath+"customer/goods/getData"+para,
		dataType: "json",
		success: function(data)
		{
			document.title=data.goodsName+" - 商品详情";
			$("#picContainer img").attr("src",hostpath+data.goodsPicturePath);
			$("#goodsName p").text(data.goodsName);
			$("#price p").text("￥"+data.price);
			$("#brand p").text(data.brand);
			$("#color p").text(data.color);
			$("#Model p").text(data.model);
			$("#Number p").text(data.number);
			$("#SalesVolumes p").text(data.salesVolumes);
			$("#storeName a").attr("href",(hostpath+"store/store.jsp?storeID="+data.storeID));
			$("#storeName a").text(data.storeName);
		}
	});
}

//添加到购物车
function insertIntoShoppingCart()
{
	var para=location.search;
	var amount=$("#amount").val();
	$.ajax({
		type: "post",
		url: hostpath+"customer/shoppingCart/insertIntoShoppingCart"+para+"&amount="+amount,
		success: function(data)
		{
			if(data == "refuse")
			{
				alert("您还未登录，无法加入购物车！");
				location.href=hostpath+"customer/login.jsp";
			}
			else
			{
				alert(data);
			}
		}
		});
}