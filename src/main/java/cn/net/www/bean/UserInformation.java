package cn.net.www.bean;

import java.util.List;

public class UserInformation {
	private int id;// 用户信息主键
	private int keyid;// 用户主键
	private String introduction;// 用户介绍
	private String condition;// 用户择偶要求
	private String state;// 期
	private String nickname;// 昵称
	private int number;// 编号
	private int flag;// 是否招亲
	private String main_url;// 封面图片链接
	private String sex;// 性别
	private String birth_date;// 出生年月
	private double height;// 身高
	private double weight;// 体重
	private String profession;// 职业
	private int date_flag;// 约会状态封装
	private String education;// 学历
	private String date_number;//约单编号
	

	public String getDate_number() {
		return date_number;
	}

	public void setDate_number(String date_number) {
		this.date_number = date_number;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getDate_flag() {
		return date_flag;
	}

	public void setDate_flag(int date_flag) {
		this.date_flag = date_flag;
	}

	public void setWoYue(int to_id, String nickname, String main_url,
			int date_flag) {
		this.keyid = to_id;
		this.nickname = nickname;
		this.main_url = main_url;
		this.date_flag = date_flag;
	}

	public void setYueWo(int from_id, String nickname, String main_url,
			int date_flag) {
		this.keyid = from_id;
		this.nickname = nickname;
		this.main_url = main_url;
		this.date_flag = date_flag;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	private String marital_status;// 婚姻状况

	public String getMain_url() {
		return main_url;
	}

	public void setMain_url(String main_url) {
		this.main_url = main_url;
	}

	private List<UserImage> list;// 图片

	public List<UserImage> getList() {
		return list;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setList(List<UserImage> list) {
		this.list = list;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKeyid() {
		return keyid;
	}

	public void setKeyid(int keyid) {
		this.keyid = keyid;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
