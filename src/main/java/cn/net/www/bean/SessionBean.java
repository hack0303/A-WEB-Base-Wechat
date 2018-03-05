package cn.net.www.bean;

import java.io.Serializable;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * @author daxian
 * @date : 2016-8-8 下午6:22:14
 */  
public class SessionBean implements Serializable, HttpSessionActivationListener,HttpSessionBindingListener{
    private String name;
    public SessionBean(String name){
    	this.name=name;
    }
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(name+"反序列化");
   
	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
System.out.println(name+"被序列化");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"被绑定");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"被解除绑定");
		
	}
	@Override
	public String toString() {
		return "SessionBean [name=" + name + "]";
	}
}
