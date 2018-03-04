<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息问卷</title>
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
<script type="text/javascript" src="javascript/jquery.js"></script>
  <link rel="stylesheet" href="css/userinformation/register/ruiqu/three.css" type="text/css"></link></head>
  
  <body>
  <div id="title">
  <h1>
  <p> 
 调查问卷</p>
 <p>
 QUESTIONNAIRE 
 </p>
 </h1>
 </div>
  <div id="nav">
 <form action="MyServlet" method="post">
 <input type="hidden" name="action" value="register">
 <input type="hidden" name="type" value="ruiqu">
<input type="hidden" name="step" value="three">
<div id="item">
<h1>
1.您现在处于什么状态（多选）Which status are you in（multiple-choice）？
</h1><p>
<input type="checkbox" name="">筹备婚礼wedding arranging</p><p>  
<input type="checkbox" name="">恋爱中fall in love </p><p>  
<input type="checkbox" name="">失恋中be crossed in love  </p><p>
<input type="checkbox" name="">经常加班usually work overtime </p><p>
<input type="checkbox" name="">经常出差often on business  </p><p>
<input type="checkbox" name="">创业中starting up business   </p><p>
<input type="checkbox" name="">购车中in car purchase    </p><p>
<input type="checkbox" name="">购房中in house purchase  </p><p>
<input type="checkbox" name="">其他others       </p>          
</div>
<div id="item">
<h1>
2.您的个性标签（多选）Your character or feature（multiple-choice）：
</h1><p>
<input type="checkbox" name="">外向outgoing</p><p>  
<input type="checkbox" name="">内向diffidence  </p><p> 
<input type="checkbox" name="">有主见strong-minded  </p><p>  
<input type="checkbox" name="">随大流have little self opinions   </p><p>
<input type="checkbox" name="">传统traditional □执着stubborn </p><p>   
<input type="checkbox" name="">吃货delicious food lover   </p><p> 
<input type="checkbox" name="">热情warm-hearted  </p><p> 
<input type="checkbox" name="">怀旧reminiscence </p><p>
<input type="checkbox" name="">谨慎cautious  </p><p>
<input type="checkbox" name="">拘谨overcautious  </p><p>  
<input type="checkbox" name="">易纠结select-difficult </p><p>
<input type="checkbox" name="">购物狂shopaholic </p><p>
<input type="checkbox" name="">爱挑战adventurous </p><p> 
<input type="checkbox" name="">比较宅stay-at-home lover </p><p>
<input type="checkbox" name="">闲不住always keep yourself busy</p><p>
<input type="checkbox" name="">喜新厌旧love the new  </p><p>
<input type="checkbox" name="">追求品质pursuit of quality </p><p>
<input type="checkbox" name="">讲究实用pay attention to practicability   </p><p>
<input type="checkbox" name="">注重分享pay attention to sharing  </p><p>
<input type="checkbox" name="">精打细算economical </p><p>   
<input type="checkbox" name="">小资情调bourgeois sentiment  </p><p> 
<input type="checkbox" name="">童心未泯childlike   </p><p>
<input type="checkbox" name="">文艺青年artistic youth  </p><p>         
<input type="checkbox" name="">其他others   </p>               
</div>
<div id="item">
<h1>
3.您每天手机浏览最多的是哪方面的信息（多选）What kind of information do you read the most everyday?（multiple-choice）
</h1><p>
<input type="checkbox" name="">军事military   </p><p>
<input type="checkbox" name="">明星star  </p><p>
<input type="checkbox" name="">财经finance  </p><p>
<input type="checkbox" name="">体育sports  </p><p>
<input type="checkbox" name="">科技technique </p><p> 
<input type="checkbox" name="">社会social  </p><p>
<input type="checkbox" name="">汽车cars </p><p>
<input type="checkbox" name="">房产house property   </p><p>
<input type="checkbox" name="">股票stock   </p><p>   
<input type="checkbox" name="">促销sale information  </p><p>
<input type="checkbox" name="">装修fitment  </p><p>
<input type="checkbox" name="">教育education  </p><p>
<input type="checkbox" name="">美容hairdressing  </p><p> 
<input type="checkbox" name="">服饰clothes   </p><p>
<input type="checkbox" name="">星座constellation </p><p> 
<input type="checkbox" name="">美食delicious food  </p><p>
<input type="checkbox" name="">旅游travel   </p><p>
<input type="checkbox" name="">小说fiction  </p><p>
<input type="checkbox" name="">减肥lose weight  </p><p>
<input type="checkbox" name="">健康health   </p><p>
<input type="checkbox" name="">网红web celebrity </p><p>
<input type="checkbox" name="">母婴infant and mom  </p><p>  
<input type="checkbox" name="">其他others   </p>                                                                  
</div>
<div id="item">
<h1>
4.以下四类产品您最常选择的品牌有哪些the brand you are using or usually select：
</h1>
<p>
护肤品skin care product：      </p><p>                          
住宿酒店hotel：        </p><p>                                          
服饰clothes（时装或运动或休闲fashion/sports/relaxation）：  </p><p>                       
汽车car：                   </p>                 
</div>
<div id="item">
<h1>
5.您的兴趣喜好（多选）Your hobbies（multiple-choice）
</h1><p>
<input type="checkbox" name="">唱歌sing  </p><p>  
<input type="checkbox" name="">听歌listen to music   </p><p> 
<input type="checkbox" name="">阅读read  </p><p>
<input type="checkbox" name="">购物shopping </p><p> 
<input type="checkbox" name="">棋牌chess   </p><p> 
<input type="checkbox" name="">旅游travel  </p><p>  
<input type="checkbox" name="">摄影photography</p><p>  
<input type="checkbox" name="">跳舞dance </p><p> 
<input type="checkbox" name="">自拍selfie </p><p>  
<input type="checkbox" name="">聊天chat    </p><p>
<input type="checkbox" name="">画画painting </p><p>   
<input type="checkbox" name="">话剧opera   </p><p> 
<input type="checkbox" name="">表演perform   </p><p> 
<input type="checkbox" name="">朗诵recite  </p><p>
<input type="checkbox" name="">运动 sports   </p><p>
<input type="checkbox" name="">健身fitness    </p><p>
<input type="checkbox" name="">乐器instrument   </p><p> 
<input type="checkbox" name="">品酒wine-tasting  </p><p> 
<input type="checkbox" name="">品茶tea-tasting  </p><p>
<input type="checkbox" name="">咖啡coffee  </p><p>
<input type="checkbox" name="">写作write   </p><p>
<input type="checkbox" name="">美食delicious food </p><p>
<input type="checkbox" name="">观展watch exhibition  </p><p>
<input type="checkbox" name="">减肥lose weight  </p><p>
<input type="checkbox" name="">插花flower arrangement  </p><p>
<input type="checkbox" name="">电影film </p><p>
<input type="checkbox" name="">美食delicious food  </p><p>
<input type="checkbox" name="">烘焙bake  </p><p>
<input type="checkbox" name="">烹饪cook  </p><p>
<input type="checkbox" name="">其他others   </p>            
</div>
<div id="item">
<h1>
6.您经常看的综艺节目类型（多选）What kind of TV shows do you usually watch（multiple-choice）：  
</h1>
<p>
<input type="checkbox" name="">脱口秀talk show   </p><p>
<input type="checkbox" name="">游艺类travel     </p><p>  
<input type="checkbox" name="">求职类job hunting </p><p>     
<input type="checkbox" name="">挑战类adventure    </p><p> 
<input type="checkbox" name="">草根选秀talent show  </p><p>   
<input type="checkbox" name="">相亲交友blind date </p><p>
<input type="checkbox" name="">人物访谈interview   </p><p>  
<input type="checkbox" name="">益智竞技IQ competition </p><p>    
<input type="checkbox" name="">家庭伦理family ethic   </p><p>
<input type="checkbox" name="">明星真人秀stars reality show  </p><p> 
<input type="checkbox" name="">我都不感兴趣none</p><p>

