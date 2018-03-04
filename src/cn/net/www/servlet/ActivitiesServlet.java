package cn.net.www.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.net.www.bean.YohooActivities;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.MethodInvoke;

public class ActivitiesServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doPost(request, response);}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodname = request.getParameter("action").trim();
		try {
			MethodInvoke.invokeMethod(this, methodname, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void join(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException, SQLException {
    	HttpSession session=request.getSession();
    	LoginSession ls=(LoginSession) session.getAttribute("ls");
    	String phone=ls.getPhone();
    	YohooActivities ya=(YohooActivities) new QueryDao().queryObjectByPhone(phone,YohooActivities.class);
    	PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
    	if(ya!=null){
    		out.print(1);
    		out.flush();
            out.close();
            return;
        }
    	String type=ls.getType();
        String id="";
        int flag=YohooActivities.JOIN;
        String creating_time=DateUnit.returnStringAboutPattern(DateUnit.PATTERN,new Date());
        ya=new YohooActivities(id, phone, flag, creating_time);
        boolean out_flag=new InsertDao().insertObject(ya, YohooActivities.class);
        response.setContentType("text/html;charset=utf-8");
        out.print(out_flag);
        out.flush();
        out.close();
    }
}
