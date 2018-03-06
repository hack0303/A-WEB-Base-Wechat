package cn.net.www.bean;

import cn.net.www.unit.MethodInvoke;

public class YohooUser {
	private int id;
	private String name;
	private String gender;
	private String birthday;
	private String id_type;
	private String id_number;
	private String occupation;
	private String phone;
	private String email;
	private String address;
	private String type;
	private int postcode;
	private int flag;
	private String creating_time;
	public YohooUser(int id, String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, String type, int postcode, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.id_type = id_type;
		this.id_number = id_number;
		this.occupation = occupation;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.type = type;
		this.postcode = postcode;
		this.flag = flag;
	}

	public YohooUser() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

/*
	 * yohoo_user中的flag,0,1,2,3,4都为对应注册页面完成后的标志.
	 * 5为审核通过,6为审核不通过。
	 * 7,权限被管理员通过
	 * 8,权限被管理员限制
	 * 9,我要招亲申请审核。10为我要招亲通过审核。11我要招亲不通过审核
	 * xunta相关
	 */
   public final static int REGISTER_ONE=1;
   public final static int REGISTER_TWO=2;
   public final static int REGISTER_THREE=3;
   public final static int REGISTER_FOUR=4;
   public final static int REGISTER_PASS=5;
   public final static int REGISTER_NOT_PASS=6;
   public final static int AUTHORITY_PASS=7;
   public final static int AUTHORITY_FORBID=8;
   public final static int WYZQ_REQUEST_START=9;
   public  final static int WYZQ_REQUEST_PASS=10;
   public final static int WYZQ_REQUEST_NOT_PASS=11;
   public final static String TYPE_XUNTA="xunta";
   public final static String TYPE_RUIQU="ruiqu";
   public final static String TYPE_QINZI="qinzi";
   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = Integer.parseInt(postcode);
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = Integer.parseInt(flag);
	}

	public String getCreating_time() {
		return creating_time;
	}

	public void setCreating_time(String creating_time) {
		this.creating_time = creating_time;
	}

	public void setInvoker(String name, String args) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		String methodname = "set" + name;
		try {
			MethodInvoke.invokeMethod(this, methodname, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "YohooUser [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", id_type=" + id_type
				+ ", id_number=" + id_number + ", occupation=" + occupation
				+ ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", type=" + type + ", postcode=" + postcode
				+ ", flag=" + flag + "]";
	}
}
