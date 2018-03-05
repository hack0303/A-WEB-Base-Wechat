<%@page import="cn.net.www.session.RegisterSession"%>
<%@ page language="java" import="java.util.*,cn.net.www.dao.QueryDao" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html style="height:100%;">
  <head>
    <base href="<%=basePath%>">
    <title>信息问卷</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/default.css" type="text/css"></link>
<link rel="stylesheet" href="css/userinformation/register/xunta/two.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
  <script type="text/javascript" src="javascript/userinformation/register/xunta/two.js"></script>
  <%
  String id=String.valueOf(((RegisterSession)session.getAttribute("rs")).getPhone());
  String gender=String.valueOf(new QueryDao().queryGenderByPhone(id));
   %>
  </head>
  
  <body> 
  <h3>为了保证您需要的需求得到精准匹配,请认真如实填写信息问卷,以便我们更好地为您服务.</h3>
 <h2>信息问卷 <br>Questionnaire</h2>
 <div id="nav">
 <form action="RegisterServlet" method="post">
<input type="hidden" name="action" value="register">
<input type="hidden" name="type" value="xunta">
<input type="hidden" name="step" value="two">
<div class="list">
<h1>1.您现在处于什么状态（多选）Which status are you in（multiple-choice）?</h1>
<p>
<input type="checkbox" name="one" value="1" id="one1"><label for="one1">积极相亲中blind dating  
</label>
</P>
<p>
<input type="checkbox" name="one" value="2" id="one2"><label for="one2">静待缘分waiting for Mr.Right？ </label>
</p>
<p>
<input type="checkbox" name="one" value="3" id="one3"><label for="one3">经常加班usually work overtime  </label>
</p>
<p>
<input type="checkbox" name="one" value="4" id="one4"><label for="one4">经常出差often on business </label>
</p>
<p>
<input type="checkbox" name="one" value="5" id="one5"><label for="one5">创业中starting up business   </label>
</p>
<p>
<input type="checkbox" name="one" value="6" id="one6"><label for="one6">失恋中be crossed in love  </label>
</p>
<p>
<input type="checkbox" name="one" value="7" id="one7"><label for="one7">换购房屋in house purchase   </label>
</p>
<p>
<input type="checkbox" name="one" value="8" id="one8"><label for="one8">换购汽车in car purchase  </label>
</p>
<p>
<input type="checkbox" name="one" value="9" id="one9"><label for="one9">经常被逼婚often be forced in marriage</label>
</p>
<p>
<input type="checkbox" name="one" value="10" id="one10"><label for="one10">其他others   </label>                
</p>
</div>
<div class="list">
<h1>
2.您的个性标签（多选）Your character or feature（multiple-choice）？
</h1>
<p>
<input type="checkbox" name="two" value="1" id="two1"><label for="two1">活泼outgoing</label>  
</P>
<p>
<input type="checkbox" name="two" value="2" id="two2"><label for="two2">安静quiet</label>     
</p>
<p>
<input type="checkbox" name="two" value="3" id="two3"><label for="two3">慵懒lazy    </label>
</p>
<p>
<input type="checkbox" name="two" value="4" id="two4"><label for="two4">勤快laborious</label>    
</p>
<p>
<input type="checkbox" name="two" value="5" id="two5"><label for="two5">腼腆shy</label>  </p><p>
<input type="checkbox" name="two" value="6" id="two6"><label for="two6">直爽frank</label>  </p><p>
<input type="checkbox" name="two" value="7" id="two7"><label for="two7">传统traditional</label> </p><p>   
<input type="checkbox" name="two" value="8" id="two8"><label for="two8">进取entreprenant</label>   </p><p> 
<input type="checkbox" name="two" value="9" id="two9"><label for="two9">吃货delicious food lover</label></p><p>    
<input type="checkbox" name="two" value="10" id="two10"><label for="two10">自信confident</label>  </p><p>  
<input type="checkbox" name="two" value="11" id="two11"><label for="two11">自卑diffidence</label>  </p><p>  
<input type="checkbox" name="two" value="12" id="two12"><label for="two12">谨慎cautious</label>   </p><p>     
<input type="checkbox" name="two" value="13" id="two13"><label for="two13">执着stubborn</label>  </p><p> 
<input type="checkbox" name="two" value="14" id="two14"><label for="two14">独立independent</label>  </p><p>
<input type="checkbox" name="two" value="15" id="two15"><label for="two15">爱干净love order and clean</label> </p><p>
<input type="checkbox" name="two" value="16" id="two16"><label for="two16">易纠结select-difficult</label> </p><p>  
<input type="checkbox" name="two" value="17" id="two17"><label for="two17">购物狂shopaholic</label>   </p><p>
<input type="checkbox" name="two" value="18" id="two18"><label for="two18">月光族moonlight clan</label>     </p><p> 
<input type="checkbox" name="two" value="19" id="two19"><label for="two19">情绪化person of emotion</label> </p><p>   
<input type="checkbox" name="two" value="20" id="two20"><label for="two20">较感性emotional</label>      </p><p>   
<input type="checkbox" name="two" value="21" id="two21"><label for="two21">较理性person of reason</label>  </p><p>
<input type="checkbox" name="two" value="22" id="two22"><label for="two22">比较宅stay-at-home lover</label>   </p><p>
<input type="checkbox" name="two" value="23" id="two23"><label for="two23">闲不住always keep yourself busy</label> </p><p>    
<input type="checkbox" name="two" value="24" id="two24"><label for="two24">爱挑战adventurous</label>      </p><p>
<input type="checkbox" name="two" value="25" id="two25"><label for="two25">工作狂workaholic</label> </p><p>
<input type="checkbox" name="two" value="26" id="two26"><label for="two26">外貌协会lookist</label>    </p><p>
<input type="checkbox" name="two" value="27" id="two27"><label for="two27">大大咧咧careless</label>    </p><p> 
<input type="checkbox" name="two" value="28" id="two28"><label for="two28">文艺青年artistic youth</label>    </p><p>     
<input type="checkbox" name="two" value="29" id="two29"><label for="two29">小资情调 bourgeois sentiment</label>  </p><p>
<input type="checkbox" name="two" value="30" id="two30"><label for="two30">依赖性强strong dependent</label>       </p><p>
<input type="checkbox" name="two" value="31" id="two31"><label for="two31">追求品质pursuit of quality</label>       </p><p>
<input type="checkbox" name="two" value="32" id="two32"><label for="two32">讲究实用pay attention to practicability</label>  </p><p>     
<input type="checkbox" name="two" value="33" id="two33"><label for="two33">精打细算economical</label>    </p><p>
<input type="checkbox" name="two" value="34" id="two34"><label for="two34">童心未泯childlike </label>    </p><p>
<input type="checkbox" name="two" value="35" id="two35"><label for="two35">善于理财good at financial  management</label></p><p>  
<input type="checkbox" name="two" value="36" id="two36"><label for="two36">完美主义perfectist</label>    </p><p>
<input type="checkbox" name="two" value="37" id="two37"><label for="two37">其他others</label>                          
 </p>
 </div>
