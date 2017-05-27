var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	loadData();
});

var jsonData;

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
				$("#contentTable").append("<tr class='contentTr' name='goodsItem' id='"+n.goodsID+"'>" +
						"<td class='goodsNameTd'>" +
							"<img src='"+hostpath+n.goodsPicturePath+"'>" +
							"<div class='goodsName'>" +
								"<a href='"+hostpath+"customer/goods.jsp?goodsID="+n.goodsID+"'>" +
										"<p>"+n.goodsName+"</p>" +
								"</a>" +
							"</div>" +
						"</td>" +
						"<td class='price' name='priceTd'>"+n.price+"</td>" +
						"<td class='amount' name='amountTd'><input type='number' min='1' class='amountVal' value='"+n.amount+"' onchange='calc()'></td>" +
						"<td class='money' name='moneyTd' >"+(n.price*n.amount)+"</td>" +
						"<td class='operate'><p onclick='delData("+n.goodsID+")'>删除</p></td>" +
						"<td class='selection'><input type='checkbox' name='selectIt' onchange='calcTotal()' value='"+n.goodsID+"'></td>" +
					"</tr>");
			});
			jsonData = json; //保存json数据为全局变量
		}
	});
}

//提交数据以生成订单
function submitData()
{
	var dataArray = new Array();
	var list = document.getElementsByName("selectIt");
	for(var i=0; i<list.length; i++) //查找所有被选中的商品
	{
		if(list[i].checked)
		{
			var goodsID = list[i].getAttribute("value");
			var amount = $("#"+goodsID+" .amount input").val();
			var data = {"goodsID":goodsID,"amount":amount};
			dataArray.push(data);
		}
	}
	if(dataArray.length > 0)
	{
		var para = "[";
		for(var j=0; j<dataArray.length; j++)
		{
			para=para+JSON.stringify(dataArray[j]);
			if(j!=(dataArray.length-1))
			{
				para=para+",";
			}
		}
		para=para+"]";
		location.href=hostpath+"customer/order/createOrder?para="+para;
	}
}

function calc()
{
	var list = document.getElementsByName("goodsItem");
	for(var i=0; i<list.length; i++)
	{

		nodeList=list[i].childNodes;
		var price=nodeList[1].innerHTML;
		var amount=$((nodeList[2].childNodes)[0]).val();
		var money=price*amount;
		nodeList[3].innerHTML=money;
	}
	calcTotal();
}

//计算商品总数以及总价
function calcTotal()
{
	var itemList=document.getElementsByName("selectIt");
	var num=0; //选取的商品数
	var totalMoney=0; //总价
	for(var i=0; i<itemList.length; i++) //查找所有被选中的商品
	{
		if(itemList[i].checked)
		{
			num++;
			id=itemList[i].getAttribute("value");
			var money=$("#"+id+" .money").text();
			totalMoney=parseInt(totalMoney)+parseInt(money);
		}
	}
	$("#total").text("￥"+totalMoney);
	$("#selectedAccount").text(num);
}

//删除指定商品信息
function delData(goodsID)
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/shoppingCart/delData?goodsID="+goodsID,
		success: function(data)
		{
			$(".contentTr").remove();
			loadData();
		}
	});
}