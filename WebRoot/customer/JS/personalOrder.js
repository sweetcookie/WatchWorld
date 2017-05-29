var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	loadData();
});

function loadData()
{
	var select = $("#selection").val();
	$.ajax({
		type: "post",
		url: hostpath+"customer/personalOrder/getOrder",
		dataType: "json",
		data: "select="+select,
		success: function(json)
		{
			$(".orderItem").remove();
			$.each(json, function(i, n)
			{
				$("#contentContainer").append("<div class='orderItem' id='"+n.orderID+"'>" +
							"<div class='orderPart'>" +
								"<div class='halfContainer'>" +
									"<p>订单编号："+n.orderID+"</p>" +
									"<p>订单状态："+n.orderStatus+"</p>" +
									"<p>成交时间："+n.paymentTime+"</p>" +
									"<p>发货时间："+n.sendGoodsTime+"</p>" +
									"<p>卖方："+n.storeName+"</p>" +
								"</div>" +
								"<div class='halfContainer'>" +
									"<p>买方："+n .userName+"</p>" +
									"<p>总价：￥"+n.totalPrice+"</p>" +
									"<p>收货地址："+n.address+"</p>" +
									"<p>联系方式："+n.telephone+"</p>" +
								"</div>" +
								"<div class='btnContainer'>" +
									"<input type='button' value='撤销' onclick='cancel(\""+n.orderID+"\")' id='cancel"+n.orderID+"'>" +
									"<input type='button' value='签收' onclick='signfor(\""+n.orderID+"\")' id='signFor"+n.orderID+"'>" +
								"</div>" +
							"</div>" +
						"</div>");
				getGoodsInfo(n.orderID);
				if(n.orderStatus == "未发货")
				{
					$("#signFor"+n.orderID).attr("disabled", "true");
				}
				if(n.orderStatus == "已发货")
				{
					$("#cancel"+n.orderID).attr("disabled", "true");
				}
				if(n.orderStatus == "已签收")
				{
					$("#cancel"+n.orderID).attr("disabled", "true");
					$("#signFor"+n.orderID).attr("disabled", "true");
				}
			});
		}
	});
}

//获取指定订单编号的商品
function getGoodsInfo(orderID)
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/personalOrder/getGoods",
		dataType: "json",
		data: "orderID="+orderID,
		success: function(json)
		{
			$.each(json, function(i, n)
			{
				$("#"+orderID).append("<div class='goodsPart'>" +
							"<div class='goodsName'>" +
								"<img src='"+hostpath+n.goodsPicture+"' />" +
								"<p>"+n.goodsName+"</p>" +
							"</div>" +
							"<div class='goodsAttr'>" +
								"<p>品牌："+n.brand+"</p>" +
								"<p>颜色："+n.color+"</p>" +
								"<p>型号："+n.model+"</p>" +
							"</div>" +
							"<div class='amount'>" +
								"<p>数量："+n.buyAmount+"</p>" +
							"</div>" +
							"<div class='price'>" +
								"<p>单价：￥"+n.price+"</p>" +
							"</div>" +
						"</div>");
			});
		}
	});
}

//撤销订单
function cancel(orderID)
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/personalOrder/delOrder",
		data: "orderID="+orderID,
		success: function(data)
		{
			location.reload(true);
		}
	});
}

//签收订单
function signfor(orderID)
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/personalOrder/signForOrder",
		data: "orderID="+orderID,
		success: function(data)
		{
			location.reload(true);
		}
	});
}