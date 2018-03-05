$(document).ready(function(){
	$('#footer #submit').click(function(){
		alert("调试中!请耐心等待!");
		return;
		//alert(new Date().getTime());
		var cache=new Date().getTime();	
		$.get("ActivitiesServlet",{action:"join",nocache:cache},function(data){
				var msg="";
				//alert((data=="1")?"yes":"no");
				//alert((data==true)?"yes":"no");
				if(data.length>10){
						msg="请登录后参加活动!!";
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
						msg="活动参加成功!";
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
						msg="活动参加失败!请重新尝试!如果无法解决,联系客服";
						popTipShow.alert('信息提示',msg, ['知道了'],
								function(e){
								  //callback 处理按钮事件		  
								  var button = $(e.target).attr('class');
								  if(button == 'ok'){
									//按下确定按钮执行的操作
									//todo ....
								this.hide();
								  }	
								});
					}else if(data==1){
						msg="已经参加活动!不用重复提交!";
						popTipShow.alert('信息提示',msg, ['知道了'],
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
					}	
	});
			});
});