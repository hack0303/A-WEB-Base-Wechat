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