var flag1=false;//姓名
var flag2=false;//性别
var flag3=false;//生日
var flag4=false;//证件类型
var flag5=false;//证件编号
var flag6=false;//职业
var flag7=false;//手机
var reg7=/^((13|15|18)[\d]{9})$/;//手机号
var flag8=false;//邮箱
var reg8=/^([\w]+\@([\w]+\.[\w]+|[\w]+\.[\w]+\.[\w]+))$/;//邮箱
var flag9=false;//通讯地址
var flag10=false;//邮编
var reg10=/^(\d{6})$/;//邮编
$(document).ready(function(){
	flag2=true;
	flag3=true;
	flag4=true;
	$('body #submit').click(function(){
		if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9&&flag10)
		$('form:first').submit();
	});
	var parent=$("input[name='birthday']").parent();
	var part1=$(parent).find('select').eq(0).val();
	var part2=$(parent).find('select').eq(1).val();
	var part3=$(parent).find('select').eq(2).val();
	var p_total=part1+"-"+part2+"-"+part3;
	$('input[name="birthday"]').val(p_total);
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
   
   $('input[name="id_number"]').focus(function(){
		if($(this).val()==""){
			$('.p1').eq(4).find('p').replaceWith("<p>请填写证件编号</p>");
			$('.p1').eq(4).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
			flag5=false;
		}	
		});
	   $('input[name="id_number"]').blur(function(){
			if($(this).val()==""){
				$('.p1').eq(4).find('p').replaceWith("<p>证件编号不能为空</p>");
				$('.p1').eq(4).css({color:"red",border:"2px solid red"}).show();
				flag5=false;
				$(this).focus();
			}else{
				$('.p1').eq(4).hide();
				flag5=true;
			}	
			});//证件编号

	   $('input[name="occupation"]').focus(function(){
			if($(this).val()==""){
				$('.p1').eq(5).find('p').replaceWith("<p>请填写职业</p>");
				$('.p1').eq(5).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
				flag6=false;
			}	
			});
		   $('input[name="occupation"]').blur(function(){
				if($(this).val()==""){
					$('.p1').eq(5).find('p').replaceWith("<p>职业不能为空</p>");
					$('.p1').eq(5).css({color:"red",border:"2px solid red"}).show();
					flag6=false;
					$(this).focus();
				}else{
					$('.p1').eq(5).hide();
					flag6=true;
				}	
				});//职业
		   $('input[name="phone"]').focus(function(){
				if($(this).val()==""){
					$('.p1').eq(6).find('p').replaceWith("<p>请填写手机号</p>");
					$('.p1').eq(6).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
					flag7=false;
				}	
				});
			   $('input[name="phone"]').blur(function(){
					if($(this).val()==""){
						$('.p1').eq(6).find('p').replaceWith("<p>手机号不能为空</p>");
						$('.p1').eq(6).css({color:"red",border:"2px solid red"}).show();
						flag7=false;
						$(this).focus();
					}else{
						if(reg7.test($(this).val())){
						$('.p1').eq(6).hide();
						flag7=true;
					}else{
							$('.p1').eq(6).find('p').replaceWith("<p>手机号格式不对</p>");
							$('.p1').eq(6).css({color:"red",border:"2px solid red"}).show();
							flag7=false;
							$(this).focus();
						}
					}	
					});//手机号

			   $('input[name="email"]').focus(function(){
					if($(this).val()==""){
						$('.p1').eq(7).find('p').replaceWith("<p>请填写邮箱地址</p>");
						$('.p1').eq(7).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
						flag8=false;
					}	
					});
				   $('input[name="email"]').blur(function(){
						if($(this).val()==""){
							$('.p1').eq(7).find('p').replaceWith("<p>邮箱地址不能为空</p>");
							$('.p1').eq(7).css({color:"red",border:"2px solid red"}).show();
							flag8=false;
							$(this).focus();
						}else{
							if(reg8.test($(this).val())){
								$('.p1').eq(7).hide();
								flag8=true;
							}else{
								$('.p1').eq(7).find('p').replaceWith("<p>邮箱地址格式不对</p>");
								$('.p1').eq(7).css({color:"red",border:"2px solid red"}).show();
								flag8=false;
								$(this).focus();
							}
						}	
						});//邮箱地址
			   
		   $('input[name="address"]').focus(function(){
				if($(this).val()==""){
					$('.p1').eq(8).find('p').replaceWith("<p>请填写通讯地址</p>");
					$('.p1').eq(8).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
					flag9=false;
				}	
				});
			   $('input[name="address"]').blur(function(){
					if($(this).val()==""){
						$('.p1').eq(8).find('p').replaceWith("<p>通讯地址不能为空</p>");
						$('.p1').eq(8).css({color:"red",border:"2px solid red"}).show();
						flag9=false;
						$(this).focus();
					}else{
						$('.p1').eq(8).hide();
						flag9=true;
					}	
					});//通讯地址

			   $('input[name="postcode"]').focus(function(){
					if($(this).val()==""){
						$('.p1').eq(9).find('p').replaceWith("<p>请填写邮箱地址</p>");
						$('.p1').eq(9).css({color:"#C8AE66",border:"2px solid #C8AE66"}).show();
						flag10=false;
					}	
					});
				   $('input[name="postcode"]').blur(function(){
						if($(this).val()==""){
							$('.p1').eq(9).find('p').replaceWith("<p>邮箱地址不能为空</p>");
							$('.p1').eq(9).css({color:"red",border:"2px solid red"}).show();
							flag10=false;
							$(this).focus();
						}else{
							if(reg10.test($(this).val())){
								$('.p1').eq(9).hide();
								flag10=true;
							}else{
								$('.p1').eq(9).find('p').replaceWith("<p>邮箱地址格式不对</p>");
								$('.p1').eq(9).css({color:"red",border:"2px solid red"}).show();
								flag10=false;
								$(this).focus();
							}
						}	
						});//邮箱地址
			   
	$(parent).find('select').change(function(){
		part1=$(parent).find('select').eq(0).val();
		part2=$(parent).find('select').eq(1).val();
		part3=$(parent).find('select').eq(2).val();
		p_total=part1+"-"+part2+"-"+part3;
		$('input[name="birthday"]').val(p_total);
	});
	
});