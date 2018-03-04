package cn.net.www.bean;

public class UserImage {
	private int id;// 图片主键
	private String image;// 图片URL
	private String key_phone;// 手机号主键

	public String getKey_phone() {
		return key_phone;
	}

	public void setKey_phone(String key_phone) {
		this.key_phone = key_phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
