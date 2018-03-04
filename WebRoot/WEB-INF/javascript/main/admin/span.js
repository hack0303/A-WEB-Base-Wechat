function first(pagenow,type,func,state){
	alert('eee');
	if(pagenow==1){
		alert('已经是第一页');
		return;
	}
	location.href="AdminServlet?action=query&type="+type+"&func="+func+"&state="+state+"&pagespan=first";
}
function prev(pagenow,type,func,state){
	if(pagenow==1){
		alert('已经是第一页');
		return;
	}
	location.href="AdminServlet?action=query&type="+type+"&func="+func+"&state="+state+"&pagespan=prev";
}
function go(x,type,func,state){
	location.href="AdminServlet?action=query&type="+type+"&func="+func+"&state="+state+"&pagespan=go&pagenumber="+x;
	
}
function next(pagenow,pagetotal,type,func,state){
	if(pagenow==pagetotal){
		alert('已经是最后一页');
		return;
	}
	location.href="AdminServlet?action=query&type="+type+"&func="+func+"&state="+state+"&pagespan=next";
	
}
function last(pagenow,pagetotal,type,func,state){
	if(pagenow==pagetotal){
		alert('已经是最后一页');
		return;
	}
	location.href="AdminServlet?action=query&type="+type+"&func="+func+"&state="+state+"&pagespan=last";
	
}
$(document).ready(function(){
	$('#span select').change(function(){
		$('#span form').submit();
	});
});