var msg="";
var flag=false;
var flag1=false;
var reg1=/\d/;//姓名格式
var flag2=false;
var reg2="//";//性别
var flag3=true;
//var reg3=/^(\d{4}-(0\d|1[0-2])-([0-2]\d|3[0-1]))$/;//生日格式
var flag4=false;
var reg4=/\d/;//证件编号
var flag5=false;
var reg5="//g";//工作单位
var flag6=false;
var reg6="//g";//职业
var flag7=false;
var flagmsg7=false;
var reg7="//g";//昵称
var flag8=false;
var reg8=/^((\d{2,3})|(\d{2,3}.\d{0,2}))$/;//身高
var flag9=false;
var reg9=/^((\d{2,3})|(\d{2,3}.\d{0,2}))$/;//体重
var flag10=true;
var reg10=/^([\d]*|[\d]*\.[\d]{0,2})$/;//月收入
var flag11=false;
var flagmsg11=false;
var reg11=/^((13|14|15|17|18)[\d]{9})$/;//手机号
var flag12=false;
var reg12=/^([\w]+\@([\w]+\.[\w]+|[\w]+\.[\w]+\.[\w]+))$/;//邮箱
var flag13=false;
var reg13="//";//通讯地址
var flag14=false;
var reg14=/^(\d{6})$/;//邮编
var file_flag1=false;
var file_flag2=true;
var file_flag3=true;
var flag15=false;
var reg15="//g";//主文件位置
$(document).ready(function(){
	$('body #prop').hide();
	$('input[type="text"]').focus(function(){
		$(this).css({border:"solid 1px blue"});
	});
	$('input[type="text"]').blur(function(){
		$(this).css({border:"solid 1px black"});
	});
	if($('input[name="onlychild"]').eq(1).prop("checked")==true){
	$('input[name="onlychild"]').eq(1).val($('input[name="onlychild"]+select').val());
	}else{
	$('input[name="onlychild"]:eq(1)+select').prop("disabled",true);
	}
	$('input[name="onlychild"]:eq(1)').click(function(){
		$('input[name="onlychild"]:eq(1)+select').prop("disabled",false);
	});
	$('input[name="onlychild"]:eq(0)').click(function(){
		$('input[name="onlychild"]:eq(1)+select').prop("disabled",true);
	});
	$('input[name="onlychild"]:eq(1)+select').change(function(){
		$(this).prev().val($(this).val());
	});
	$('.p2 input[name="delete"]').eq(0).click(function(e){
		var index=$(this).index('.p2 input[name="delete"]');
		$('.p2 input[type="file"]').eq(index).val(null);
		$('.p2 input[type="file"]').eq(index).next().next().find('p').replaceWith("<p></p>");
		$(this).parents('#id1').next().css({display:"block",border:"1px solid red"}).find('p').replaceWith("<p>请上传新的主图片</p>");
		$(this).prev().focus();
		file_flag1=false;
	});//祝图片图片清空
	$('.p2 input[name="delete"]').eq(1).click(function(e){
		var index=$(this).index('.p2 input[name="delete"]');
		$('.p2 input[type="file"]').eq(index).next().next().find('p').replaceWith("<p></p>");
		$('.p2 input[type="file"]').eq(index).val(null);
		file_flag2=true;
		$(this).parents('#id1').next().css({display:"none"});
	});//图片清空
	$('.p2 input[name="delete"]').eq(2).click(function(e){
		var index=$(this).index('.p2 input[name="delete"]');
		$('.p2 input[type="file"]').eq(index).next().next().find('p').replaceWith("<p></p>");
		$('.p2 input[type="file"]').eq(index).val(null);
		file_flag3=true;
		$(this).parents('#id1').next().css({display:"none"});
	});//图片清空
	$('body #id1:nth-of-type(1)>p:nth-of-type(2) input').keypress(function(){
		if($(this).val().length==10) alert('昵称最多10个字符');
	});
	$('body input[type="text"]').eq(0).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>名字不能为空!</p>");
			flag1=false;
		}else{
			$(this).parents('#id1').next().css({display:"none"});
			flag1=true;
		}
		
	});//名称不能为空
	$('body input[type="text"]').eq(1).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>籍贯不能为空!</p>");
		  flag2=false;
		}else{
			$(this).parents('#id1').next().css({display:"none"});
			flag2=true;
		}	
	});//籍贯格式
	//$('body input[type="text"]').eq(2).blur(function(e){
	//	if($(this).val()==""){ 
	//		$(this).parents('#id1').next().find('p').replaceWith("<p>出生日期不能为空!</p>");
	//	    flag3=false;
	//	}else{
	//		if(!reg3.test($(this).val())){
	//			$(this).focus();
	//			$(this).parents('#id1').next().css({border:"1px solid red",display:"block"}).find('p').replaceWith("<p>出生日期格式不对!</p>");
	//		    flag3=false;
	//		}else{
	//			$(this).parents('#id1').next().css({display:"none"});
	//			flag3=true;
	//		}
	//	}
		
