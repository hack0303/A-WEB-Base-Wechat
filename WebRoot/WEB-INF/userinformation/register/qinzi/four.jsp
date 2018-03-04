<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>信息问卷</title>
<link rel="stylesheet" href="css/default.css" type="text/css"></link>
  <link rel="stylesheet" href="css/userinformation/register/qinzi/four.css" type="text/css"></link>
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/userinformation/register/qinzi/four.js"></script></head>
<body>
 <form action="MyServlet" method="post">
 <input type="hidden" name="action" value="register">
 <input type="hidden" name="type" value="qinzi">
<input type="hidden" name="step" value="four">
<div id="title">
<h1>
<p>
调查问卷
</p>
<p>QUESTIONNAIRE</p>
</h1>
</div>
<div id="nav">
<div id="item">
<h1>1.您平时经常带宝贝去哪里（多选）Where do you usually take your baby go? （multiple-choice）</h1>
<p><input name="babe_1" type="checkbox" value="1">游乐场Amusement Park</p><p>	
<input name="babe_1" type="checkbox" value="2">商场Shopping Mall</p><p>
<input name="babe_1" type="checkbox" value="3">图书馆Library	</p><p>
<input name="babe_1" type="checkbox" value="4">科技馆Science and technology museum</p><p>
<input name="babe_1" type="checkbox" value="5">培训机构Training Institution</p><p>
<input name="babe_1" type="checkbox" value="6">其他Others</p>                                        
<h1>2.您每天和宝贝相处大概有多长时间（单选）How many hours do you get along with your baby everyday? （single-choice）
</h1><p>
<input name="babe_2" type="checkbox" value="1">半小时half an hour</p><p>	
<input name="babe_2" type="checkbox" value="2">1-2小时/hours	</p><p>	
<input name="babe_2" type="checkbox" value="3">3-5小时/hours</p><p>	
<input name="babe_2" type="checkbox" value="4">5-8小时/hours	</p><p>	
<input name="babe_2" type="checkbox" value="5">全天候all day long</p>

<h1>3.您带宝贝每年外出旅游的频率（单选）How often do you take your baby to travel every year? （single-choice）
</h1><p>
<input name="babe_3" type="checkbox" value="1">1-2次/times	</p><p>	
<input name="babe_3" type="checkbox" value="2">3-5次/times</p><p>		
<input name="babe_3" type="checkbox" value="3">5次以上more than 5 times</p><p>	
<input name="babe_3" type="checkbox" value="4">几乎没有almost none</p>

<h1>4.您最关心宝贝哪方面问题（多选）Which part of baby do you concern about most? （multiple-choice）
</h1><p>
<input name="babe_4" type="checkbox" value="1"> 人身安全personal security	</p><p>	
<input name="babe_4" type="checkbox" value="2"> 发育状况physical development</p><p>	
<input name="babe_4" type="checkbox" value="3">学习状态study state	</p><p>	
<input name="babe_4" type="checkbox" value="4">生活习惯life habits	</p><p>	
<input name="babe_4" type="checkbox" value="5">性格发展 character development	</p><p>	
<input name="babe_4" type="checkbox" value="6">其他others</p><p>	

<h1>5.您经常通过什么渠道来增长宝贝见识（限选3个）What do you usually do to expand your baby’s horizon？（no more than 3 choices）
</h1><p>
<input name="babe_5" type="checkbox" value="1">风光旅游travel	</p><p>
<input name="babe_5" type="checkbox" value="1">展览exhibition	</p><p>
<input name="babe_5" type="checkbox" value="1">书籍books</p><p>
<input name="babe_5" type="checkbox" value="1">家庭教育family education</p><p>	
<input name="babe_5" type="checkbox" value="1">社会实践social practice</p><p>
<input name="babe_5" type="checkbox" value="1">传播媒介mass media（电视、广播、网络等television,broadcast,network etc.）</p><p>
<input name="babe_5" type="checkbox" value="1">培训机构training institution </p><p>
<input name="babe_5" type="checkbox" value="1">其他 others</p><p>
<h1>6.目前，宝贝最让您头疼的是什么问题（多选）Nowadays，which part of baby do you worry about most？（multiple-choice）
</h1><p>
<input name="babe_6" type="checkbox" value="1">肥胖obesity</p><p>
<input name="babe_6" type="checkbox" value="1">身高height</p><p>
<input name="babe_6" type="checkbox" value="1">厌食asitia</p><p>
<input name="babe_6" type="checkbox" value="1">贪睡snooze</p><p>
<input name="babe_6" type="checkbox" value="1">调皮naughty</p><p>
<input name="babe_6" type="checkbox" value="1">胆怯timid</p><p>
<input name="babe_6" type="checkbox" value="1">任性self-willed</p><p>
<input name="babe_6" type="checkbox" value="1">其他</p>

<h1>7.您最希望带宝贝参加培养哪方面素质的活动（多选）Which kind of activities do you want your baby to take part in? （multiple-choice）
</h1><p>
<input name="babe_7" type="checkbox" value="1">智商 intelligence quotient	</p><p>
<input name="babe_7" type="checkbox" value="1">情商 emotional quotient</p><p>
<input name="babe_7" type="checkbox" value="1">体育 physical education	</p><p>
<input name="babe_7" type="checkbox" value="1">艺术文化art and culture	</p><p>
<input name="babe_7" type="checkbox" value="1">心理psychology	</p><p>
<input name="babe_7" type="checkbox" value="1">动手能力handling ability</p><p>
<input name="babe_7" type="checkbox" value="1">语言表达 language expression	</p><p>
<input name="babe_7" type="checkbox" value="1">其他others</p>

