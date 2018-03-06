package cn.net.www.bean;

import java.util.List;

public class XuntaUser extends YohooUser {
	private String nativeplace;
	private String work_organization;
	private double height;
	private double weight;
	private String salary;
	private String onlychild;
	private String marriage;
	private String havebaby;
	private String education;
	private String nickname;
	private String main_url;
	private int date_flag;
	private String introduction;
	private String condition;
	private String number;
	private List<UserImage> list;
    private String date_number;
    private String date_time;
    private String age;
	public XuntaUser() {
		super();
	}

	public XuntaUser(String nativeplace, String work_organization,
			double height, double weight, String salary, String onlychild,
			String marriage, String havebaby, String education,
			String nickname, String main_url, int date_flag,
			String introduction, String condition, String number,
			List<UserImage> list, String state) {
		super();
		this.nativeplace = nativeplace;
		this.work_organization = work_organization;
		this.height = height;
		this.weight = weight;
		this.salary = salary;
		this.onlychild = onlychild;
		this.marriage = marriage;
		this.havebaby = havebaby;
		this.education = education;
		this.nickname = nickname;
		this.main_url = main_url;
		this.date_flag = date_flag;
		this.introduction = introduction;
		this.condition = condition;
		this.number = number;
		this.list = list;
		this.state = state;
	}
    
	public XuntaUser(int id, String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, String type, int postcode, int flag) {
		super(id, name, gender, birthday, id_type, id_number, occupation, phone, email,
				address, type, postcode, flag);
		// TODO Auto-generated constructor stub
	}

	public XuntaUser(int id, String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, String type, int postcode, int flag,
			String nativeplace, String work_organization, double height,
			double weight, String salary, String onlychild, String marriage,
			String havebaby, String education, String nickname,
			String main_url, int date_flag, String introduction,
			String condition, String number, List<UserImage> list, String state) {
		super(id, name, gender, birthday, id_type, id_number, occupation,
				phone, email, address, type, postcode, flag);
		this.nativeplace = nativeplace;
		this.work_organization = work_organization;
		this.height = height;
		this.weight = weight;
		this.salary = salary;
		this.onlychild = onlychild;
		this.marriage = marriage;
		this.havebaby = havebaby;
		this.education = education;
		this.nickname = nickname;
		this.main_url = main_url;
		this.date_flag = date_flag;
		this.introduction = introduction;
		this.condition = condition;
		this.number = number;
		this.list = list;
		this.state = state;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMain_url() {
		return main_url;
	}

	public void setMain_url(String main_url) {
		this.main_url = main_url;
	}

	public int getDate_flag() {
		return date_flag;
	}

	public void setDate_flag(int date_flag) {
		this.date_flag = date_flag;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getWork_organization() {
		return work_organization;
	}

	public void setWork_organization(String work_organization) {
		this.work_organization = work_organization;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = Double.parseDouble(height);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = Double.parseDouble(weight);
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getOnlychild() {
		return onlychild;
	}

	public void setOnlychild(String onlychild) {
		this.onlychild = onlychild;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getHavebaby() {
		return havebaby;
	}

	public void setHavebaby(String havebaby) {
		this.havebaby = havebaby;
	}

	public List<UserImage> getList() {
		return list;
	}

	public void setList(List<UserImage> list) {
		this.list = list;
	}

	public void setWoYue(String phone, String nickname, String main_url,
			int date_flag,String date_number,String date_time) {
		// TODO Auto-generated method stub
		this.setPhone(phone);
		this.nickname = nickname;
		this.main_url = main_url;
		this.setDate_flag(date_flag);
		this.setDate_number(date_number);
		this.setDate_time(date_time);
	}
	public void setYueWo(String phone, String nickname, String main_url,
			int date_flag,String date_number,String date_time,String education,String age,String occupation) {
		// TODO Auto-generated method stub
		this.setPhone(phone);
		this.nickname = nickname;
		this.main_url = main_url;
		this.setDate_flag(date_flag);
		this.setDate_number(date_number);
		this.setDate_time(date_time);
		this.setEducation(education);
		this.setAge(age);
		this.setOccupation(occupation);
	}
	public String getDate_number() {
		return date_number;
	}

	public void setDate_number(String date_number) {
		this.date_number = date_number;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "XuntaUser [nativeplace=" + nativeplace + ", work_organization="
				+ work_organization + ", height=" + height + ", weight="
				+ weight + ", salary=" + salary + ", onlychild=" + onlychild
				+ ", marriage=" + marriage + ", havebaby=" + havebaby
				+ ", education=" + education + ", nickname=" + nickname
				+ ", main_url=" + main_url + ", date_flag=" + date_flag
				+ ", introduction=" + introduction + ", condition=" + condition
				+ ", number=" + number + ", list=" + list + ", state=" + state
				+ "]";
	}

}
