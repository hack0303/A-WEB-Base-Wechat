var flag1=false;//姓名
var flag2=false;//昵称
var flag3=false;//性别
var flag4=false;//生日
var flag5=false;//在读学校
var flag6=false;//年级
var flag7=false;//是否独生子女
var flag8=false;//兴趣爱好
var flag9=false;//特长
$(document).ready(function(){
	flag3=true;
	flag4=true;
	flag6=true;
	flag7=true;
	$('body #submit').click(function(){
		if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9)
		$('form:first').submit();
	});
	var parent=$("input[name='birthday']").parent();
	var part1=$(parent).find('select').eq(0).val();
	var part2=$(parent).find('select').eq(1).val();
	var part3=$(parent).find('select').eq(2).val();
	var p_total=part1+"-"+part2+"-"+part3;
	$('input[name="birthday"]').val(p_total);
	if($('input[name="onlychild"]').eq(1).prop("checked")==true){
		$('input[name="onlychild"]').eq(1).next().prop("disabled",false);
	}else{
		$('input[name="onlychild"]').eq(1).next().prop("disabled",true);
	}
	$('input[name="onlychild"]').eq(1).val($('input[name="onlychild"]').eq(1).next().val());
	$('input[name="onlychild"]').click(function(){
		var index=$('input[name="onlychild"]').index($(this));
		if(index==1){
			$(this).next().prop("disabled",false);
		}else{
			$('input[name="onlychild"]').eq(1).next().prop("disabled",true);
		}
		
	});
	$('input[name="onlychild"]').eq(1).next().change(function(){
		$('input[name="onlychild"]').eq(1).val($(this).val());
	});
   $('input[name="name"]').focus(function(){
	if($(this).val()==""){
		$('.p1').eq(0).find('p').replaceWith("<p>请填写真实姓名</p>");
		$('.p1').eq(0).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
		flag1=false;
	}	
	});
   $('input[name="name"]').blur(function(){
		if($(this).val()==""){
			$('.p1').eq(0).find('p').replaceWith("<p>姓名不能为空</p>");
			$('.p1').eq(0).css({color:"red",border:"2px solid red"}).show();
			flag1=false;
			$(this).focus();
		}else{
			$('.p1').eq(0).hide();
			flag1=true;
		}	
		});//姓名
   $('input[name="nickname"]').focus(function(){
		if($(this).val()==""){
			$('.p1').eq(1).find('p').replaceWith("<p>请填写昵称</p>");
			$('.p1').eq(1).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
			flag2=false;
		}	
		});
	   $('input[name="nickname"]').blur(function(){
			if($(this).val()==""){
				$('.p1').eq(1).find('p').replaceWith("<p>昵称不能为空</p>");
				$('.p1').eq(1).css({color:"red",border:"2px solid red"}).show();
				flag2=false;
				$(this).focus();
			}else{
				$('.p1').eq(1).hide();
				flag2=true;
			}	
			});//昵称
	   
   $('input[name="school"]').focus(function(){
		if($(this).val()==""){
			$('.p1').eq(4).find('p').replaceWith("<p>请填写学校</p>");
			$('.p1').eq(4).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
			flag5=false;
		}	
		});
	   $('input[name="school"]').blur(function(){
			if($(this).val()==""){
				$('.p1').eq(4).find('p').replaceWith("<p>学校不能为空</p>");
				$('.p1').eq(4).css({color:"red",border:"2px solid red"}).show();
				flag5=false;
				$(this).focus();
			}else{
				$('.p1').eq(4).hide();
				flag5=true;
			}	
			});//学校

	   $('input[name="hobby"]').focus(function(){
			if($(this).val()==""){
				$('.p1').eq(7).find('p').replaceWith("<p>请填写爱好</p>");
				$('.p1').eq(7).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
				flag8=false;
			}	
			});
		   $('input[name="hobby"]').blur(function(){
				if($(this).val()==""){
					$('.p1').eq(7).find('p').replaceWith("<p>爱好不能为空</p>");
					$('.p1').eq(7).css({color:"red",border:"2px solid red"}).show();
					flag8=false;
					$(this).focus();
				}else{
					$('.p1').eq(7).hide();
					flag8=true;
				}	
				});//兴趣爱好
		   $('input[name="speciality"]').focus(function(){
				if($(this).val()==""){
					$('.p1').eq(8).find('p').replaceWith("<p>请填写学校</p>");
					$('.p1').eq(8).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
					flag9=false;
				}	
				});
			   $('input[name="speciality"]').blur(function(){
					if($(this).val()==""){
						$('.p1').eq(8).find('p').replaceWith("<p>学校不能为空</p>");
						$('.p1').eq(8).css({color:"red",border:"2px solid red"}).show();
						flag9=false;
						$(this).focus();
					}else{
						$('.p1').eq(8).hide();
						flag9=true;
					}	
					});//特长
	$(parent).find('select').change(function(){
		part1=$(parent).find('select').eq(0).val();
		part2=$(parent).find('select').eq(1).val();
		part3=$(parent).find('select').eq(2).val();
		p_total=part1+"-"+part2+"-"+part3;
		$('input[name="birthday"]').val(p_total);
	});
	
});