package cn.net.www.bean;

public class DateBean {
	private int id;// 主键
	private String from_id;// 约会主动方
	private String to_id;// 约会被动方
	private String date_time;// 申请时间
	private int date_flag;// 约会进行情况
	private String content;// 想对她说的话
	private String date_number;//交往编号
/*
 * yohoo_date数据表中,ONE,TWO,THREE,FOUR对应网页上的流程
 */
	public final static int DATE_ONE_START=100;//初始进入流程1.未付款
	public final static int DATE_ONE_PAY_ERROR=102;//付款失败
	public final static int DATE_ONE_PAY_YES=200;//成功付款,进入流程2
	public final static int DATE_TWO_START=200;//初始进入流程2,等待对方回复
	public final static int DATE_TWO_ACCEPT_NO=202;//对方拒绝(并且钱款返还到账)
	public final static int DATE_TWO_PAY_BACK_ERROR=203;//对方拒绝,返还钱款退还失败
	public final static int DATE_TWO_ACCEPT_YES=300;//对方接受邀约,进入流程3
	public final static int DATE_THREE_START=300;//初始进入流程3,等待约会安排
	public final static int DATE_THREE_ARRANGE_SUCCESS=400;//安排成功,等待进入流程4;
	public final static int DATE_THREE_ARRANGE_ERROR=302;//拒绝安排
	public final static int DATE_FOUR_START=400;//初始进入流程4,等待约会结果
	public final static int DATE_FOUR_END=403;//初始进入流程4,等待约会结果
	public final static int DATE_FOUR_AGREE_YES=401;//约会开始
	public final static int DATE_FOUR_AGREE_NO=402;//约会结束
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public int getDate_flag() {
		return date_flag;
	}

	public void setDate_flag(int date_flag) {
		this.date_flag = date_flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

	public String getDate_number() {
		return date_number;
	}

	public void setDate_number(String date_number) {
		this.date_number = date_number;
	}

	public DateBean(int id, String from_id, String to_id, String date_time,
			int date_flag, String content, String date_number) {
		super();
		this.id = id;
		this.from_id = from_id;
		this.to_id = to_id;
		this.date_time = date_time;
		this.date_flag = date_flag;
		this.content = content;
		this.date_number = date_number;
	}
public DateBean() {
	// TODO Auto-generated constructor stub
}
}
