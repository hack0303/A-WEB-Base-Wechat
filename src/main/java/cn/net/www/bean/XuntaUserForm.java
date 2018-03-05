package cn.net.www.bean;

import java.util.List;

import cn.net.www.unit.MethodInvoke;

/**
 * @author daxian
 * @date : 2016-7-30 下午11:18:10
 */
public class XuntaUserForm extends XuntaUser {
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String six;
	private String seven;
	private String eight;
	private String nine;
	private String ten;
	private String eleven;
	private String twelve;
	private String thirteen;
	private String fourteen;
	private String fifteen;
	private String sixteen;
	private String seventeen;
	private String eighteen;
	private String nineteen;
	private String twenty;

	public XuntaUserForm(String one, String two, String three, String four,
			String five, String six, String seven, String eight, String nine,
			String ten, String eleven, String twelve, String thirteen,
			String fourteen, String fifteen, String sixteen, String seventeen,
			String eighteen, String nineteen, String twenty) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.six = six;
		this.seven = seven;
		this.eight = eight;
		this.nine = nine;
		this.ten = ten;
		this.eleven = eleven;
		this.twelve = twelve;
		this.thirteen = thirteen;
		this.fourteen = fourteen;
		this.fifteen = fifteen;
		this.sixteen = sixteen;
		this.seventeen = seventeen;
		this.eighteen = eighteen;
		this.nineteen = nineteen;
		this.twenty = twenty;
	}

	public XuntaUserForm(int id, String name, String gender, String birthday,
			String id_type, String id_number, String occupation, String phone,
			String email, String address, String type, int postcode, int flag,
			String nativeplace, String work_organization, double height,
			double weight, String salary, String onlychild, String marriage,
			String havebaby, String education, String nickname,
			String main_url, int date_flag, String introduction,
			String condition, String number, List<UserImage> list,
			String state, String one, String two, String three, String four,
			String five, String six, String seven, String eight, String nine,
			String ten, String eleven, String twelve, String thirteen,
			String fourteen, String fifteen, String sixteen, String seventeen,
			String eighteen, String nineteen, String twenty) {
		super(id, name, gender, birthday, id_type, id_number, occupation,
				phone, email, address, type, postcode, flag, nativeplace,
				work_organization, height, weight, salary, onlychild, marriage,
				havebaby, education, nickname, main_url, date_flag,
				introduction, condition, number, list, state);
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.six = six;
		this.seven = seven;
		this.eight = eight;
		this.nine = nine;
		this.ten = ten;
		this.eleven = eleven;
		this.twelve = twelve;
		this.thirteen = thirteen;
		this.fourteen = fourteen;
		this.fifteen = fifteen;
		this.sixteen = sixteen;
		this.seventeen = seventeen;
		this.eighteen = eighteen;
		this.nineteen = nineteen;
		this.twenty = twenty;
	}

	public XuntaUserForm() {
		super();
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}

	public String getSeven() {
		return seven;
	}

	public void setSeven(String seven) {
		this.seven = seven;
	}

	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}

	public String getNine() {
		return nine;
	}

	public void setNine(String nine) {
		this.nine = nine;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEleven() {
		return eleven;
	}

	public void setEleven(String eleven) {
		this.eleven = eleven;
	}

	public String getTwelve() {
		return twelve;
	}

	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}

	public String getThirteen() {
		return thirteen;
	}

	public void setThirteen(String thirteen) {
		this.thirteen = thirteen;
	}

	public String getFourteen() {
		return fourteen;
	}

	public void setFourteen(String fourteen) {
		this.fourteen = fourteen;
	}

	public String getFifteen() {
		return fifteen;
	}

	public void setFifteen(String fifteen) {
		this.fifteen = fifteen;
	}

	public String getSixteen() {
		return sixteen;
	}

	public void setSixteen(String sixteen) {
		this.sixteen = sixteen;
	}

	public String getSeventeen() {
		return seventeen;
	}

	public void setSeventeen(String seventeen) {
		this.seventeen = seventeen;
	}

	public String getEighteen() {
		return eighteen;
	}

	public void setEighteen(String eighteen) {
		this.eighteen = eighteen;
	}

	public String getNineteen() {
		return nineteen;
	}

	public void setNineteen(String nineteen) {
		this.nineteen = nineteen;
	}

	public String getTwenty() {
		return twenty;
	}

	public void setTwenty(String twenty) {
		this.twenty = twenty;
	}

	public String[] getStringArray(String param_name, String pattern) {
		String[] s = null;
		if (param_name.equals("one"))
			s = this.one.split(pattern);
		else if (param_name.equals("two"))
			s = this.two.split(pattern);
		else if (param_name.equals("three"))
			s = this.three.split(pattern);
		else if (param_name.equals("four"))
			s = this.four.split(pattern);
		else if (param_name.equals("five"))
			s = this.five.split(pattern);
		else if (param_name.equals("six"))
			s = this.six.split(pattern);
		else if (param_name.equals("seven"))
			s = this.seven.split(pattern);
		else if (param_name.equals("eight"))
			s = this.eight.split(pattern);
		else if (param_name.equals("nine"))
			s = this.nine.split(pattern);
		else if (param_name.equals("ten"))
			s = this.ten.split(pattern);
		else if (param_name.equals("eleven"))
			s = this.eleven.split(pattern);
		else if (param_name.equals("twelve"))
			s = this.twelve.split(pattern);
		else if (param_name.equals("thirteen"))
			s = this.thirteen.split(pattern);
		else if (param_name.equals("fourteen"))
			s = this.fourteen.split(pattern);
		else if (param_name.equals("fifteen"))
			s = this.fifteen.split(pattern);
		else if (param_name.equals("sixteen"))
			s = this.sixteen.split(pattern);
		else if (param_name.equals("seventeen"))
			s = this.seventeen.split(pattern);
		else if (param_name.equals("eighteen"))
			s = this.eight.split(pattern);
		else if (param_name.equals("nineteen"))
			s = this.nineteen.split(pattern);
		else if (param_name.equals("twenty"))
			s = this.twenty.split(pattern);
		return s;
	}

	public void setArrayString(String name, String[] str) {
		String n = String.valueOf(name.charAt(0));
		n = n.toUpperCase();
		String methodname = "set" + n + n.substring(1);
		String string=returnString(str);
		try {
			MethodInvoke.invokeMethod(this, methodname, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String returnString(String[] str) {
		String string = "";
		for (String s : str) {
			string += s + ",";
		}
		string = string.substring(0, string.length() - 1);
		string.trim();
		return string;
	}

	@Override
	public String toString() {
		return "XuntaUserForm [one=" + one + ", two=" + two + ", three="
				+ three + ", four=" + four + ", five=" + five + ", six=" + six
				+ ", seven=" + seven + ", eight=" + eight + ", nine=" + nine
				+ ", ten=" + ten + ", eleven=" + eleven + ", twelve=" + twelve
				+ ", thirteen=" + thirteen + ", fourteen=" + fourteen
				+ ", fifteen=" + fifteen + ", sixteen=" + sixteen
				+ ", seventeen=" + seventeen + ", eighteen=" + eighteen
				+ ", nineteen=" + nineteen + ", twenty=" + twenty + "]";
	}
}
