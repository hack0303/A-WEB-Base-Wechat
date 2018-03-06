package cn.net.www.bean;

public class XuntaDeclare {
private int id;//主键
private String date_number;//约单编号
private String phone;//电话号码
private String type;//身份(约方,被约方)
private String content;//内容
private String star;//星星
private String agree;//同意与否
private String declare_time;//评价时间

public XuntaDeclare(int id, String date_number, String phone, String type,
		String content, String star,String agree, String declare_time) {
	super();
	this.id = id;
	this.date_number = date_number;
	this.phone = phone;
	this.type = type;
	this.content = content;
	this.star = star;
	this.agree=agree;
	this.declare_time = declare_time;
}
public String getAgree() {
	return agree;
}
public void setAgree(String agree) {
	this.agree = agree;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDate_number() {
	return date_number;
}
public void setDate_number(String date_number) {
	this.date_number = date_number;
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
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getStar() {
	return star;
}
public void setStar(String star) {
	this.star = star;
}
public String getDeclare_time() {
	return declare_time;
}
public void setDeclare_time(String declare_time){
	this.declare_time = declare_time;
}
public XuntaDeclare() {
	// TODO Auto-generated constructor stub
}

}