<h1>8.宝贝已接受或正在接受的课外培训项目有哪些（多选）What are the training projects your baby have ever learned or is learning?（multiple-choice）
</h1><p>
<input name="babe_8" type="checkbox" value="1">武术kung fu</p><p>
<input name="babe_8" type="checkbox" value="1">舞蹈dance</p><p>
<input name="babe_8" type="checkbox" value="1">音乐 music</p><p>
<input name="babe_8" type="checkbox" value="1">美术painting</p><p>
<input name="babe_8" type="checkbox" value="1">外语foreign language </p><p>
<input name="babe_8" type="checkbox" value="1">奥数Olympics math</p><p>
<input name="babe_8" type="checkbox" value="1">运动 sports</p><p>
<input name="babe_8" type="checkbox" value="1">阅读与写作reading and writing</p><p>
<input name="babe_8" type="checkbox" value="1">其他others          </p>                  

<h1>9.您希望通过星乐趴获得宝贝哪方面的需求匹配（多选）Which part do you want your baby to get？（multiple-choice）
</h1><p>
<input name="babe_9" type="checkbox" value="1">健康发育grow healthily	</p><p>
<input name="babe_9" type="checkbox" value="1">基础学习fundamental learning</p>





<div id="title"><p>关于您的About you</p></div>
<h1>1.您的生活/工作状态（多选）Which living status are you in（multiple-choice）?
</h1><p>
<input name="you_1" type="checkbox" value="1">无聊 bored</p><p>
<input name="you_1" type="checkbox" value="1">经常找乐子 look for entertainment frequently</p><p>
<input name="you_1" type="checkbox" value="1">经常加班usually work overtime  </p><p>
<input name="you_1" type="checkbox" value="1">经常出差often on business </p><p>
<input name="you_1" type="checkbox" value="1">创业中starting up business  </p><p>
<input name="you_1" type="checkbox" value="1">忙家（购房或装修）busy house（buy or decorate）</p><p>
<input name="you_1" type="checkbox" value="1">带孩子 take the kids</p><p>
<input name="you_1" type="checkbox" value="1">其他others       </p>            

<h1>2.您的性格标签（多选）Your character or feature（multiple-choice）？
</h1><p>
<input name="you_2" type="checkbox" value="1">活泼outgoing   </p><p>
<input name="you_2" type="checkbox" value="1">安静quiet   </p><p>  
<input name="you_2" type="checkbox" value="1">直爽frank  </p><p>
<input name="you_2" type="checkbox" value="1">寡言wordless </p><p>
<input name="you_2" type="checkbox" value="1">张扬 flaunt   </p><p>
<input name="you_2" type="checkbox" value="1">内敛 restraining </p><p>
<input name="you_2" type="checkbox" value="1">独立independent </p><p> 
<input name="you_2" type="checkbox" value="1">依赖dependent	</p><p>
<input name="you_2" type="checkbox" value="1">其他others    </p>                   

<h1>3.您每天手机浏览最多的是哪方面的信息（填写3个）What kind of information do you read the most everyday?（write 3 items）
  </h1>        
  <p><input type="text" name="you_3"></p>                                                                 
<h1>4.您的兴趣爱好（填写3个）Your hobbies（write 3 items）?</h1>
     <p><input type="text" name="you_4"></p>                                                                       

<h1>5.您经常看的综艺节目类型（多选）What kind of TV shows do you usually watch （multiple-choice）：
</h1><p><input name="you_5" type="checkbox" value="1">求职类job hunting	</p><p>
<input name="you_5" type="checkbox" value="1">相亲交友blind date</p><p>
<input name="you_5" type="checkbox" value="1">人物访谈interview	</p><p>
<input name="you_5" type="checkbox" value="1">益智竞技IQ competition</p><p>
<input name="you_5" type="checkbox" value="1">家庭伦理family ethic	</p><p>
<input name="you_5" type="checkbox" value="1">明星真人秀stars reality show</p><p>
<input name="you_5" type="checkbox" value="1">我都不感兴趣none</p>

<h1>6.您是否参与过其他单位组织的兴趣活动Have you ever taken part in hobby activities organized by other organizations？
</h1><p>
<input name="you_6" type="checkbox" value="1">没有参与过never</p><p>
<input name="you_6" type="checkbox" value="1">偶尔参与occasionally</p><p>
<input name="you_6" type="checkbox" value="1">经常参与 usually，</p><p>
<input name="you_6" type="checkbox" value="1">比如such as    </p>                                                 

<h1>7.您能经常参加亲子活动的空闲时间（多选）Your free time you can join in the Parent-child activity usually？（multiple-choice）
</h1><p>
<input name="you_7" type="checkbox" value="1">工作日下午workday afternoon </p><p>
<input name="you_7" type="checkbox" value="1">工作日晚上workday evening </p><p>
<input name="you_7" type="checkbox" value="1">周末上午 weekend morning </p><p>
<input name="you_7" type="checkbox" value="1" >周末下午weekend afternoon </p><p>
<input name="you_7" type="checkbox" value="1">周末晚上weekend evening </p><p>
<input name="you_7" type="checkbox" value="1">说不准hard to say </p><p>
<input name="you_7" type="checkbox" value="1">很难有时间hard to have free time </p><p>
<input name="you_7" type="checkbox" value="1">都可以anytime</p>
</div>                                                                              
</form>
<div id="footer">
<div id="submit">
立 即 提 交
</div>
</div>
</body>
</html>