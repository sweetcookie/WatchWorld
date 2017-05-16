$(document).ready(function(){
	loadActivityImg();
	picCarousel();
});

var amount=3; //轮播图片数量
var idx=1; //当前显示的活动图片索引
var interval; //定时器

function loadActivityImg()
{
	$.ajax({
		type: "post",
		url: "index/activity",
		dataType: "json",
		success: function(json)
		{
			$.each(json, function(i, n)
			{
				$("#activityContainer").append(
						"<a href='store?storeId="+json[i].storeId+"'>" +
								"<img src='"+json[i].activityPicturePath+"' " +
										"id='activity"+(i+1)+"' " +
										"onmouseover='stopCarousel()' " +
										"onmouseout='picCarousel()'>" +
						"</a>");
				$("#picIndexContainer").append(
						"<i class='picIndex' " +
						"index='"+(i+1)+"'" +
						"onmouseover='selectActivity("+(i+1)+")'" +
						"onmouseout='picCarousel()'>");
				$("#activity"+(i+1)).hide();
			});
			$("#activity"+idx).show();
			$("[index="+idx+"]").css("background-color", "#FF0000");
		},
	});
}

function picSwitch()
{
	$("#activity"+idx).fadeOut(500);
	$("[index="+idx+"]").css("background-color", "#646464");
	idx++;
	if(idx>amount)
	{
		idx=1;
	}
	$("#activity"+idx).fadeIn(500);
	$("[index="+idx+"]").css("background-color", "#FF0000");
}

function picCarousel()
{
	interval=window.setInterval("picSwitch()", 3000);
}

function stopCarousel()
{
	window.clearInterval(interval);
}

function selectActivity(i)
{
	stopCarousel();
	if(i!=idx)
	{
		$(".picIndex").css("background-color", "#646464");
		$("[index="+i+"]").css("background-color", "#FF0000");
		$("#activity"+idx).fadeOut(500);
		$("#activity"+i).fadeIn(500);
		idx=i;
	}
}