</div>
<div id="item">
<h1>
7.根据您的喜好，您在哪方面拥有一技之长，并愿意与同城人分享经验？Which part are you good at, and you are willing to share the experience in it?
</h1>
</div>                                                                                                          
<div id="item">
<h1>
8.根据您的喜好，您最希望参加的活动内容On the basis of your hobbies, what kind of activities do you want to join in most:
</h1>
（1）                        （2）                         （3）                             
</div>
<div id="item">
<h1>
8.您是否参与过其他单位组织的兴趣活动Have you ever taken part in hobby activities organized by other organizations？
</h1><p>
<input type="checkbox" name="">没有参与过never    </p><p>
<input type="checkbox" name="">偶尔参与occasionally    </p><p> 
<input type="checkbox" name="">经常参与 usually，比如such as            单位组织的activity organized by             活动organization.
</p>
</div>
<div id="item">
<h1>
9.您希望通过活动交到什么样的朋友What kind of friends do you want to make through the activity（多选multiple-choice）？
</h1>
<p>
<input type="checkbox" name="">牌友card partner  </p><p>
<input type="checkbox" name="">歌友 </p><p>
<input type="checkbox" name="">棋友chess partner </p><p>  
<input type="checkbox" name="">舞伴dance partner  </p><p>
<input type="checkbox" name="">驴友bicycle partner </p><p>  
<input type="checkbox" name="">球友sports partner   </p><p>
<input type="checkbox" name="">摄友photography partner  </p><p> 
<input type="checkbox" name="">粉丝fans（欣赏自己的人people who admire you）</p><p>
<input type="checkbox" name="">其他others    </p>                        
</div>
<div id="item">
<h1>
10.您是否愿意在星乐趴文化市集上展示、售卖家中收藏或自己的作品Are you willing to display or sell your collection and your own works？
</h1><p>
<input type="checkbox" name="">非常愿意yes, of course ，比如such as  </p><p>            
<input type="checkbox" name="">暂时没有藏品/作品 have no collection and works  </p><p>
<input type="checkbox" name="">不愿意 no </p>
</div>
<div id="item">
<h1>
11.您能经常参加活动的空闲时间（多选）Your free time you can join in the activity usually （multiple-choice）？
</h1><p>
<input type="checkbox" name="">平时下午workday afternoon </p><p>  
<input type="checkbox" name="">平时晚上workday evening  </p><p>
<input type="checkbox" name="">周末上午 weekend morning   </p><p>
<input type="checkbox" name="">周末下午weekend afternoon </p><p>
<input type="checkbox" name="">周末晚上weekend evening   </p><p>
<input type="checkbox" name="">说不准hard to say  </p><p>
<input type="checkbox" name="">很难有时间hard to have free time </p><p>
<input type="checkbox" name="">都可以anytime   </p>
</div>
<div id="item">
<h1>
12.您是否愿意成为所在兴趣班的班长Are you willing to be the monitor of the hobby class？
</h1>
<input type="checkbox" name="">很愿意，yes, of course 比如such as                        
<input type="checkbox" name="">不愿意no 
<input type="checkbox" name="">无所谓not to matter 
<input type="checkbox" name="">视情况而定it depends    
</div>
<div id="item">
<h1>
13.目前您最需要获取哪方面的生活资讯What kind of life information do you want most？
</h1>
</div>
<div id="item">
<h1>                                                                                
14.您希望通过星乐趴获得哪方面的需求匹配（多选）Which part do you need through Starring Lovely Party（multiple-choice）?
</h1><p>
<input type="checkbox" name="">兴趣交流interest communication </p><p>       
<input type="checkbox" name="">扩展社交expand social communication    </p><p>    
<input type="checkbox" name="">结帮成对matchmaking  </p><p>
<input type="checkbox" name="">辨析产品differentiate and analyze products    </p><p>
<input type="checkbox" name="">资讯分享share information     </p><p> 
<input type="checkbox" name="">情感沟通emotion communication</p><p>
<input type="checkbox" name="">其他others      </p>
</div>
1.您目前的状态（多选）Which living status are you in（multiple-choice）?
□无聊 bored
□经常找乐子 look for entertainment frequently
□经常加班usually work overtime  
□经常出差often on business 
□创业中starting up business  
□忙家（购房或装修）busy house（buy or decorate）
□带孩子 take the kids
□其他others                   

