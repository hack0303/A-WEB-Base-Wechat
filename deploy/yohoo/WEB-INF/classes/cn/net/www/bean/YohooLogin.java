package cn.net.www.bean;

public class YohooLogin {
private String id;//标识
private String phone;//电话
private String lastlogin;//最后登录
private String last_faillogin;//最近失败登录
private String common_use_ip;//常用登录IP
private String faillogin_counter;//失败登录计数
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
public String getLastlogin() {
	return lastlogin;
}
public void setLastlogin(String lastlogin) {
	this.lastlogin = lastlogin;
}
public String getLast_faillogin() {
	return last_faillogin;
}
public void setLast_faillogin(String last_faillogin) {
	this.last_faillogin = last_faillogin;
}
public String getCommon_use_ip() {
	return common_use_ip;
}
public void setCommon_use_ip(String common_use_ip) {
	this.common_use_ip = common_use_ip;
}
public String getFaillogin_counter() {
	return faillogin_counter;
}
public void setFaillogin_counter(String faillogin_counter) {
	this.faillogin_counter = faillogin_counter;
}
public YohooLogin(String id, String phone, String lastlogin,
		String last_faillogin, String common_use_ip, String faillogin_counter) {
	super();
	this.id = id;
	this.phone = phone;
	this.lastlogin = lastlogin;
	this.last_faillogin = last_faillogin;
	this.common_use_ip = common_use_ip;
	this.faillogin_counter = faillogin_counter;
}
public YohooLogin() {
	// TODO Auto-generated constructor stub
}

}
