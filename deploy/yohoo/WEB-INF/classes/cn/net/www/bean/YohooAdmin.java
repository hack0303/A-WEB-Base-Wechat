package cn.net.www.bean;

import java.io.Serializable;

public class YohooAdmin implements Serializable{
private String id;//主键
private String account;//帐号
private String password;//密码
private int authority;//权限
private String creating_time;//创建时间
private String lastlogin_time;//最近一次登录时间
public YohooAdmin() {
	super();
	// TODO Auto-generated constructor stub
}
public YohooAdmin(String id, String account, String password, int authority,
		String creating_time, String lastlogin_time) {
	super();
	this.id = id;
	this.account = account;
	this.password = password;
	this.authority = authority;
	this.creating_time = creating_time;
	this.lastlogin_time = lastlogin_time;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
public String getCreating_time() {
	return creating_time;
}
public void setCreating_time(String creating_time) {
	this.creating_time = creating_time;
}
public String getLastlogin_time() {
	return lastlogin_time;
}
public void setLastlogin_time(String lastlogin_time) {
	this.lastlogin_time = lastlogin_time;
}

}
