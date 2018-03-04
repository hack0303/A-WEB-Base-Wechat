package cn.net.www.bean;

public class QinziBabe {
private String id;//主键
private String key_phone;//主表对应号码
private String name;//姓名
private String nickname;//昵称
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
private String gender;//性别
private String birthday;//生日
private String school;//学校
private String grade;//年级
private String onlychild;//是否独生子女
private String hobby;//爱好
private String speciality;//特长
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getKey_phone() {
	return key_phone;
}
public void setKey_phone(String key_phone) {
	this.key_phone = key_phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getOnlychild() {
	return onlychild;
}
public void setOnlychild(String onlychild) {
	this.onlychild = onlychild;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getSpeciality() {
	return speciality;
}
public void setSpeciality(String speciality) {
	this.speciality = speciality;
}
public QinziBabe(String id, String key_phone, String name, String nickname, String gender,
		String birthday, String school, String grade, String onlychild,
		String hobby, String speciality) {
	super();
	this.id = id;
	this.key_phone = key_phone;
	this.name = name;
	this.nickname=nickname;
	this.gender = gender;
	this.birthday = birthday;
	this.school = school;
	this.grade = grade;
	this.onlychild = onlychild;
	this.hobby = hobby;
	this.speciality = speciality;
}
public QinziBabe(String id, String name, String nickname,String gender,
		String birthday, String school, String grade, String onlychild,
		String hobby, String speciality) {
	super();
	this.id = id;
	this.name = name;
	this.nickname=nickname;
	this.gender = gender;
	this.birthday = birthday;
	this.school = school;
	this.grade = grade;
	this.onlychild = onlychild;
	this.hobby = hobby;
	this.speciality = speciality;
}
public QinziBabe() {
	// TODO Auto-generated constructor stub
}
}
