var startX=0;
	var startY=0;
	var endX=0;
	var endY=0;
	var length=0;
$(document).ready(function(){
	//$('#image ul li').eq(0).css({"background-color":"red"}).end().eq(1).css({"background-color":"blue"}).end().eq(2).css({"background-color":"green"});
	length=$('#image ul li').length;
	$('#image ul li').mousedown(function(e){
		startX=e.pageX;
		startY=e.pageY;
	});
	$('#image ul li').mouseup(function(e){
		endX=e.pageX;
		endY=e.pageY;
		var x=endX-startX;
		var index=$(this).index();
	  if(x>0){
		  if(index==(length-1)){
			  alert('已经是最后一张');
		  }else{
			  index++;
			  $(this).fadeOut();
		  }
	  }else if(x<0){
		  if(index==0){
			  alert('已经是第一张了!');
		  }else{
			  index--;
			  $(this).prev().fadeIn();
		  }
	  }
	});
	});