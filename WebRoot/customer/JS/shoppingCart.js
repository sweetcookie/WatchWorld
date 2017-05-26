var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	loadData();
});

function loadData()
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/shoppingCart/getData",
		dataType: "json",
		success: function(json)
		{
			$.each(json, function(i,n)
			{
				$("#contentTable").append("<tr class='contentTr'>" +
						"<td class='goodsNameTd'>" +
							"<img src='"+hostpath+n.goodsPicturePath+"'>" +
							"<div class='goodsName'>" +
								"<a href='"+hostpath+"customer/goods.jsp?goodsID="+n.goodsID+"'>" +
										"<p>"+n.goodsName+"</p>" +
								"</a>" +
							"</div>" +
						"</td>" +
						"<td class='price'>￥"+n.price+"</td>" +
						"<td class='amount'><input type='number' min='1' id='amountVal' value='"+n.amount+"'></td>" +
						"<td class='money'>￥"+(n.price*n.amount)+"</td>" +
						"<td class='operate'><p onclick='delData("+n.goodsID+")'>删除</p></td>" +
						"<td class='selection'><input type='checkbox' value='"+n.amount+"'></td>" +
					"</tr>");
			});
		}
	});
}