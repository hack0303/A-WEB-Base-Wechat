package cn.net.www.transaction;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.UserInformation;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.YohooCheckCode;
import cn.net.www.bean.YohooLogin;
import cn.net.www.bean.YohooMember;
import cn.net.www.bean.YohooUser;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;
import cn.net.www.session.RegisterSession;
import cn.net.www.unit.DateUnit;

public class Login {

    public static void login(ServletContext sc,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	HttpSession session=null;
		RegisterSession rs=null;
		String action="";
		String type="xunta";
		String step="";
    	//type=request.getParameter("type");
    	String phone=request.getParameter("phone");
    	QueryDao qd=new QueryDao();
    	int flag=qd.queryFlagByPhone(phone,type);
    	String checkcode=request.getParameter("checkcode");
    	String url="";
    	String pattern="yyyy-MM-dd HH:mm:ss";
    		switch(flag){
    		case YohooUser.REGISTER_ONE:{
    			session=request.getSession();
            	rs=(RegisterSession) session.getAttribute("rs");
            	if(rs==null){
            		rs=new RegisterSession();
            		rs.setPhone(phone);
            		rs.setType(type);
            		rs.setWhere("1");
            		rs.setWant("2");
                    session.setAttribute("rs",rs);
                    session.setAttribute("test","测试");
            		action="register";
        			//type;
        			step="two";
        			url="ForwardServlet?action="+action+"&type="+type+"&step="+step;
        			response.sendRedirect(url);
            	}else{
            		if(rs.getType().equals("xunta")&&rs.getWhere().equals("1")&&rs.getWant().equals("2")){
            			action="register";
            			//type;
            			step="two";
            			url="ForwardServlet?action="+action+"&type="+type+"&step="+step;
            			response.sendRedirect(url);
            		}
            	}
    			return;
    		}
    		case YohooUser.REGISTER_TWO:{
    			return;
    		}
    		case YohooUser.REGISTER_THREE:{
    			return;
    		}case YohooUser.REGISTER_FOUR:{
              response.sendRedirect("ForwardServlet?action=result&page=success");
    			return;
    		}
    		case YohooUser.REGISTER_PASS:{
    			url="MyServlet?action=show&type=first";
    		   break;
    		}
    		case 0:{
    			PrintWriter out=response.getWriter();
    			response.setContentType("text/html");
    			out.print("登录失败!");
    			out.flush();
    			out.close();
    			return;
    		}//如果数据库没有这号人,就失败
    		default:{
    		url="MyServlet?action=show&type=first";
    		break;}
    		}
    		String checkcode_copy="";
    		Object ob=new QueryDao().queryObject(phone, YohooCheckCode.class); 
    	    YohooCheckCode ycc=(YohooCheckCode)ob;
    	    Date login_time=new Date();
    	    if(ycc==null){
    	    	String msg="请先获取验证码";
        		msg=URLEncoder.encode(msg, "utf-8");
        		url="ForwardServlet?action=userlogin&type="+type+"&msg="+msg;
        		response.sendRedirect(url);
    	    	return;	
    	    }else{
    	    	checkcode_copy=ycc.getCheckcode();
        	    String get_time=ycc.getGet_time();
        	    Date checkcodetime=DateUnit.returnDateByString(pattern,get_time);
        	    long differ=login_time.getTime()-checkcodetime.getTime();
        	    long checkcode_differ=24*60*60*1000;//规定时间
        	    if(differ>checkcode_differ){
        	    	String msg="验证码过期,请重新获取";
            		msg=URLEncoder.encode(msg,"utf-8");
            		url="ForwardServlet?action=userlogin&type="+type+"&msg="+msg;
            		response.sendRedirect(url);
            		return;
        	    }
    	    }
    	    YohooLogin yl=(YohooLogin)new QueryDao().queryObject(phone, YohooLogin.class);
    	    int counter=0;
    	    long interval=30*60;//半小时间隔内的出错都会被记录
    	    int error_count=10;//达到10次,帐号将被冻结
    		String lastfaillogin=null;
	    	Date faillogin=null;
	    	long fail_differ=0;
    	    String lastlogin=null;
	    	if(yl!=null){
    	    	counter=Integer.parseInt(yl.getFaillogin_counter());
    	    	lastlogin=yl.getLastlogin();	
    	    }//过滤掉为空的情况,空指针会异常,默认前提是不为空，为空情况后续if直接跳过。
    	    if(counter==error_count){
    	    	lastfaillogin=yl.getLast_faillogin();
    	    	faillogin=DateUnit.returnDateByString(pattern,lastfaillogin);
    	    	fail_differ=(login_time.getTime()-faillogin.getTime())/1000;
    	    	long forbid_time=2*60*60;//禁止时间
    	    	if(fail_differ<=forbid_time){
    	    	String msg="帐号存在风险,冻结操作2小时,如有异常,请联系管理员解决";
        		msg=URLEncoder.encode(msg, "utf-8");
        		url="ForwardServlet?action=userlogin&type="+type+"&msg="+msg;
        		response.setCharacterEncoding("utf-8");
        		response.sendRedirect(url);
    	    	return;
    	    	}else{
    	    		counter-=2;
    	    		yl.setFaillogin_counter(String.valueOf(counter));
    	    		new UpdateDao().updateObject(yl, YohooLogin.class);
    	    	}//逐渐减少失败次数。
    	    }
    		if(checkcode_copy.equals(checkcode)){
    	    if(yl==null){
    	    	yl=new YohooLogin();
    	    	yl.setPhone(phone);//记录手机号
    	    	yl.setLastlogin(DateUnit.returnStringAboutPattern(pattern,login_time));//记录登录时间
    	    	yl.setFaillogin_counter("0");//初始化计数器
                new InsertDao().insertObject(yl, YohooLogin.class);    	    
    	    }else{
    	    	counter=Integer.parseInt(yl.getFaillogin_counter());
    	    	Date lastlogin_object=null;
    	    	if(lastlogin==null) lastlogin_object=login_time;
    	    	else lastlogin_object=DateUnit.returnDateByString(pattern,lastlogin);
    	    	long success_differ=(login_time.getTime()-lastlogin_object.getTime())/1000;//两次成功登录之间的时间
    	    	long success_interval=1*60*60;//1小时
    	    	/*
    	    	 * 8,7,6之间是正常区间,任何成功登录都可以减失败次数。默认5以下都必须是间隔1小时以上相隔的成功登录才可以,长间隔限制。
    	    	 * */
    	    	switch(counter){
    	    	case 9:{
    	    		counter-=1;
    	    		break;
    	    	}
    	    	case 8:{
    	    		counter-=1;
    	    	    break;
    	    	}
    	    	case 7:{
    	    		counter-=1;
    	    	break;
    	    	} 
    	    	case 6:{
    	    		counter-=1;
    	    	break;
    	    	}
    	    	default:{
    	    		if(success_differ>=success_interval){
    	    		counter-=1;	
    	    		}
    	    		if(counter<=0) counter=0;
    	        break;
    	    	}
    	    	}
    	    	yl.setLastlogin(DateUnit.returnStringAboutPattern(pattern,login_time));
    	    	yl.setFaillogin_counter(String.valueOf(counter));
                new UpdateDao().updateObject(yl, YohooLogin.class); 
    	    }
    		XuntaUser xtu=qd.queryUserInformation(phone);
    		String gender=xtu.getGender();
    		YohooMember ym=(YohooMember)qd.queryObjectByPhone(phone, YohooMember.class);
    		if(ym==null){
    			throw new Exception("该用户会员编号信息不存在");
    		}
    		String number=ym.getNumber();
    		session=request.getSession();
    		LoginSession ls=new LoginSession();
    		ls.setAuthority("0");
    		ls.setGender(gender);
    		ls.setPhone(phone);
    		ls.setNumber(number);
    		ls.setNickname(xtu.getNickname());
    		ls.setMain_url(xtu.getMain_url());
    		ls.setYu_flag(xtu.getFlag());
    		session.setAttribute("ls",ls);
    		response.sendRedirect(url); 
    		}else{
    			if(yl==null){
        	    	yl=new YohooLogin();
        	    	yl.setPhone(phone);
        	    	yl.setLast_faillogin(DateUnit.returnStringAboutPattern(pattern,login_time));
                    yl.setFaillogin_counter("1");
        	    	new InsertDao().insertObject(yl, YohooLogin.class);    	    
        	    }else{
        	    	lastfaillogin=yl.getLast_faillogin();
        	    	if(lastfaillogin==null){
        	    		faillogin=login_time;
        	    	}else{      
        	    	faillogin=DateUnit.returnDateByString(pattern,lastfaillogin);
        	    	}
        	    	fail_differ=(login_time.getTime()-faillogin.getTime())/1000;
        	    	if(fail_differ<=interval) counter++;//低于半小时内的任何重复失败都会进行累加。防止批量试错。
        	        yl.setFaillogin_counter(String.valueOf(counter));
        	    	yl.setLast_faillogin(DateUnit.returnStringAboutPattern(pattern,login_time));
                    new UpdateDao().updateObject(yl,YohooLogin.class); 
        	    }
    		String msg="登录失败,验证码错误!!";
    		msg=URLEncoder.encode(msg, "utf-8");
    		url="ForwardServlet?action=userlogin&type="+type+"&msg="+msg;
    		System.out.println("直接编码"+response.encodeURL(url));
    		response.sendRedirect(url);
    		}
    	
    }
}
