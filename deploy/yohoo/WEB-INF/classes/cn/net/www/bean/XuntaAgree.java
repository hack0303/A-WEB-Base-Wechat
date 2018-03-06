package cn.net.www.bean;

public class XuntaAgree {
private String id;//约单ID
private String agree;//同意与否
private String content;//内容
private String creating_time;//创建时间
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAgree() {
	return agree;
}
public void setAgree(String agree) {
	this.agree = agree;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCreating_time() {
	return creating_time;
}
public void setCreating_time(String creating_time) {
	this.creating_time = creating_time;
}
public XuntaAgree(String id, String agree, String content, String creating_time) {
	super();
	this.id = id;
	this.agree = agree;
	this.content = content;
	this.creating_time = creating_time;
}

}
