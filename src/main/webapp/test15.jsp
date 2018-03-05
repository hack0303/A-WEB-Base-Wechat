<%@page import="cn.net.www.dao.UpdateDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.File"%>
<%@page import="cn.net.www.unit.PropertiesUnit"%>
<%@page import="cn.net.www.dao.QueryDao"%>
<%@page import="cn.net.www.bean.UserImage"%>
<%@page import="cn.net.www.unit.ReturnNumber"%>
<%@page import="java.util.*"%>
<%@page import="cn.net.www.unit.DateUnit"%>
<%
for(int i=0;i<10;i++){
out.println("--------------------------");
out.println(new Date().getTime());
}%>
<%
UserImage ui1=new UserImage();
ui1.setId(1);
UserImage ui2=new UserImage();
ui2.setId(2);
UserImage ui3=new UserImage();
ui3.setId(3);
List<UserImage> list=new ArrayList<UserImage>();
list.add(ui1);
list.add(ui2);
list.add(ui3);
for(UserImage ui:list){
out.println(ui.getId());
}
%>
<%
List<UserImage> listx=new ArrayList<UserImage>();
UserImage uix=new UserImage();
uix.setId(1);
listx.add(ui1);

uix.setId(2);
listx.add(ui1);

uix.setId(3);
listx.add(ui1);

for(UserImage ui:listx){
out.println(ui.getId());
}
%>
<%
List<UserImage> list2=new QueryDao().queryImage("13304040403");
for(UserImage ui:list2){
out.println(ui.getId());
out.println(ui.getImage());
}
%>
<%out.println(request.getRealPath("alidayu.properties"));
	String str=Thread.currentThread().getContextClassLoader().getResource("/").getFile();
	str=URLDecoder.decode(str,"utf-8");
	out.println(str);
	String str1=this.getClass().getClassLoader().getResource("/").getPath();
	str1=URLDecoder.decode(str1,"utf-8");
	out.println(str1);
	String str2=this.getClass().getResource("/").getPath();
	str2=URLDecoder.decode(str2,"utf-8");
	out.println(str2);
File f=new File(str,"alidayu.properties");

out.println(f.exists());
out.println(f.getPath());
out.println(new File("alidayu.properties").getAbsolutePath());
out.println(new File("alidayu.properties").getCanonicalPath());
out.println(request.getRequestURI());
out.println(request.getServletPath());%>
<%
//String str3=Thread.currentThread().getContextClassLoader().getResource("/").getFile();
//	str3=URLDecoder.decode(str3,"utf-8");
	
//PropertiesUnit pu=new PropertiesUnit(str3+"alidayu.properties");
PropertiesUnit pu=new PropertiesUnit("alidayu.properties");
out.print(pu.getValue("appkey"));
out.print(pu.getValue("secret"));
out.print(pu.getValue("SmsfreesignName"));
out.print(pu.getValue("SmsTemplateCode"));
%>
<%UpdateDao ud=new UpdateDao();
System.out.print(ud.updateWYZQPass(1, 1, "18806298620"));
 %>