$(document).ready(function(){
	$('#part2 input[type="radio"]#radio_yes').click(function(){
	if($(this).prop("checked")==true){
		$('.class1 label[for="radio_yes"]').find('img').attr("src","image/system/declare/yes_change.png");
		$('.class1 label[for="radio_no"]').find('img').attr("src","image/system/declare/no.png");
	}});
	$('#part2 input[type="radio"]#radio_no').click(function(){
		if($(this).prop("checked")==true){
			$('.class1 label[for="radio_yes"]').find('img').attr("src","image/system/declare/yes.png");
			$('.class1 label[for="radio_no"]').find('img').attr("src","image/system/declare/no_change.png");
		}});
	$('#part3 input[type="checkbox"]').click(function(){
		var flag=$(this).prop("checked");
		var index=$(this).index();
		for(var i=0;i<5;i++){
		if(i<=index){
			$('.image_position label').eq(i).find('img').attr("src",function(){
			return "image/system/declare/1.png";
		});}else{
			$('.image_position label').eq(i).find('img').attr("src",function(){
				return "image/system/declare/2.png";
		});
		}
		}
		if(flag) $(this).siblings().prop("checked",false);
	});
	$('#part4 p').eq(0).click(function(){
		$('form').eq(0).submit();
	});
});