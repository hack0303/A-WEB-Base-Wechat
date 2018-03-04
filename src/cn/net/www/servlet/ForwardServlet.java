package cn.net.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.www.bean.UserInformation;
import cn.net.www.dao.QueryDao;
import cn.net.www.unit.MessageBuilder;

public class ForwardServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action").trim();
		ServletContext sc = getServletContext();
		String url = "";
		int length=0;
		if(action.equals("adminlogin")){ 
			String msg=request.getParameter("msg");
			if(msg!=null){
				msg=URLDecoder.decode(msg,"utf-8");
				System.out.println("2:"+msg);
				
				request.setAttribute("msg",msg);
			}length=2;
			String[] str={"management",action};
			url=MessageBuilder.forwardURL(length,str);}
		else if(action.equals("adminmanage")){ 
				length=2;
				String[] str={"management","index"};
				url=MessageBuilder.forwardURL(length,str);}
		else if (action.equals("userlogin")) {
			String msg=request.getParameter("msg");
			if(msg!=null){
				msg=URLDecoder.decode(msg,"utf-8");
				request.setAttribute("msg",msg);}
			System.out.print(msg);
			String type = request.getParameter("type").trim();
			String[] string={"userinformation",type,"userlogin"};
			url=MessageBuilder.forwardURL(3, string);
		}
		else if (action.equals("wyzq")){
			length=2;
			String[] str={"main",action};
			url=MessageBuilder.forwardURL(length,str);
		}
		else if (action.equals("index"))
			url = "/index.jsp";
        else if(action.equals("register")){
        	String type=request.getParameter("type");
        	String step=request.getParameter("step");
        	length=4;
			String[] str={"userinformation",action,type,step};
			url=MessageBuilder.forwardURL(length,str);
        }
		else if (action.equals("wxyt")) {
			length=2;
			String[] str={"main",action};
			url=MessageBuilder.forwardURL(length,str);
			String to_phone = request.getParameter("to_phone").trim();
			request.setAttribute("to_phone", to_phone);
		} else if (action.equals("usershow")){
			length=3;
			String[] str={"userinformation","xunta",action};
			url=MessageBuilder.forwardURL(length,str);
		}
		else if (action.equals("usershowdetail")){
			length=3;
		String[] str={"userinformation","xunta",action};
		url=MessageBuilder.forwardURL(length,str);}
		else if(action.equals("enter")){
			String type=request.getParameter("type").trim();
			length=2;
			String[] str={action,action};
			request.setAttribute("type",type);
			url=MessageBuilder.forwardURL(length,str);
		}else if(action.equals("activities")){
			String type=request.getParameter("type");
			String nav=request.getParameter("nav");
			String page=request.getParameter("page");
			String to_phone=request.getParameter("to_phone");
			if(to_phone!=null) request.setAttribute("to_phone",to_phone);
			if(nav==null){
			length=2;
			String[] str=new String[2];
			request.setAttribute("type",type);
			str[0]="activities";
			str[1]=page;
			url=MessageBuilder.forwardURL(length, str);}else{
				length=3;
				String[] str={action,type,nav};
				url=MessageBuilder.forwardURL(length, str);
			}
			}else if(action.equals("error")){
				url="/error.jsp";
				String msg=request.getParameter("msg");
				request.setAttribute("msg",msg);
			}else if(action.equals("management")){
				String service=request.getParameter("service");
				String type=request.getParameter("type");
				String page=request.getParameter("page");
					length=4;
					String[] str={action,service,type,page};
					url=MessageBuilder.forwardURL(length, str);
			}else if(action.equals("welcome")){
				length=2;
				String[] str={"management","welcome"};
				url=MessageBuilder.forwardURL(length, str);
			}else if(action.equals("adminspan")){
				length=3;
				String[] str={"main","admin","span"};
				url=MessageBuilder.forwardURL(length, str);
			}else if(action.equals("detail")){
				String type=(String) request.getAttribute("type");
				String func=(String) request.getAttribute("func");
						length=4;
						String[] str={"management",action,type,func};
						url=MessageBuilder.forwardURL(length, str);
			}else if(action.equals("adminupload")){
				String type=request.getParameter("type");
				String service=request.getParameter("service");
				String phone=request.getParameter("phone");
				String image_url=request.getParameter("image_url");
				request.setAttribute("phone",phone);
				request.setAttribute("image_url",image_url);
				if(type.equals("xunta")){
					if(service.equals("change")){
						length=2;
						String[] str={"upload","uploadOne"};
						url=MessageBuilder.forwardURL(length, str);
					}
				}
			}else if(action.equals("result")){
				String page=request.getParameter("page");
				String msg="请耐心等待审核";
				String pageurl="index.jsp";
				if(page.equals("success")){
					msg="后台审核中,请耐心等待!";
				}else{
					msg="失败信息提示!";
				}
				request.setAttribute("pageurl",pageurl);
				request.setAttribute("msg",msg);
				url="/"+page+".jsp";
			}else if(action.equals("review")){
				String type=request.getParameter("type");
				String func=request.getParameter("func");
				String page=request.getParameter("page");
				length=5;
				String[] str={"management",action,type,func,page};
				url=MessageBuilder.forwardURL(length, str);
			}
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