//	});//出生日期格式
	$('body input[type="text"]').eq(2).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>证件号不能为空!</p>");
		flag4=false;
		}else{
			$(this).parents('#id1').next().css({display:"none"});
			flag4=true;
		}
		
	});//证件号格式
	$('body input[type="text"]').eq(3).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>工作单位不能为空!</p>");
		    flag5=false;
		}else{
			$(this).parents('#id1').next().css({display:"none"});
			flag5=true;
		}	
	});//工作单位格式
	$('body input[type="text"]').eq(4).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>职业不能为空!</p>");
		flag6=false;
		}else{
			$(this).parents('#id1').next().css({display:"none"});
			flag6=true;
		}	
	});//职业格式
	$('body input[type="text"]').eq(5).blur(function(e){
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>昵称不能为空!</p>");
			flag7=false;
			$(this).focus();	
		}else{
			var value=$(this).val();
			$.get("AJAXServlet?action=ajax_register",{type:"nickname",nickname:value},function(data){
				if(data==1){
					msg="昵称已经被注册";
				flag7=false;
			    flagmsg7=true;
			    $('body #id1 input[type="text"]').eq(5).parents('#id1').next().css({display:"block",border:"1px solid red"}).find('p').replaceWith("<p>"+msg+"</p>");
			    $('body #id1 input[type="text"]').eq(5).parents('#id1').focus();
				}else{
					flag7=true;
					flagmsg7=false;
					msg="昵称可以注册";
				$('body #id1 input[type="text"]').eq(5).parents('#id1').next().css({display:"none"});
				}
			});
			}
        if(flag7)
		$(this).parents('#id1').next().css({display:"none"});
	});//昵称格式
	$('body input[type="text"]').eq(6).blur(function(e){
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>身高不能为空!</p>");
			flag8=false;
		}else{
			if(!reg8.test($(this).val())){
				$(this).focus();
            $(this).parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>身高格式不对</p>");
				flag8=false;
			}else{
				flag8=true;
			}
		}
		if(flag8) 
			$(this).parents('#id1').next().css({display:"none"});
	});//身高格式
	$('body input[type="text"]').eq(7).blur(function(e){
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>体重不能为空!</p>");
			flag9=false;
		}else{
			if(!reg9.test($(this).val())){
				$(this).parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>体重格式不对</p>");
			$(this).focus();
			flag9=false;
			}else{
				flag9=true;
			}
		}
if(flag9)
$(this).parents('#id1').next().css({display:"none"});
	});//体重格式
	$('body input[type="text"]').eq(8).blur(function(e){
		var value=$(this).val();
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>手机不能为空!</p>");
			flag11=false;
		}else{
			if(!reg11.test($(this).val())){
			$(this).focus();
			$(this).parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>手机号码格式不对</p>");
			flag11=false;
			}else{
				$.get("AJAXServlet?action=ajax_register",{type:"phone",phone:value},function(data){
					if(data==1){ 
						flag11=false;
						flagmsg11=true;
						msg="手机号已经被注册";	
						$('body input[type="text"]').eq(8).parents('#id1').next().css({display:"block",border:"1px solid red"}).find('p').replaceWith("<p>"+msg+"</p>");
						$('body input[type="text"]').eq(8).focus();
					}
					else{
					msg="手机号可以注册";
					flagmsg11=false;
					flag11=true;
					$('body input[type="text"]').eq(8).parents('#id1').next().css({display:"block",border:"1px solid red"}).find('p').replaceWith("<p>"+msg+"</p>");
					$('body input[type="text"]').eq(8).parents('#id1').next().css({display:"none"});
					//alert(flag11+"1");
					}	
				});
			}
			//alert(flag11+"2");
			}
		//alert(flag11+"3");
		if(flag11){
			//alert(flag11);
			$(this).parents('#id1').next().css({display:"none"});}
	});//手机号码格式
	$('body input[type="text"]').eq(9).blur(function(e){
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>邮箱不能为空!</p>");
			flag12=false;
		}else{
			if(!reg12.test($(this).val())){
			$(this).focus();
			$(this).parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>邮箱格式不对</p>");
			flag12=false;
			}else{
				flag12=true;
			}
		}
		if(flag12)
			$(this).parents('#id1').next().css({display:"none"});
	});//邮箱格式
	$('body input[type="text"]').eq(10).blur(function(e){
		if($(this).val()==""){
			$(this).parents('#id1').next().find('p').replaceWith("<p>通讯地址不能为空!</p>");
			flag13=false;
		}else{
				flag13=true;
		}
		if(flag13) 
			$(this).parents('#id1').next().css({display:"none"});
	});//通讯地址
	$('body input[type="text"]').eq(11).blur(function(e){
		if($(this).val()==""){ 
			$(this).parents('#id1').next().find('p').replaceWith("<p>邮编不能为空!</p>");
			flag14=false;
		}else{
			if(!reg14.test($(this).val())){
				$(this).focus();
				$(this).parents('#id1').next().css({display:"block",border:"1px solid red"}).find('p').replaceWith("<p>邮编格式不对</p>");
			flag14=false;
			}else{
				flag14=true;
			}
		}
if(flag14)
		$(this).parents('#id1').next().css({display:"none"});
	});//邮编格式
	$('body #id1  input[type="file"]').parents('#id1').one("click",function(){
		$(this).next().find('p').replaceWith("<p>请上传图片,上传图片大小不得超过2M,格式结尾为.png,.jpeg,.bmp,.gif,.rgb,.jpg其中第一张图,为主图片,审核通过后不可以再更改</p>").end().show();
	});
	$('body #id1  input[type="file"]').click(function(e){
		var str=$(this).val();
		if(str!="")
		$(this).next().next().find('p').replaceWith("<p>"+str+"</p>");
	});
	$('body #id1  input[type="file"]').eq(0).change(function(e){
		var str=$(this).val();
		$(this).next().next().find('p').replaceWith('<p>'+str+'</p>');
		var lastindex=str.lastIndexOf('.');
		str=str.substr(lastindex+1);
		str=str.toLowerCase();
		if(str==""){
			file_flag1=false;
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>主图片不能为空</p>");	
		}
		else{
		if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
			file_flag1=true;
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'none'});
		}else{
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>图片的格式不对,请检查</p>");
		file_flag1=false;
		}}
	});
	$('body #id1  input[type="file"]').eq(1).change(function(e){
		var str=$(this).val();
		$(this).next().next().find('p').replaceWith('<p>'+str+'</p>');
		var lastindex=str.lastIndexOf('.');
		str=str.substr(lastindex+1);
		str=str.toLowerCase();
		if(str=="") file_flag2=true;else{
		if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
			file_flag2=true;
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'none'});
		}else{	
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>图片的格式不对,请检查</p>");
			file_flag2=false;
		}}
	});
	$('body #id1  input[type="file"]').eq(2).change(function(e){
		var str=$(this).val();
		$(this).next().next().find('p').replaceWith('<p>'+str+'</p>');
		var lastindex=str.lastIndexOf('.');
		str=str.substr(lastindex+1);
		str=str.toLowerCase();
		if(str=="") file_flag3=true;
		else{
		if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
			file_flag3=true;
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'none'});
		}else{	
			$('body #id1 input[type="file"]').parents('#id1').next().css({display:'block',border:"1px solid red"}).find('p').replaceWith("<p>图片的格式不对,请检查</p>");
			file_flag3=false;
		}}
	});
	$('body #footer #submit').click(function(){
		var select=$('body input[type="birthday"]').parent().find('select');
		var value=$('select').eq(0).val()+"-"+$('select').eq(1).val()+"-"+$('select').eq(2).val();
		$('body input[name="birthday"]').val(value);
		flag15=file_flag1&&file_flag2&&file_flag3;
		flag=flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9&&flag10&&flag11&&flag12&&flag13&&flag14&&flag15;
		if(flag){
		//$('body #prop').show(function(){
		//	setTimeout(2000,function(){$(this).hide();});
		//});
		$('form:first').submit();
		}else{
			if($('body input[type="text"]').eq(0).val()!="") 
				flag1=true;
	        if($('body input[type="text"]').eq(1).val()!="")
				flag2=true;
			if($('body input[type="text"]').eq(2).val()!=""){ 
			flag4=true;
			}
			if($('body input[type="text"]').eq(3).val()!=""){ 
				flag5=true;
			}	
		if($('body input[type="text"]').eq(4).val()!=""){ 
				flag6=true;
			}	
		if($('body input[type="text"]').eq(5).val()!=""){
				var value=$('body input[type="text"]').eq(5).val();
				$.get("AJAXServlet?action=ajax_register",{type:"nickname",nickname:value},function(data){
					if(data==1){
					flag7=false;
				    }else{
					flag7=true;
					}
				});
				}
		if($('body input[type="text"]').eq(6).val()!=""&&reg8.test($('body input[type="text"]').eq(6).val())){
					flag8=true;
			}
	   if($('body input[type="text"]').eq(7).val()!=""&&reg9.test($('body input[type="text"]').eq(7).val())){
					flag9=true;
			}
		if($('body input[type="text"]').eq(8).val()!=""&&reg11.test($('body input[type="text"]').eq(8).val())){
			var value=$('body input[type="text"]').eq(8).val();		
			$.get("AJAXServlet?action=ajax_register",{type:"phone",phone:value},function(data){
						if(data==1){ 
							flag11=false;
					}
					else{
						flag11=true;
						}	
					});
				}
		if($('body input[type="text"]').eq(9).val()!=""&&reg12.test($('body input[type="text"]').eq(9).val())){
					flag12=true;
				}
    	if($('body input[type="text"]').eq(10)!=""){	
					flag13=true;
			}
	   if($('body input[type="text"]').eq(11).val()!=""&&reg14.test($('body input[type="text"]').eq(11).val())){ 
					flag14=true;
				}
			var str=$('body #id1  input[type="file"]').eq(0).val();
			var lastindex=str.lastIndexOf('.');
			str=str.substr(lastindex+1);
			str=str.toLowerCase();
			if(str==""){
				file_flag1=false;
			}
			else{
			if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
				file_flag1=true;
			}else{
			file_flag1=false;
			}}
			str=$('body #id1  input[type="file"]').eq(1).val();
			lastindex=str.lastIndexOf('.');
			str=str.substr(lastindex+1);
			str=str.toLowerCase();
			if(str=="") file_flag2=true;else{
			if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
				file_flag2=true;
			}else{	
				file_flag2=false;
			}}
		   str=$('body #id1  input[type="file"]').eq(2).val();
			lastindex=str.lastIndexOf('.');
			str=str.substr(lastindex+1);
			str=str.toLowerCase();
			if(str=="") file_flag3=true;
			else{
			if((str=="png")||(str=="jpeg")||(str=="bmp")||(str=="gif")||(str=="rgb")||(str=="jpg")){
				file_flag3=true;
			}else{	
				file_flag3=false;
			}}
		flag15=file_flag1&&file_flag2&&file_flag3;
		flag=flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9&&flag10&&flag11&&flag12&&flag13&&flag14&&flag15;
		if(flag){
			//$('body #prop').show(function(){
			//	setTimeout(2000,function(){$(this).hide();});
			//});
			$('form:first').submit();
			}
	        }
	});
	$('body #footer #reset').click(function(){
		flag=false;flag1=false;flag2=false;flag3=false;flag4=false;flag5=false;flag6=false;flag7=false;flag8=false;flag9=false;flag10=false;flag11=false;flag12=false;flag13=false;flag14=false;flag15=false;
		file_flag1=false;file_flag2=true;file_flag3=true;
	$('input[type="text"]').val(null);
	$('input[type="file"]').val(null);
	$('.p1').css({display:"none"});
	});
	$('body input[type="text"]').blur(function(e){
		if($(this).val()==""){ 
		$(this).focus();
		$(this).parents('#id1').next().css({border:"1px solid red",display:"block"});
		}
	});
	$('body input[type="text"]').focus(function(e){
		if(!($(this).val()=="")){ 
		}else{
		$(this).parents('#id1').next().css({border:"1px solid red",display:"block"});
			
		}
		
	});
});