2.您的性格标签（多选）Your character or feature（multiple-choice）？
□活泼outgoing   
□安静quiet     
□直爽frank  
□寡言wordless 
□张扬 flaunt   
□内敛 restraining 
□独立independent  
□依赖dependent	
□其他others                       

3.您每天手机浏览最多的是哪方面的信息（填写3个）What kind of information do you read the most everyday（write 3 items）？
                                                                           


4.以下四类产品您最常选择的品牌the brand you are using or usually select（可多写can write many brands）：
护肤品skin care product：                                
住宿酒店hotel：                                                  
服饰clothes（时装或运动或休闲fashion/sports/relaxation）：            
汽车car：                                    


5.您的兴趣爱好（填写3个）Your hobbies（write 3 items）?
                                                                            


6.您是否参与过其他单位组织的兴趣活动Have you ever taken part in hobby activities organized by other organizations？
□没有参与过never
□偶尔参与occasionally
□经常参与 usually，
比如such as                                                     

7.您经常看的综艺节目类型（多选）What kind of TV shows do you usually watch （可multiple-choice）：
□求职类job hunting	
□相亲交友blind date
□人物访谈interview	
□益智竞技IQ competition
□家庭伦理family ethic	
□明星真人秀stars reality show
□我都不感兴趣none

8.您希望通过活动交到什么样的朋友（多选）What kind of friends do you want to make through the activity （multiple-choice）？
□牌友card partner	
□棋友chess partner
□歌友sing partner
□舞伴dance partner
□驴友bicycle partner
□球友sports partner
□摄友photography partner
□粉丝fans（欣赏自己的人people who admire you）
□其他others                                               


