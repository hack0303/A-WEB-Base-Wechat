$(document).ready(function(){
	$('#grid #change').hide();
	var length=$('#grid #image ul li').length;
	var start=0;
	var end=length-1;
	var now=start;
	//$('#grid #image ul li').eq(0).css({background:"red"}).end().eq(1).css({background:"#cc9966"}).end().eq(2).css({background:"#cc8866"}).end().eq(3).css({background:"#cc7766"}).end().eq(4).css({background:"#cc6666"});
	$('#grid #left').click(function(){
	switch(now){
	case 0:{
		alert("已经是第一张 了!");
		break;
	}
	default:{
		$('#grid #image ul li').eq(now).hide();
		now--;
		$('#grid #image ul li').eq(now).show();
	}
	}	
	});
$('#grid #right').click(function(){
	switch(now){
	case end:{
		alert("已经是最后一张 了!");
		break;
	}
	default:{
		$('#grid #image ul li').eq(now).hide();
		now++;
		$('#grid #image ul li').eq(now).show();
	}
	}	
	});
$('p font').click(function(){
	$('#grid #change').show();
	var name=$(this).parent().attr("class");
	$('#grid #change').find('input[name="name"]').val(name);
});
$('#grid #change input[type="button"]').eq(0).click(function(){
	var action=$('#grid #change input[name="action"]').val();
var name=$('#grid #change input[name="name"]').val();
var value=$('#grid #change input[name="value"]').val();
var phone=$('#grid #change input[name="phone"]').val();
//alert(name+value);
$.post("SecurityServlet",{"action":action,"name":name,"value":value,"phone":phone},function(data){
	//alert(data);
	if(data){
		$('#grid #change').hide();
		$('p.'+name+" I").replaceWith("<I>"+value+"</I>");
		alert("修改成功");
	}else{
		$('#grid #change').hide();
		alert("修改失败");
	}
	$('#grid #change input[name="name"]').val(null);
	$('#grid #change input[name="value"]').val(null);
});
});
$('#grid #change input[type="button"]').eq(1).click(function(){
	$('#grid #change input[name="name"]').val(null);
	$('#grid #change input[name="value"]').val(null);
	$('#grid #change').hide();	
});
});

function pass(phone){
	var url="AdminServlet?action=updateReview&phone="+phone+"&func=register&type=xunta&target=pass";
	$.get(url,function(data){
		alert(data);
		location.reload(true);
	});
}
function nopass(phone){
	var url="AdminServlet?action=updateReview&phone="+phone+"&func=register&type=xunta&target=nopass";
	$.get(url,function(data){
		alert(data);
		location.reload(true);
	});
}