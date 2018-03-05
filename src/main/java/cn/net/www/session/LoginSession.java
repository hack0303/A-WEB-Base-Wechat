package cn.net.www.session;

import java.io.Serializable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginSession implements HttpSessionBindingListener,Serializable {
private String number;//会员编号
private String phone;//会员手机号
private String type;//会员类型
private String authority;//会员权限
private String gender;//会员性别
private String nickname;//昵称
private String main_url;//祝图片
private String where;//会员当前位置
private String want;//会员want to do
private int yu_flag;//yohoouser_flag
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
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
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
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
public LoginSession(String number, String phone, String type, String authority,
		String gender, String where, String want) {
	super();
	this.number = number;
	this.phone = phone;
	this.type = type;
	this.authority = authority;
	this.gender = gender;
	this.where = where;
	this.want = want;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getMain_url() {
	return main_url;
}
public void setMain_url(String main_url) {
	this.main_url = main_url;
}
public int getYu_flag() {
	return yu_flag;
}
public void setYu_flag(int yu_flag) {
	this.yu_flag = yu_flag;
}
public LoginSession() {
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
