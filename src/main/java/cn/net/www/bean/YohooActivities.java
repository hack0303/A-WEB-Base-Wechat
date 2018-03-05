package cn.net.www.bean;

public class YohooActivities {
private String id;//主键
private String phone;//手机号
private int flag;//标志
private String creating_time;//参加时间
public static final int JOIN=1;//加入
public static final int QUIT=0;//退出
public static final int PASS=2;//通过
public static final int NO_PASS=3;//没通过
public YohooActivities() {
	// TODO Auto-generated constructor stub
}
public YohooActivities(String id, String phone, int flag,
		String creating_time) {
	super();
	this.id = id;
	this.phone = phone;
	this.flag = flag;
	this.creating_time = creating_time;
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getCreating_time() {
	return creating_time;
}
public void setCreating_time(String creating_time) {
	this.creating_time = creating_time;
}

}
