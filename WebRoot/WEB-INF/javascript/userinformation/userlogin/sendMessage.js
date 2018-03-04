var phone_flag=false;
var checkcode_flag=false;
var phone_pattern=/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/i;
var checkcode_pattern=/^\d*$/;
function sendMessage(){
	var phone_number=$('input[name="phone"]').val();
	var type=$('input[name="type"]').val();
	if(phone_number!=""){
   $.get("MessageServlet",{"action":"sendMessage","phone":phone_number,"type":type},function(data){
	   webToast(data,"middle",3000);
	   });
}else{
		popTipShow.alert('错误警告','手机号不能为空，请输入手机号', ['知道了'],
			function(e){
			  //callback 处理按钮事件		  
			  var button = $(e.target).attr('class');
			  if(button == 'ok'){
				//按下确定按钮执行的操作
				//todo ....
				this.hide();
			  }	
			}
		);
}	
}
$(document).ready(function(){
$('.list #submit').click(function(){
	if(phone_flag&&checkcode_flag)
	$('form').eq(0).submit();
});
$("#check").click(function(){
	if(phone_flag)
	sendMessage();
	else{
		popTipShow.alert('错误警告','请输入正确的手机号', ['知道了'],
				function(e){
				  //callback 处理按钮事件		  
				  var button = $(e.target).attr('class');
				  if(button == 'ok'){
					//按下确定按钮执行的操作
					//todo ....
					this.hide();
				  }	
				  });
	}
	});
$("input[name='phone']").blur(function(){
	var value=$(this).val();
	if(value==""){
		phone_flag=false;
		popTipShow.alert('错误警告','手机号不能为空', ['知道了'],
				function(e){
				  //callback 处理按钮事件		  
				  var button = $(e.target).attr('class');
				  if(button == 'ok'){
					//按下确定按钮执行的操作
					//todo ....
					this.hide();
				  }	
				}
			);
		$(this).focus();
		return;
	}
	if(phone_pattern.test(value)){
		phone_flag=true;
	}else{
		phone_flag=false;
		popTipShow.alert('错误警告','手机号格式不对', ['知道了'],
				function(e){
				  //callback 处理按钮事件		  
				  var button = $(e.target).attr('class');
				  if(button == 'ok'){
					//按下确定按钮执行的操作
					//todo ....
					this.hide();
				  }	
				}
			);
		$(this).focus();
	}
});//手机号框焦点失去,对空和格式进行判断
$("input[name='checkcode']").focus(function(){
	var phone_number=$('input[name="phone"]').val();
	if(phone_number==""){
			popTipShow.alert('错误警告','请输入手机号', ['知道了'],
			function(e){
			  //callback 处理按钮事件		  
			  var button = $(e.target).attr('class');
			  if(button == 'ok'){
				//按下确定按钮执行的操作
				//todo ....
				this.hide();
			  }	
			}
		);
		$("input[name='phone']").focus();
		return;
	}
});
$("input[name='checkcode']").blur(function(){
	var checkcode=$(this).val();
	if(checkcode!=""){
		var length=checkcode.length;
		if(length==6){
			checkcode_flag=true;
			return;
		}else{
			popTipShow.alert('错误警告','验证码出错,请重新输入', ['知道了'],
					function(e){
					  //callback 处理按钮事件		  
					  var button = $(e.target).attr('class');
					  if(button == 'ok'){
						//按下确定按钮执行的操作
						//todo ....
						this.hide();
					  }	
					  });	
		$(this).val(null);
		checkcode_flag=false;
		return;
		}	
	}else{
		checkcode_flag=false;
		return;
	}
});
});