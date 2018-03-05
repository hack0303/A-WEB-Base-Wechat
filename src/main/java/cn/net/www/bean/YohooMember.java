package cn.net.www.bean;

public class YohooMember {
private String phone;//会员手机号
private String number;//会员编码
private String creating_time;//创建时间
public String getCreating_time() {
	return creating_time;
}
public void setCreating_time(String creating_time) {
	this.creating_time = creating_time;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public YohooMember(String phone, String number,String creating_time) {
	super();
	this.phone = phone;
	this.number = number;
	this.creating_time=creating_time;
}
public YohooMember() {
	// TODO Auto-generated constructor stub
}
}
