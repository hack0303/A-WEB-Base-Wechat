<%@page import="cn.net.www.session.RegisterSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html Style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>申办须知/优活寻ta卡</title>
<link rel="stylesheet" href="css/default.css" type="text/css"></link>
<link rel="stylesheet" href="css/userinformation/register/warning.css" type="text/css">
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/userinformation/register/warning.js"></script>
<%
RegisterSession rs=(RegisterSession)session.getAttribute("rs");
 if(rs!=null){
  String type=rs.getType();
 int want=Integer.parseInt(rs.getWant());
 String url="";
 if(type.equals("xunta")){
 switch(want){
 case 1:{
 url="";
break; 
 }
 case 2:{
 url="ForwardServlet?action=register&type=xunta&step=two";
 break;
 }
 }}
 response.sendRedirect(url);
 }
 %>
</head>
<body>
<div id="image">
<div id="image1">
<h1 align="left">&nbsp; 优活寻Ta会员  Yohoo Dating member 
</h1>
<h1> 
<p>申请须知</p>
<p>application notice</p>
</h1> 
<p>
1.申办人凭本人有效身份证、学历证书、在职证明向星乐趴提交申办信息表，一张身份证只能办理1张寻Ta卡，通过认证后即申办成功，免费领取会员卡。初始卡为缘来卡，如需获得更多帮助和权益，可申请缘定卡，享受定制服务和增值服务。
</p>
<p>
2.为了匹配您的寻Ta需求，请您认真填写真实、完整的信息资料和调查问卷，并提供相关证明材料。我们承诺绝不向任何第三方泄露涉及您的隐私信息。
</p>
<p>
3.会员卡同时具备积分功能，现场参加活动或消费前需提前出示寻Ta卡，积分即时录入电脑系统，过后不作补录。
</p>
<p>
4.会籍有效周期为半年，开通后根据活跃程度晋级，获取更多福利；若在有效周期内未有任何参与记录，会员卡将自动失效。
</p>
<p>
5.密切关注星乐趴公众号（lovelyparty520），了解最新动态、活动公告和会员专属福利，预约报名要参加的活动和项目。预约成功后，请关注电子邮件、手机短信或电话通知，及时回复确认，以免错过活动。
</p>
<p>
6.寻Ta卡只限本人使用，不得转借他人，配对成功后转为“优活睿趣卡”，转卡后原卡积分延续，使用条件和相关权益随之转变。
</p>
<p>
7.若不慎遗失寻Ta卡或人为损坏无法使用时，您可凭本人有效身份证至会员服务中心办理补卡手续，补卡后的新卡沿用原卡的有效期和有效积分，原卡即被注销。补卡工本费：10元。
</p>
<p>
8.若信息资料发生变更，请及时凭本人有效身份证、工作证至会员服务中心办理资料变更手续，以便我们能更好地为您服务。
</p>
<p>
9.申办星乐趴“优活寻Ta卡”均视为理解并接受本须知。成功申办后，会员参加活动时须举止文明，服从管理，不得影响公共秩序与安全，否则星乐趴有权取消其会员资格。
</p>
<p>
1.Please show us your ID card, degree certificate,employment certificate and application form in Starring Lovely Party in Starring Lovely Party.One ID card corresponds to only one Match-He/She Card,and you can have VIP card free after verification.
</p>
<p>
2.In order to satisfy your needs precisely,please provide the real,complete information and questionnaire.We promise never to spread your information to the third part.
</p>
<p>
3.VIP card have integration function. Please show your Yohoo Dating Card before you pay or participate in activities; the VIP points will be enrolled in-computer at the moment you pay; they can’t be enrolled later.
</p>
<p>
4.The card is half-a-year validity. Card is originally general level; it can offer you more privileges after activation and upgrading; or you can handle the customized service and value added service. If you don’t participate in any activities in the valid period, the card will be canceled automatically.
</p>
<p>
5.Follow the Starring Lovely Party’s Wechat: lovelyparty520 to get the latest announcement, notice and VIP activities and more details. You are also able to make an appointment; please focus on your E-mail, message and phone-call when appoint successfully. Please check it timely in case of missing.
</p>
<p>
6.Match Card can only be used by yourself, and cannot be lend to others. After finding your ideal mate, it can be upgraded to Yohoo Smart Card. The points is same as the former one, but the use condition and related privilege is changed.
</p>
<p>
7.Match Card can only be used by yourself, and cannot be lend to others. After finding your ideal mate, it can be upgraded to Yohoo Smart Card. The points is same as the former one, but the use condition and related privilege is changed.
</p>
<p>
8.Match Card can only be used by yourself, and cannot be lend to others. After finding your ideal mate, it can be upgraded to Yohoo Smart Card. The points is same as the former one, but the use condition and related privilege is changed. 
</p>
<p>
9.Match Card can only be used by yourself, and cannot be lend to others. After finding your ideal mate, it can be upgraded to Yohoo Smart Card. The points is same as the former one, but the use condition and related privilege is changed.
</p>
</div>
</div>
<div id="check_nav">
<p><input type="checkbox" id="check"><label for="check">我已阅读优活寻Ta卡申办须知</label></p>
<p>(i have read the application notice of Yohoo Dating Card)</p>
</div>
<div id="footer">
<form action="ForwardServlet" method="post">
<input type="hidden" name="action" value="register">
<input type="hidden" name="type" value="xunta">
<input type="hidden" name="step" value="one">
</form>
<div id="button">我 要 申 办</div>
</div>
</body>
</html>