9.您能经常参加活动的空闲时间（多选）Your free time you can join in the activity usually? （multiple-choice）？
□工作日下午workday afternoon 
□工作日晚上workday evening 
□周末上午 weekend morning 
□周末下午weekend afternoon 
□周末晚上weekend evening 
□说不准hard to say 
□很难有时间hard to have free time 
□都可以anytime

10.您是否愿意成为所在兴趣班的班长Are you willing to be the monitor of the hobby class？
□很愿意，yes, of course
班级项目：
□不愿意no 
□无所谓not to matter 
□视情况而定it depends


11.您希望通过星乐趴获得哪方面的需求匹配（多选）Which part do you need through Starring Lovely Party（multiple-choice）？
□兴趣交流interest communication
□扩展社交expand social communication
□结帮成对matchmaking
□辨析产品differentiate and analyze products
□资讯分享share information
□情感沟通emotion communication

12.根据您的喜好，您最希望参加的活动内容（限3项）
On the basis of your hobbies, what kind of activities do you want to join in most（3 kinds）:
（1）

（2）

（3）

13.您是否愿意在星乐趴文化市集上展示、售卖家中收藏或自己的作品

Are you willing to display or sell your collection and your own works？

□非常愿意 （ yes	of course ）
作品（works）：



□暂时没有藏品/作品 have no collection and work


□不愿意 no


14.目前您最需要获取哪方面的生活资讯 

What kind of life information do you want most？
</form>    
</div>                  
  </body>
</html>
