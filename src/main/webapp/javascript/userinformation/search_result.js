$(document).ready(function(){
$('table tr:nth-of-type(1) td').hover(
function(e){
	$(this).find('.nav_show').fadeIn();
},function(e){
	$(this).find('.nav_show').fadeOut();
});
});