<div class="list">
 <h1>
3.您最在意对方的方面（多选）Which part of your boy/girl friend do you most care for（multiple-choice）
</h1>
<p>
<input type="checkbox" name="three" value="1" id="three1"><label for="three1">学历education</label> </p><p> 
<input type="checkbox" name="three" value="2" id="three2"><label for="three2">谈吐 behavior</label> </p><p>
<input type="checkbox" name="three" value="3" id="three3"><label for="three3">长相appearance</label>    </p><p>
<input type="checkbox" name="three" value="4" id="three4"><label for="three4">身材figure</label>   </p><p>
<input type="checkbox" name="three" value="5" id="three5"><label for="three5">身高height</label> </p><p>
<input type="checkbox" name="three" value="6" id="three6"><label for="three6">抽烟smoking</label>  </p><p>
<input type="checkbox" name="three" value="7" id="three7"><label for="three7">喝酒drink wine</label>  </p><p>
<input type="checkbox" name="three" value="8" id="three8"><label for="three8">出生地home place</label></p><p>
<input type="checkbox" name="three" value="9" id="three9"><label for="three9">消费观consumption view</label></p><p>
<input type="checkbox" name="three" value="10" id="three10"><label for="three10">价值观values</label></p><p>
<input type="checkbox" name="three" value="11" id="three11"><label for="three11">夜生活nightlife</label>  </p><p>
<input type="checkbox" name="three" value="12" id="three12"><label for="three12">国家/种族national/race </label></p><p>
<input type="checkbox" name="three" value="13" id="three13"><label for="three13">经济状况economy condition</label>  </p><p>
<input type="checkbox" name="three" value="14" id="three14"><label for="three14">家庭背景family background </label>   </p><p>
<input type="checkbox" name="three" value="15" id="three15"><label for="three15">家务能力housework ability</label></p><p>
<input type="checkbox" name="three" value="16" id="three16"><label for="three16">婚恋经历love and marriage experience</label></p><p> 
<input type="checkbox" name="three" value="17" id="three17"><label for="three17">有关系密切的异性朋友have close heterosexual friends</label></p><p>   
<input type="checkbox" name="three" value="18" id="three18"><label for="three18">其他others </label>             
</p>
</div>
<div class="list">
<h1>
4.您的恋爱次数How many EXs do you have
</h1>
<p>
<input type="checkbox" name="four" value="1" id="four1"><label for="four1">0次</label> </p><p> 
<input type="checkbox" name="four" value="2" id="four2"><label for="four2">1-2次 </label> </p><p> 
<input type="checkbox" name="four" value="3" id="four3"><label for="four3">3-5次 </label> </p><p> 
<input type="checkbox" name="four" value="4" id="four4"><label for="four4">5次以上more than 5</label>
</p>
</div>
<div class="list">
<h1>
5.你是否抽烟How often do you smoke ？     
</h1>
<p>
<input type="checkbox" name="five" value="1" id="five1"><label for="five1">天天抽everyday </label>  </p><p> 
<input type="checkbox" name="five" value="2" id="five2"><label for="five2">偶尔抽seldom</label>  </p><p> 
<input type="checkbox" name="five" value="3" id="five3"><label for="five3">不抽never</label>
</p> 
</div>
<div class="list">
<h1>
6.您是否喝酒How often do you drink？      
</h1>
<p>
<input type="checkbox" name="six" value="1" id="six1"><label for="six1">经常喝usually</label> </p><p>    
<input type="checkbox" name="six" value="2" id="six2"><label for="six2">偶尔喝seldom</label>   </p><p> 
<input type="checkbox" name="six" value="3" id="six3"><label for="six3">不喝never</label>
</p>
</div>
<div class="list">
<h1>
7.你会做菜吗Are you good at cooking？     
</h1>
<p>
<input type="checkbox" name="seven" value="1" id="seven1"><label for="seven1">很擅长pretty good at</label>  </p><p> 
<input type="checkbox" name="seven" value="2" id="seven2"><label for="seven2">基本会basically good at</label>  </p><p> 
<input type="checkbox" name="seven" value="3" id="seven3"><label for="seven3">只会一点点a little</label>  </p><p> 
<input type="checkbox" name="seven" value="4" id="seven4"><label for="seven4">不会can’t cooking</label>
</p>
</div>
<div class="list">
<h1>
8.您每天手机浏览最多的是哪方面的信息（多选）What kind of information do you read the most everyday?（multiple-choice）
</h1>
<p>
<input type="checkbox" name="eight" value="1" id="eight1"><label for="eight1">军事military</label>   </p><p> 
<input type="checkbox" name="eight" value="2" id="eight2"><label for="eight2">明星star </label> </p><p> 
<input type="checkbox" name="eight" value="3" id="eight3"><label for="eight3">财经finance</label>  </p><p> 
<input type="checkbox" name="eight" value="4" id="eight4"><label for="eight4">体育sports</label>  </p><p> 
<input type="checkbox" name="eight" value="5" id="eight5"><label for="eight5">科技technique</label>  </p><p> 
<input type="checkbox" name="eight" value="6" id="eight6"><label for="eight6">社会social</label>  </p><p> 
<input type="checkbox" name="eight" value="7" id="eight7"><label for="eight7">汽车cars</label> </p><p> 
<input type="checkbox" name="eight" value="8" id="eight8"><label for="eight8">房产house property</label>  </p><p>  
<input type="checkbox" name="eight" value="9" id="eight9"><label for="eight9">股票stock</label>  </p><p> 
<input type="checkbox" name="eight" value="10" id="eight10"><label for="eight10">促销sale information</label>  </p><p> 
<input type="checkbox" name="eight" value="11" id="eight11"><label for="eight11">装修fitment</label>  </p><p> 
<input type="checkbox" name="eight" value="12" id="eight12"><label for="eight12">教育education</label>   </p><p> 
<input type="checkbox" name="eight" value="13" id="eight13"><label for="eight13">美容hairdressing</label>   </p><p> 
<input type="checkbox" name="eight" value="14" id="eight14"><label for="eight14">服饰clothes</label>   </p><p> 
<input type="checkbox" name="eight" value="15" id="eight15"><label for="eight15">星座constellation</label>  </p><p> 
<input type="checkbox" name="eight" value="16" id="eight16"><label for="eight16">美食delicious food</label>  </p><p> 
<input type="checkbox" name="eight" value="17" id="eight17"><label for="eight17">旅游travel</label>   </p><p> 
<input type="checkbox" name="eight" value="18" id="eight18"><label for="eight18">小说fiction</label>  </p><p> 
<input type="checkbox" name="eight" value="19" id="eight19"><label for="eight19">减肥lose weight</label>  </p><p> 
<input type="checkbox" name="eight" value="20" id="eight20"><label for="eight20">健康health</label>   </p><p> 
<input type="checkbox" name="eight" value="21" id="eight21"><label for="eight21">网红web celebrity</label> </p><p> 
<input type="checkbox" name="eight" value="22" id="eight22"><label for="eight22">婚恋blind dating</label>  </p><p> 
<input type="checkbox" name="eight" value="23" id="eight23"><label for="eight23">其他others</label>                                                                     
</p>
</div>
<div class="list">
<h1>
9以下四类产品您最常选择的品牌the brand you are using or usually select（可多写can write many brands）
</h1>
<p>
<input type="checkbox" name="nine" value="1" id="nine1"><label for="nine1">护肤品 skin care product</label></p><p>                      
<input type="checkbox" name="nine" value="2" id="nine2"><label for="nine2">住宿酒店 hotel</label> </p><p>                                  
<input type="checkbox" name="nine" value="3" id="nine3"><label for="nine3">服饰 clothes（时装或运动或休闲fashion/sports/relaxation）</label></p><p>           
<input type="checkbox" name="nine" value="4" id="nine4"><label for="nine4">汽车 car</label>                                   
</p>
</div>
<div class="list">
<h1>
10.您的兴趣喜好（多选）Your hobbies（multiple-choice）
</h1>
<p>
<input type="checkbox" name="ten" value="1" id="ten1"><label for="ten1">唱歌sing</label>     </p><p> 
<input type="checkbox" name="ten" value="2" id="ten2"><label for="ten2">听歌listen to music </label>   </p><p> 
<input type="checkbox" name="ten" value="3" id="ten3"><label for="ten3">阅读read</label>  </p><p> 
<input type="checkbox" name="ten" value="4" id="ten4"><label for="ten4">购物shopping</label>  </p><p> 
<input type="checkbox" name="ten" value="5" id="ten5"><label for="ten5">棋牌chess</label>    </p><p> 
<input type="checkbox" name="ten" value="6" id="ten6"><label for="ten6">旅游travel</label>    </p><p> 
<input type="checkbox" name="ten" value="7" id="ten7"><label for="ten7">摄影photography</label>  </p><p> 
<input type="checkbox" name="ten" value="8" id="ten8"><label for="ten8">跳舞dance</label>  </p><p> 
<input type="checkbox" name="ten" value="9" id="ten9"><label for="ten9">自拍selfie</label>   </p><p> 
<input type="checkbox" name="ten" value="10" id="ten10"><label for="ten10">聊天chat</label>    </p><p> 
<input type="checkbox" name="ten" value="11" id="ten11"><label for="ten11">画画painting</label>   </p><p>  
<input type="checkbox" name="ten" value="12" id="ten12"><label for="ten12">话剧opera</label>    </p><p> 
<input type="checkbox" name="ten" value="13" id="ten13"><label for="ten13">表演perform</label>   </p><p>  
<input type="checkbox" name="ten" value="14" id="ten14"><label for="ten14">朗诵recite</label>  </p><p> 
<input type="checkbox" name="ten" value="15" id="ten15"><label for="ten15">运动 sports</label>  </p><p> 
<input type="checkbox" name="ten" value="16" id="ten16"><label for="ten16">健身fitness</label>    </p><p> 
<input type="checkbox" name="ten" value="17" id="ten17"><label for="ten17">乐器instrument</label>    </p><p> 
<input type="checkbox" name="ten" value="18" id="ten18"><label for="ten18">品酒wine-tasting</label>   </p><p> 
<input type="checkbox" name="ten" value="19" id="ten19"><label for="ten19">品茶tea-tasting</label>  </p><p> 
<input type="checkbox" name="ten" value="20" id="ten20"><label for="ten20">咖啡coffee</label>  </p><p> 
<input type="checkbox" name="ten" value="21" id="ten21"><label for="ten21">写作write</label>   </p><p> 
<input type="checkbox" name="ten" value="22" id="ten22"><label for="ten22">美食delicious food</label> </p><p> 
<input type="checkbox" name="ten" value="23" id="ten23"><label for="ten23">观展watch exhibition</label> </p><p> 
<input type="checkbox" name="ten" value="24" id="ten24"><label for="ten24">减肥lose weight</label>  </p><p> 
<input type="checkbox" name="ten" value="25" id="ten25"><label for="ten25">插花flower arrangement</label>  </p><p> 
<input type="checkbox" name="ten" value="26" id="ten26"><label for="ten26">电影film</label> </p><p> 
<input type="checkbox" name="ten" value="27" id="ten27"><label for="ten27">美食delicious food</label>  </p><p> 
<input type="checkbox" name="ten" value="28" id="ten28"><label for="ten28">烘焙bake</label>  </p><p> 
<input type="checkbox" name="ten" value="29" id="ten29"><label for="ten29">烹饪cook</label>  </p><p> 
<input type="checkbox" name="ten" value="30" id="ten30"><label for="ten30">泡吧  Internet bar</label>  </p><p> 
<input type="checkbox" name="ten" value="31" id="ten31"><label for="ten31">电子游戏 computer games</label>  </p><p>     
<input type="checkbox" name="ten" value="32" id="ten32"><label for="ten32">其他others</label>              
</p>
</div>
<div class="list">
<h1>
11.如果有心仪的对象，您会主动追求对方吗If you meet ideal mate, will you pursue him/her actively？
</h1>
<p>
<input type="checkbox" name="eleven" value="1" id="eleven1"><label for="eleven1">会yes</label>  </p><p> 
<input type="checkbox" name="eleven" value="2" id="eleven2"><label for="eleven2">基本不会maybe not</label> </p><p> 
<input type="checkbox" name="eleven" value="3" id="eleven3"><label for="eleven3">肯定不会absolutely not</label>  </p><p> 
<input type="checkbox" name="eleven" value="4" id="eleven4"><label for="eleven4">视情况而定it depends</label>
</p>
</div>
<div class="list">
<h1>
12.（女生答）您是否信奉男生应该主动些，先对自己表白（for woman）Do you think it is right that men should be more active and profess himself first?？
</h1>
<p>
<%if(gender.equals("男")){ %>
<input type="checkbox" name="twelve" value="1" disabled id="twelve1"><label for="twelve1">非常认可 I think so</label> </p><p> 
<input type="checkbox" name="twelve" value="2" disabled id="twelve2"><label for="twelve2">基本认可basically agree</label>  </p><p> 
<input type="checkbox" name="twelve" value="3" disabled id="twelve3"><label for="twelve3">不认可 I don’t think so</label> </p><p> 
<input type="checkbox" name="twelve" value="4" disabled id="twelve4"><label for="twelve4">视情况而定it depends</label>
<%}else{ %>
<input type="checkbox" name="twelve" value="1" id="twelve1"><label for="twelve1">非常认可 I think so</label> </p><p> 
<input type="checkbox" name="twelve" value="2" id="twelve2"><label for="twelve2">基本认可basically agree</label>  </p><p> 
<input type="checkbox" name="twelve" value="3" id="twelve3"><label for="twelve3">不认可 I don’t think so</label> </p><p> 
<input type="checkbox" name="twelve" value="4" id="twelve4"><label for="twelve4">视情况而定it depends</label>
<%} %>
</p>
</div>
<div class="list">
<h1>
 13. （男生答）您如何看待主动追求男生的女生（for man）What do you think about woman who pursues man？
 </h1>
 <p>
