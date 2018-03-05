<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/" ;   
%>   
<base href="<%=basePath%>" > 
    <title>My JSP 'testAjax.jsp' starting page</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="javascript/jquery.js"></script>
<script>
$(document).ready(
$.ajax({ 
  url:"MyServlet",// 跳转到 action  
    data:{
       action:'yue_list',
        test:'test'
     },  
     type:"GET",  
    cache:false,  
    dataType:"text",
    // dataType:"json",  
     success:function(data) { 
         if(data!=null ){
         //$.each(data.items,function(i,item){
         //if(i==0)
         //$('#test').append("<li>什么情况啊"+item[0]+"</li>");
         //});
         //view(data.msg);
       //$('#test').append("<li>什么情况啊"+data.msg+"</li>");
       var obj=eval("("+data+")");
       $.each(obj,function(i,item){
       alert(item);
       });
        //$('#test').append("<li>什么情况啊"+data+"</li>");
        }else{  
           alert('有病吧');
         }  
      },  
      error:function() {  
           // view("异常！");  
       alert("异常！");  
          
      },
      complete:function(e){
      alert(e.status);}
      }
)
//$.get("MyServlet",{nocache:new Date().getTime(),action:"yue_list",test:"test"},function(data){
//if(data!=null)
//{
//alert(data);
//$('#test').append("<li>什么情况啊"+data+"</li>");
//}
//})
);
</script>
  </head>
  
  <body>
    <div id="test"></div>
  </body>
</html>
