package cn.net.www.session;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class AdminSession implements HttpSessionBindingListener,Serializable{
private String account;//帐号
private int authority;//权限
private String type;//审核类型
private String lastlogin_time;//最近登录时间
public String getLastlogin_time() {
	return lastlogin_time;
}
public void setLastlogin_time(String lastlogin_time) {
	this.lastlogin_time = lastlogin_time;
}
private String action;//当前动作
private String where;//当前位置
private String want;//want to do
public AdminSession(String account, int authority, String type, String action,
		String where, String want) {
	super();
	this.account = account;
	this.authority = authority;
	this.type = type;
	this.action = action;
	this.where = where;
	this.want = want;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
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
public AdminSession() {
	// TODO Auto-generated constructor stub
}
public void valueBound(HttpSessionBindingEvent arg0) {
	// TODO Auto-generated method stub
System.out.println("绑定attribute");
	
}
public void valueUnbound(HttpSessionBindingEvent arg0) {
	// TODO Auto-generated method stub
System.out.println("解绑attribute");	
}
}
