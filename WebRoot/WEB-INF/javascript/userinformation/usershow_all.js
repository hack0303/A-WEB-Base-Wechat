$(document).ready(function(){
	$('#prop').hide();
$('#search_button').click(
			function(){
			$('form').eq(0).submit();}
			);
$('#title_select').change(function(){
	var value=$(this).val();
	$('#list').empty();
$.post("MyServlet",{"action":"changeShowState","state":value},function(xml,status,object){
	$(xml).find('table').find('item').each(function(index,ele){
	var	pmain_url=$(ele).find('main_url').text();
	var	pphone=$(ele).find('phone').text();
	var	pnumber=$(ele).find('number').text();
	var	pnickname=$(ele).find('nickname').text();
	var pintroduction=$(ele).find('introduction').text();
	//alert(pmain_url);
	$('#list').append("<table><tr>"+
    "<td colspan=\"2\">"+
    "<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
    "<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
     "</div><div class=\"nav_show\"><p>"+pintroduction+
    "</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
     "了解详情</a></div></div></td>"+
    "</tr><tr><td>编号:"+pnumber+"号</td>"+
	  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
	  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
	 + "</tr></table>");
	//	alert(xml);//文本文档
	//	alert(status);//状态
	//	alert(object);//对象
		});
	},"xml");
});
$('#title_select').change(function(){
	$.get("MyServlet",{"action":"findPagination"},function(data){
		var pagenow=1;
		var pagination=data;
		$('#spanuser ul li').eq(2).find('select').empty();
		for(var i=1;i<=pagination;i++){
			$('#spanuser ul li').eq(2).find('select').append("<option value=\""+i
					+"\">第"+i
					+"页</option>");
		}
		$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
		$('#spanuser ul li').eq(2).find('select').find('option').eq(pagenow-1).prop("selected",true);
	});
	});
//$('#list').on('click','table tr:nth-of-type(1) td',function(){
//	$(this).find('#image').toggleClass('change').next().toggleClass('change');
//	$.each($('.nav_show p'),function(i,content){
//		var contentcopy=$(content).text();
//	var	maxlength=20;
//		if(contentcopy.length>maxlength){
//			var contentcopy=contentcopy.substring(0,maxlength);
//			$('.nav_show p').eq(i).replaceWith("<p>"+contentcopy+"...</p>");
//		}	
//	});	
//});
$('#spanuser ul li').eq(0).click(function(){
	$('#list').empty();
$.post("MyServlet",{"action":"changePage","func":"first"},function(xml,status,object){
	$(xml).find('table').find('item').each(function(index,ele){
var	pmain_url=$(ele).find('main_url').text();
var	pphone=$(ele).find('phone').text();
var	pnumber=$(ele).find('number').text();
var	pnickname=$(ele).find('nickname').text();
var pintroduction=$(ele).find('introduction').text();
//alert(pmain_url);
$('#list').append("<table><tr>"+
"<td colspan=\"2\">"+
"<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
"<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
 "</div><div class=\"nav_show\"><p>"+pintroduction+
"</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
 "了解详情</a></div></div></td>"+
"</tr><tr><td>编号:"+pnumber+"号</td>"+
  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
 + "</tr></table>");
	});
},"xml");
});
$('#spanuser ul li').eq(0).click(function(){
$.get("MyServlet",{"action":"findPageNow"},function(data){
	$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
	$('#spanuser ul li').eq(2).find('select').find('option').eq(data-1).prop("selected",true);
});
});
$('#spanuser ul li').eq(1).click(function(){
	$('#list').empty();
	$.post("MyServlet",{"action":"changePage","func":"prev"},function(xml,status,object){
	$(xml).find('table').find('item').each(function(index,ele){
var	pmain_url=$(ele).find('main_url').text();
var	pphone=$(ele).find('phone').text();
var	pnumber=$(ele).find('number').text();
var	pnickname=$(ele).find('nickname').text();
var pintroduction=$(ele).find('introduction').text();
//alert(pmain_url);
$('#list').append("<table><tr>"+
"<td colspan=\"2\">"+
"<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
"<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
 "</div><div class=\"nav_show\"><p>"+pintroduction+
"</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
 "了解详情</a></div></div></td>"+
"</tr><tr><td>编号:"+pnumber+"号</td>"+
  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
 + "</tr></table>");
	});
},"xml");
});
$('#spanuser ul li').eq(1).click(function(){
$.get("MyServlet",{"action":"findPageNow"},function(data){
	$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
	$('#spanuser ul li').eq(2).find('select').find('option').eq(data-1).prop("selected",true);
});
});
$('#spanuser ul li').eq(2).find('select').change(function(){
	var value=$(this).val();
	$('#list').empty();
$.post("MyServlet",{"action":"changePage","func":"to","want":value},function(xml,status,object){
$(xml).find('table').find('item').each(function(index,ele){
var	pmain_url=$(ele).find('main_url').text();
var	pphone=$(ele).find('phone').text();
var	pnumber=$(ele).find('number').text();
var	pnickname=$(ele).find('nickname').text();
var pintroduction=$(ele).find('introduction').text();
//alert(pmain_url);
$('#list').append("<table><tr>"+
"<td colspan=\"2\">"+
"<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
"<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
 "</div><div class=\"nav_show\"><p>"+pintroduction+
"</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
 "了解详情</a></div></div></td>"+
"</tr><tr><td>编号:"+pnumber+"号</td>"+
  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
 + "</tr></table>");
	});
},"xml");
});
$('#spanuser ul li').eq(3).click(function(){
	$('#list').empty();
	$.post("MyServlet",{"action":"changePage","func":"next"},function(xml,status,object){
	$(xml).find('table').find('item').each(function(index,ele){
var	pmain_url=$(ele).find('main_url').text();
var	pphone=$(ele).find('phone').text();
var	pnumber=$(ele).find('number').text();
var	pnickname=$(ele).find('nickname').text();
var pintroduction=$(ele).find('introduction').text();
//alert(pmain_url);
$('#list').append("<table><tr>"+
"<td colspan=\"2\">"+
"<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
"<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
 "</div><div class=\"nav_show\"><p>"+pintroduction+
"</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
 "了解详情</a></div></div></td>"+
"</tr><tr><td>编号:"+pnumber+"号</td>"+
  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
 + "</tr></table>");
	});
},"xml");
});
$('#spanuser ul li').eq(3).click(function(){
$.get("MyServlet",{"action":"findPageNow"},function(data){
	$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
	$('#spanuser ul li').eq(2).find('select').find('option').eq(data-1).prop("selected",true);
});
});
$('#spanuser ul li').eq(4).click(function(){
	$('#list').empty();
	$.post("MyServlet",{"action":"changePage","func":"last"},function(xml,status,object){
	$(xml).find('table').find('item').each(function(index,ele){
var	pmain_url=$(ele).find('main_url').text();
var	pphone=$(ele).find('phone').text();
var	pnumber=$(ele).find('number').text();
var	pnickname=$(ele).find('nickname').text();
var pintroduction=$(ele).find('introduction').text();
//alert(pmain_url);
$('#list').append("<table><tr>"+
"<td colspan=\"2\">"+
"<div id=\"image\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
"<img width=\"100%\" height=\"100%\" src=\""+pmain_url+"\"></img></a>"+
 "</div><div class=\"nav_show\"><p>"+pintroduction+
"</p><div id=\"detail_button\"><a href=\"MyServlet?action=showDetail&phone="+pphone+"\">"+
 "了解详情</a></div></div></td>"+
"</tr><tr><td>编号:"+pnumber+"号</td>"+
  "</tr><tr><td>昵称:"+pnickname+"</td></tr><tr><td>"+
  "<a href=\"ForwardServlet?action=wxyt&to_phone="+pphone+"\"><input type=\"button\" value=\"立即约ta\"></a></td>"
 + "</tr></table>");
	});
},"xml");
});
$('#spanuser ul li').eq(4).click(function(){
$.get("MyServlet",{"action":"findPageNow"},function(data){
	$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
	$('#spanuser ul li').eq(2).find('select').find('option').eq(data-1).prop("selected",true);
});
});
$.get("MyServlet",{"action":"findPageNow"},function(data){
	$('#spanuser ul li').eq(2).find('select').find('option').prop("selected",false);
	$('#spanuser ul li').eq(2).find('select').find('option').eq(data-1).prop("selected",true);
});
});

