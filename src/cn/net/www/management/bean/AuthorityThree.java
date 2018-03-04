package cn.net.www.management.bean;

public class AuthorityThree {
private int id;//主键
private String phone;//相关人物号码
private int adminid;//相关管理员主键ID
private String notify_or_not;//通知有无
private String notify_time;//通知时间
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getAdminid() {
	return adminid;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}
public String getNotify_or_not() {
	return notify_or_not;
}
public void setNotify_or_not(String notify_or_not) {
	this.notify_or_not = notify_or_not;
}
public String getNotify_time() {
	return notify_time;
}
public void setNotify_time(String notify_time) {
	this.notify_time = notify_time;
}
public AuthorityThree(int id, String phone, int adminid, String notify_or_not,
		String notify_time) {
	super();
	this.id = id;
	this.phone = phone;
	this.adminid = adminid;
	this.notify_or_not = notify_or_not;
	this.notify_time = notify_time;
}
public AuthorityThree() {
	// TODO Auto-generated constructor stub
}
}
