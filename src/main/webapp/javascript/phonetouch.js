$(document).on("pagecreate",'#x4',function(){
	$('#x40').on("swiperight",function(){
		alert('right');
	});
});
$('#x4').swipeleft(function(){
		alert('left');
	});
$(document).ready(function(){
	$('#x1').tap(function(){
		alert('tap');
	});
	$('#x2').taphold(function(){
		alert('taphold');
	});
	$('#x3').swipe(function(){
		alert('swipe');
	});
	$('#x4').swipeleft(function(){
		alert('left');
	});
	$('#x5').swiperight(function(){
		alert('right');
	});
	//$(document).scrollstart(function(){
	//	alert('滚屏开始');
	//});
	//$(document).scrollstop(function(){
	//	alert('滚屏开始');
	//});
	//$(window).orientationchange(function(event){
	//	alert(event.orientation);
	//});
});
document.addEventListener("touchmove",function(e){
	e.preventDefault();
	//e.stopPropagation();
},false);