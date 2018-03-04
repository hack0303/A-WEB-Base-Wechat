var check_flag=false;
$(document).ready(function(){
	$('#submit').click(function(){
		if(check_flag){
			$.get("MyServlet",$('form:first').serialize(),function(data){
				var msg="";
				if(data.length>10){
					msg="请登录后,再进行申请提交!!";
					popTipShow.alert('信息提示',msg, ['知道了'],
							function(e){
							  //callback 处理按钮事件		  
							  var button = $(e.target).attr('class');
							  if(button == 'ok'){
								//按下确定按钮执行的操作
								//todo ....
							this.hide();
							location.href="ForwardServlet?action=userlogin&type=xunta";
							  }}
					);
				}else{
				if(data=="true"){
					msg="申请提交成功!请等待后台通过";
					popTipShow.alert('信息提示',msg, ['知道了'],
								function(e){
								  //callback 处理按钮事件		  
								  var button = $(e.target).attr('class');
								  if(button == 'ok'){
									//按下确定按钮执行的操作
									//todo ....
									  this.hide();
									  location.reload(true);
								}	
								}
							);
				}else if(data=="false"){
					msg="申请提交失败!";
					popTipShow.alert('信息提示',msg, ['知道了'],
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
			});
		}
	});
	$("#check input[type='checkbox']").click(function(){
		$('body #pop').addClass('hidden');
		if(check_flag)check_flag=false;
		else check_flag=true;
	});
	$('body #pop #pop_top p').click(function(){
		$('body #pop').removeClass('hidden');
	});
});