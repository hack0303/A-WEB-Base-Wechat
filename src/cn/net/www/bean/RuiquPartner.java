package cn.net.www.bean;

public class RuiquPartner {
	private int id;
	private String key_phone;
	private String name;
	private String gender;
	private String birthday;
	private String id_type;
	private String id_number;
	private String occupation;
	private String phone;
	private String email;
	private String address;
	private int postcode;
	private String type;
	
	public String getKey_phone() {
		return key_phone;
	}

	public void setKey_phone(String key_phone) {
		this.key_phone = key_phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public RuiquPartner(int id,String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, int postcode, String type) {
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
		this.postcode = postcode;
		this.type = type;
	}

	public RuiquPartner(int id, String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, int postcode) {
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
		this.postcode = postcode;
	}
	public RuiquPartner() {
		// TODO Auto-generated constructor stub
	}
}
