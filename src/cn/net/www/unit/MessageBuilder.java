package cn.net.www.unit;

import java.text.MessageFormat;

public class MessageBuilder {
private static String url="";
private MessageFormat mf;
private static final String FROM_ONE="MyServlet";
private static final String FROM_TWO="ForwardServlet";
private static final String FROM_THREE="AdminServlet";
private static final String PATTERN_ONE="AdminServlet";
private static final String PATTERN_TWO="AdminServlet";
private static final String PATTERN_THREE="AdminServlet";
private static final String PATTERN_FOUR="AdminServlet";
/**
 * 路径直接跳转模版跳转模版
 */
private static final String PATTERN_WEB_INF_ONE="/WEB-INF/{0}.jsp";
private static final String PATTERN_WEB_INF_TWO="/WEB-INF/{0}/{1}.jsp";
private static final String PATTERN_WEB_INF_THREE="/WEB-INF/{0}/{1}/{2}.jsp";
private static final String PATTERN_WEB_INF_FOUR="/WEB-INF/{0}/{1}/{2}/{3}.jsp";
private static final String PATTERN_WEB_INF_FIVE="/WEB-INF/{0}/{1}/{2}/{3}/{4}.jsp";
private String target="";
private String archor="";
private String action="";
private String[] params;
private static final String SQL_SELECT="select {0} from {1}";
private static final String SQL_UPDATE="update {0} set {1}";
private static final String SQL_INSERT="insert into {0} value {1}";
private static final String SQL_DELETE="delete {0} from {1}";
public MessageBuilder() {
	super();
}

public String getUrl() {
	return url;
}

public String returnUrl(String type,String[] str){
	String pattern="/";
	if(type.equals("userlogin"))
	pattern="/ForwardServlet?action={0}&type={1}";
	mf=new MessageFormat(pattern);
	url=mf.format(str);
	return url;
}
/*类型
 * 模版编号
 * 参数
 * */
public static String forwardURL(int x,String[] str){
		switch(x){
		case 1:{
			url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_ONE,(Object[])str);
			break;
		}
		case 2:{
			url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_TWO,(Object[])str);
			break;
		}
		case 3:{
			url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_THREE,(Object[])str);
			break;
		}
		case 4:{
			url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_FOUR,(Object[])str);
			break;}
		case 5:{
			url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_FIVE,(Object[])str);
			break;
		}
		default:{
			url="/error.jsp";
			break;
		}	
	}
	return url;
}
public static String sendRedirectURL(int x,String[] str){
	switch(x){
	case 1:{
		url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_ONE,(Object[])str);
		break;
	}
	case 2:{
		url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_TWO,(Object[])str);
		break;
	}
	case 3:{
		url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_THREE,(Object[])str);
		break;
	}
	case 4:{
		url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_FOUR,(Object[])str);
		break;}
	case 5:{
		url=MessageFormat.format(MessageBuilder.PATTERN_WEB_INF_FIVE,(Object[])str);
		break;
	}
	default:{
		url="/error.jsp";
		break;
	}	
}
url=url.substring(1);
return url;
}
public String buildURL(String from,String to,String[] str){
	if(from.equalsIgnoreCase(MessageBuilder.FROM_ONE)){
		
		
	}else
	if(from.equalsIgnoreCase(MessageBuilder.FROM_TWO)){
		
		
	}else
	if(from.equalsIgnoreCase(MessageBuilder.FROM_THREE)){
		
		
	}
	return url;
}
public static String buildSQL(String type,String[] str){
	String pattern="";
	if(type.equals("select")){
	pattern=MessageBuilder.SQL_SELECT;
	}else if(type.equals("insert")){
		pattern=MessageBuilder.SQL_INSERT;	
	}else if(type.equals("update")){
		pattern=MessageBuilder.SQL_UPDATE;
	}else if(type.equals("delete")){
		pattern=MessageBuilder.SQL_DELETE;
	}
	url=MessageFormat.format(pattern, (Object[])str);
	return url;
}
}
