function pass(gender,phone,state){
	var url="AdminServlet?action=updateReview&phone="+phone+"&func=wyzq&type=xunta&target=pass&gender="+gender+"&state="+state;
	$.get(url,function(data){
		alert(data);
		location.reload(true);
	});
}
function nopass(phone){
	var url="AdminServlet?action=updateReview&phone="+phone+"&func=wyzq&type=xunta&target=nopass";
	$.get(url,function(data){
		alert(data);
		location.reload(true);
	});
}
$(document).ready(function(){
	$('#nav #bottom ul li:nth-of-type(2)').hover(function(){
		$(this).children().eq(1).show();
	},function(){
		$(this).children().eq(1).hide();
	});
	$('#nav #bottom ul li:nth-of-type(2) #change p#submit').click(function(){
		var gender=$(this).prev().val();
		//alert(gender);
		var phone=$(this).prev().prev().val();
		var state=$(this).prev().prev().prev().children().eq(0).val();
		pass(gender,phone,state);
	});
});