var i=false;
$(document).ready(function(){
	if($('input[type="checkbox"]').prop("checked")==true){ 
		i=true;
	//	$(this).next().find('img').attr("src","image/register/check_yes.png");	
	}
	else{ 
		i=false;
		//$(this).next().find('img').attr("src","image/register/check_no.png");
	}
	//$('body #image1').scroll(function(e){
	//var	scrollTop=$(this).scrollTop();
	//var scrollHeight=$(this)[0].scrollHeight;
	//var clientHeight=$(this).height();
	//if(scrollTop+clientHeight<=scrollHeight){
	//$('input[type="checkbox"]').prop("disabled",false);
	//}		
	//});
	$('input[type="checkbox"]').click(function(){
    if(i){ i=false;
//$(this).next().find('img').attr("src","image/register/check_no.png");
   }else{ i=true;
 //  $(this).next().find('img').attr("src","image/register/check_yes.png");
   }
	});
	$('#footer #button').click(function(){
		if(i) $('form:first').submit();
		else alert("请仔细阅读申请说明,并在同意前面打勾");
	});
});