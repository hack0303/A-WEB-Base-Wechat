var flag1=false;
var flag2=false;
var flag3=false;
var submit=true;
$(document).ready(function(){
	$('#checkcode_nav').click(function(){
$.get("AJAXServlet",{action:"getCheckcode"},function(data){
	$('#checkcode #checkcode_nav p').replaceWith("<p>"+data+"</p>");
});
	});
$('#footer #submit').click(function(){
	var value1=$('input[name="account"]').val();
	var value2=$('input[name="password"]').val();
	var value3=$('input[name="checkcode"]').val();
	if(value1!="") flag1=true;
	if(value2!="") flag2=true;
	if(value3!="") flag3=true;
	if(flag1&&flag2&&flag3&&submit){
		submit=false;//防止重复提交
	$('form').submit();}
});
});