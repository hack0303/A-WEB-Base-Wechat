package cn.net.www.bean;

public class SmsBean {
private String id;//id
private String phone;//手机后
private String approach;//用途,如果是寻Ta，按对应的Flag对应
private int flag;//标志
private String send_time;//发送时间
public static final int SEND_FAIL=0;//失败
public static final int SEND_SUCCESS=1;//成功
public SmsBean(String id, String phone, String approach, int flag,
		String send_time) {
	super();
	this.id = id;
	this.phone = phone;
	this.approach = approach;
	this.flag = flag;
	this.send_time = send_time;
}
public SmsBean() {
	// TODO Auto-generated constructor stub
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
public String getApproach() {
	return approach;
}
public void setApproach(String approach) {
	this.approach = approach;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getSend_time() {
	return send_time;
}
public void setSend_time(String send_time) {
	this.send_time = send_time;
}
public static int getSendFail() {
	return SEND_FAIL;
}
public static int getSendSuccess() {
	return SEND_SUCCESS;
}
}
