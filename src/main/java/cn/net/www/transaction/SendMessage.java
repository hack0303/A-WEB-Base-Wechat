package cn.net.www.transaction;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooCheckCode;
import cn.net.www.dao.QueryDao;
import cn.net.www.session.RegisterSession;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.MathUnit;
import cn.net.www.unit.PropertiesUnit;
import cn.net.www.unit.TaoBaoUnit;

public class SendMessage {
	public static void sendMessage(ServletContext servletcontext,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String type="";
		String url="";
		String pattern="yyyy-MM-dd HH:mm:ss";
		String id=null;
		long difference=24*60*60*1000;//间隔1天
		String transaction="";
		QueryDao qd=new QueryDao();
		String phone = request.getParameter("phone");
		type=request.getParameter("type");
		String checkcode=MathUnit.returnRandom(6,10);
		request.setAttribute("checkcode",checkcode);
		if(!type.equals("xunta")) return;
		int flag_int=qd.queryFlagByPhone(phone, type);
		boolean flag = false;
		switch(flag_int){
		case 0:{
			flag=false;
			break;
		}
        case 1:{
			flag=false;
			break;
		}
        case 2:{
			flag=false;
			break;
        }
        case 3:{
			flag=false;
			break;
       }
        case 4:{

			flag=false;
			break;
        }
        case 6:{
        	flag=false;
        	out.print("注册审核未通过,不可以发送短信");
			return;	
        }
        default:{
        	flag=true;
        	break;
        }
		}
		PropertiesUnit  pu=new PropertiesUnit(PropertiesUnit.ALIDAYU);
		String aurl=pu.getValue("url");
		String appkey=pu.getValue("appkey");
		String secret=pu.getValue("secret");
		String smsfreesignName=pu.getValue("SmsfreesignName");
		String smsTemplateCode=pu.getValue("SmsTemplateCode");
		TaoBaoUnit tbu = new TaoBaoUnit(aurl, appkey, secret, smsfreesignName, smsTemplateCode);
		YohooCheckCode ycc=null;
		try{
		if (flag) {
	       ycc=(YohooCheckCode)qd.queryObject(phone,YohooCheckCode.class);
			if(ycc==null){
			request.setAttribute("transaction","insert");
			String newtime=DateUnit.returnStringAboutPattern(pattern,new Date());
			ycc=new YohooCheckCode(id,phone, checkcode, newtime);
			request.setAttribute("ycc",ycc);
			tbu.sendMessage(request);
			out.print("发送成功!");
			}else{
				String oldtime=ycc.getGet_time();
				Date old_date=DateUnit.returnDateByString(pattern,oldtime);
				Date new_date=new Date();
			long differtime=new_date.getTime()-old_date.getTime();//毫秒为单位
			if(differtime>=difference){
				request.setAttribute("transaction","update");
				String time=DateUnit.returnStringAboutPattern(pattern,new_date);
				ycc.setGet_time(time);
				ycc.setCheckcode(checkcode);
				request.setAttribute("ycc",ycc);
				tbu.sendMessage(request);	
				out.print("发送成功!");
			}else{
				out.print("之前获取过了,请检查短信信息");
			}
			}
		} else {
			if(flag_int==0)
			out.print("发送失败!该帐号并没有注册");
			else if(flag_int==4){
				out.print("请耐心等待审核!审核通过方可登录");	
			}else{
			out.print("请输入任意6位验证码,继续完成注册!");
			}
		}
		}finally{
			out.close();
		}
	}
}
