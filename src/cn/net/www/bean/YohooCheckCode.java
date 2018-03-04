package cn.net.www.bean;

import java.util.Date;

public class YohooCheckCode {
private String id;//编号
private String phone;//电话
private String checkcode;//验证码
private String get_time;//获取时间
public YohooCheckCode() {
	// TODO Auto-generated constructor stub
}
public YohooCheckCode(String id, String phone, String checkcode, String get_time) {
	super();
	this.id = id;
	this.phone = phone;
	this.checkcode = checkcode;
	this.get_time = get_time;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCheckcode() {
	return checkcode;
}
public void setCheckcode(String checkcode) {
	this.checkcode = checkcode;
}
public String getGet_time() {
	return get_time;
}
public void setGet_time(String get_time) {
	this.get_time = get_time;
}
}
