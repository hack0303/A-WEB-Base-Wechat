$(document).ready(function(){
$("input[name='userid']").blur(
		function(){
	$.get("MyServlet",{action:"checkajax",type:"userid",userid:$("input[name='userid']").val()},function(data){
		if(data!=null) //$('#userid').append(data);
		//$('#userid').replaceWith(data);
		$('#userid').replaceWith("<div id='userid'>"+data+"</div>");
		else alert('系统出错!');
	});
		}
	);
$("input[name='telephone']").blur(function(){
	$.get("MyServlet",{action:"checkajax",type:"telephone",telephone:$("input[name='telephone']").val()},function(data){
		if(data!=null) //$('#telephone').append(data);
		//	$('#telephone').replaceWith(data);
		$('#telephone').replaceWith("<div id='telephone'>"+data+"</div>");
		else alert('系统出错!');
	});
	}
	);}
);