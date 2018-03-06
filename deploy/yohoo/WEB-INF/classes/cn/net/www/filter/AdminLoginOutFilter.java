package cn.net.www.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.net.www.session.AdminSession;
import cn.net.www.session.LoginSession;
import cn.net.www.unit.MessageBuilder;

/**
 * Servlet Filter implementation class AdminLoginOut
 */
@WebFilter("/AdminLoginOut")
public class AdminLoginOutFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLoginOutFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session=((HttpServletRequest)request).getSession();
		AdminSession as=(AdminSession) session.getAttribute("as");
		if(as==null){
			response.setContentType("text/html;charset=utf-8;");
			PrintWriter out=response.getWriter();
		   out.println("<script>" +
					"alert('用户登录超时!已经下线!');" +
					"location.href='adminlogin.jsp';" +
					"</script>");
			out.flush();
			out.close();
			return;
			}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
