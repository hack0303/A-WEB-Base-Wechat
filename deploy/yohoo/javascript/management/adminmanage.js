var nav_h1_flag_1=false;
var nav_h1_flag_2=false;
var nav_h1_flag_3=false;
$(document).ready(function(){
	$('#left #nav h1').eq(0).click(
	function(){
		if(nav_h1_flag_1){
		$(this).next().hide();
		nav_h1_flag_1=false;}
		else{
		$(this).next().show();
		nav_h1_flag_1=true;
		}
		});
	$('#left #nav h1').eq(1).click(
			function(){
				if(nav_h1_flag_2){
				$(this).next().hide();
				nav_h1_flag_2=false;}
				else{
				$(this).next().show();
				nav_h1_flag_2=true;
				}
				});
	$('#left #nav h1').eq(2).click(
			function(){
				if(nav_h1_flag_3){
				$(this).next().hide();
				nav_h1_flag_3=false;}
				else{
				$(this).next().show();
				nav_h1_flag_3=true;
				}
				});
});