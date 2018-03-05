<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>约我表态|星乐趴</title>
    <meta name="viewport" content="height=device-height,width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" href="css/userinformation/Yuewo/declare/three.css" type="text/css"></link>
  <script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/Yuewo/declare/three.js"></script></head>
  
  <body>
  <div id="part1"><h1>约单编号:${object.date_number}</h1></div>
  <div class="title"><h1>约会表态</h1></div>
  <div id="part2">
  <form action="DateServlet" method="post">
  <input type="hidden" name="action" value="declare">
  <input type="hidden" name="type" value="yuewo">
  <input type="hidden" name="step" value="three">
  <input type="hidden" name="date_number" value="${object.date_number}">
  <input type="radio" name="agree" value="yes" checked id="radio_yes" hidden="true">
  <input type="radio" name="agree" value="no" id="radio_no" hidden="true">
  <div class="class1"><label for="radio_yes"><img src="image/system/declare/yes_change.png"></img> 愿意约会</label></div>
  <div class="class1"><label for="radio_no"><img src="image/system/declare/no.png"></img> 不适合</label></div>
  </div>
 <div class="title"><h1>印象评分</h1></div>
  <div id="part3">
  <input type="checkbox" name="star" id="check_one" hidden="true" value="1">
  <input type="checkbox" name="star" id="check_two" hidden="true" value="2">
  <input type="checkbox" name="star" id="check_three" hidden="true" value="3">
  <input type="checkbox" name="star" id="check_four" hidden="true" value="4">
  <input type="checkbox" name="star" id="check_five" hidden="true" value="5">
   <div id="image">
   <div class="image_position">
   <label for="check_one">
   <img src="image/system/declare/2.png"></img></label>
   <label for="check_two">
   <img src="image/system/declare/2.png"></img>
   </label>
   <label for="check_three">
   <img src="image/system/declare/2.png"></img>
    </label>
   <label for="check_four">
   <img src="image/system/declare/2.png"></img>
    </label>
   <label for="check_five">
   <img src="image/system/declare/2.png"></img>
   </label>
   </div>
    </div>
  <div id="content">
  <div id="content_nav">
  <textarea name="content">
  </textarea>
  </form>
  </div>
  </div>
  </div>
  <div id="part4">
<p>确认提交</p><p>重置 </p>
  </div>
  </body>
</html>
