var i=0;
var fun;
function lunbo(){
	//if(i>2) i=0;
    if(i==0||i==3){
    		if(i==3){
    	    	i=0;
    	    	$('#scroller ul li').eq(i).css("z-index","3");
        	    $('#scroller ul li').eq(i+1).css("z-index","2");	
    	    	$('#scroller ul li').eq(i+2).css("z-index","1").removeClass('lunbo');
    	    	}
    	    	else{
    	    	}
    	//这一步是关键,会影响效果
    }else if(i==1){
    		$('#scroller ul li').eq(i).css("z-index","3");
        	$('#scroller ul li').eq(i+1).css("z-index","2");
    	$('#scroller ul li').eq(0).css("z-index","1");
    	$('#scroller ul li').eq(0).removeClass('lunbo');
    }else if(i==2){
    	$('#scroller ul li').eq(0).css("z-index","2");
        $('#scroller ul li').eq(i).css("z-index","3");
    	$('#scroller ul li').eq(1).css("z-index","1");
    	$('#scroller ul li').eq(1).removeClass('lunbo');
    } 
    $('#scroller ul li').eq(i).addClass('lunbo');
	i++;
}
$(document).ready(function(){
	fun=setInterval(lunbo,3000);	
});