<%if(gender.equals("女")){ %>
<input type="checkbox" name="twelve" value="1" disabled id="twelve11"><label for="twelve11">很有勇气，这是勇敢追求幸福的表现 She is full of courage to pursue happiness.</label></p><p>    
<input type="checkbox" name="twelve" value="2" disabled id="twelve22"><label for="twelve22">可能不太矜持，最好还是不要woman would better not do so</label>  </p><p>   
<input type="checkbox" name="twelve" value="3" disabled id="twelve33"><label for="twelve33">视情况而定It depends</label>
<%}else{ %>
<input type="checkbox" name="twelve" value="1" id="twelve11"><label for="twelve11">很有勇气，这是勇敢追求幸福的表现 She is full of courage to pursue happiness.</label> </p><p>   
<input type="checkbox" name="twelve" value="2" id="twelve22"><label for="twelve22">可能不太矜持，最好还是不要woman would better not do so</label>    </p><p> 
<input type="checkbox" name="twelve" value="3" id="twelve33"><label for="twelve33">视情况而定It depends</label>
<%} %>
</p>
</div>
<div class="list">
<h1>
14请分配100分到爱情和事业中，体现它们在您心目中的地位In order to show the importance in your mind, please assign 100 scores into love and career：
</h1>
<p>
爱情Love  <input type="text" name="love" maxlength="3" value="0">分score       
</p>
<p>        
事业career <input type="text" name="career" maxlength="3" value="100">分score
</p>
</div>
<div class="list">
<h1>
15.您可以接受的最大年龄差区间The biggest age gap you can accept：
</h1>
<p>
<input type="checkbox" name="fifteen" value="1" id="fifteen1"><label for="fifteen1">1-3岁years</label>  </p><p> 
<input type="checkbox" name="fifteen" value="2" id="fifteen2"><label for="fifteen2">3-5岁years</label> </p><p> 
<input type="checkbox" name="fifteen" value="3" id="fifteen3"><label for="fifteen3">6-10岁years</label> </p><p> 
<input type="checkbox" name="fifteen" value="4" id="fifteen4"><label for="fifteen4">11-20岁years</label> </p><p> 
<input type="checkbox" name="fifteen" value="5" id="fifteen5"><label for="fifteen5">无所谓it doesn’t matter</label>
</p>
</div>
<div class="list">
<h1>
16.您可以接受的年龄差恋爱状态Love situation with age gap you can accept：
</h1>
<p>
<input type="checkbox" name="sixteen" value="1" id="sixteen1"><label for="sixteen1">姐弟恋elder women and younger man</label></p><p> 
<input type="checkbox" name="sixteen" value="2" id="sixteen2"><label for="sixteen2">老夫少妻elder man and younger women</label></p><p> 
<input type="checkbox" name="sixteen" value="3" id="sixteen3"><label for="sixteen3">无所谓it doesn’t matter</label>  </p><p> 
<input type="checkbox" name="sixteen" value="4" id="sixteen4"><label for="sixteen4">均不能接受neither of them</label>
</p>
</div>
<div class="list">
<h1>
17.您希望何时结婚When will you get married in your plan：
</h1>
<p>
<input type="checkbox" name="seventeen" value="1" id="seventeen1"><label for="seventeen1">越快越好as soon as possible</label> </p><p> 
<input type="checkbox" name="seventeen" value="2" id="seventeen2"><label for="seventeen2">半年内in half a year</label> </p><p> 
<input type="checkbox" name="seventeen" value="3" id="seventeen3"><label for="seventeen3">一年内in one year</label> </p><p> 
<input type="checkbox" name="seventeen" value="4" id="seventeen4"><label for="seventeen4">两年内in two years</label> </p><p> 
<input type="checkbox" name="seventeen" value="5" id="seventeen5"><label for="seventeen5">两年以上in more than two years</label>  </p><p> 
<input type="checkbox" name="seventeen" value="6" id="seventeen6"><label for="seventeen6">没想过not ever thought about it</label>  </p><p> 
<input type="checkbox" name="seventeen" value="7" id="seventeen7"><label for="seventeen7">视情况而定it depends</label>
</p>
</div>
<div class="list">
<h1>
18.您愿意成为线上招亲的嘉宾吗 Are you willing to have blind date through the Internet?（单选single-choice）？ 
</h1>
<P>
<input type="checkbox" name="eighteen" value="1" id="eighteen1"><label for="eighteen1">非常愿意Yes, I am.</label>   </p><p> 
<input type="checkbox" name="eighteen" value="2" id="eighteen2"><label for="eighteen2">如果保护隐私的话，可以尝试I can have a try if it can keep my privacy.</label>  </p><p> 
<input type="checkbox" name="eighteen" value="3" id="eighteen3"><label for="eighteen3">不愿意No, I’m not.</label>
 </P>
 </div>
<div class="list">
<h1>
19.您的自我描述（兴趣、性格、价值观、爱情观等）description about yourselfinterest, character, values, love views,etc.）
</h1>
<p id="nineteen">
<textarea name="nineteen"></textarea>
</p>
</div>
<div class="list">
<h1>
20.您对TA的期待（描述您心目中的理想伴侣：身高、职业、性格、婚恋史等）expectation about HE/SHEheight, occupation, character, be married or not, etc.）
</h1>
<p id="twenty">
<textarea name="twenty"></textarea>
</p>
</div>
</div>
 </form>
 <div id="footer">
<div  id="submit">
 <p>立 即 提 交</p>
 </div>
 <div  id="reset">
 <p>重 置</p>
 </div>
 </div>
  </body>
</html>
