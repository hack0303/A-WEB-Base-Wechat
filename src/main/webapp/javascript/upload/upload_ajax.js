$(document).ready(function(){
	$('#test #upload').click(function(){
	//	var formdata=new FormData();
		//formdata.append("action","uploadFile_ajax");
		//if(typeof formData==='undefine') alert('版本太低不支持');
		//else alert('版本支持');
		//alert($('#test form')[0]);
		var fd=new FormData($('#test form')[0]);
	$.ajax({
		 url: "MyServlet?action=uploadFile_ajax",
		 type: "POST",
		 data:fd,
		 processData: false,  // 告诉jQuery不要去处理发送的数据
		 contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
		 dataType:"json",
		 success:function(data){
			 var obj=eval("("+data+")");
		       $.each(obj,function(i,item){
		       alert(item);
		       });
		  },
	      error:function(data){
	    	  var obj=eval("("+data+")");
		       $.each(obj,function(i,item){
		       alert(item);
		       });
	      }
		});
	});	
});