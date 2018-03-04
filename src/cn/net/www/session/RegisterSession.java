package cn.net.www.session;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class RegisterSession implements HttpSessionBindingListener,Serializable{
private String phone="";//手机号
private String type="";//注册类型
private String where="";//当前位置
private String want="";//want to do
public RegisterSession() {
	// TODO Auto-generated constructor stub
}
public RegisterSession(String phone, String type, String where, String want) {
	super();
	this.phone = phone;
	this.type = type;
	this.where = where;
	this.want = want;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getWhere() {
	return where;
}
public void setWhere(String where) {
	this.where = where;
}
public String getWant() {
	return want;
}
public void setWant(String want) {
	this.want = want;
}
@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	System.out.println("绑定元素");	
	}
@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	System.out.println("解绑元素");		
	}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "phone:"+this.phone+"type:"+this.type+"where:"+this.where+"want:"+this.want;
	}
}