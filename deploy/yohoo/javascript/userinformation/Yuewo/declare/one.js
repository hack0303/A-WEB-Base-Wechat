$(document).ready(function(){
  $('#footer p').eq(1).click(function(){
	  $('form:first').submit();
  });
  $('.class1 input[id="agree_yes"]').click(function(){
	if($(this).prop("checked")==true){
$('.class1').find('p').eq(0).find('label img').attr("src","image/system/declare/yes_change.png");
$('.class1').find('p').eq(1).find('label img').attr("src","image/system/declare/no.png");
	}    
  });
  $('.class1 input[id="agree_no"]').click(function(){
	  if($(this).prop("checked")==true){
		  $('.class1').find('p').eq(0).find('label img').attr("src","image/system/declare/yes.png");
		  $('.class1').find('p').eq(1).find('label img').attr("src","image/system/declare/no_change.png");
}  
  });
});