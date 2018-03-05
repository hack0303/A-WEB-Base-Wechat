count=5;
func=setInterval(function(){
	if(count<0) count=1;
	$('#footer #count p').replaceWith("<p>"+--count+"</p>");
},1000);