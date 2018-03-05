package cn.net.www.bean;

import java.io.Serializable;

public class PageBean implements Serializable{
private int pagenow;
private int pagination;
private int item;
private String type;//类型
private String func;//功能
private String state;//状态位
public static final int LENGTH_TEN=10;
public static final int LENGTH_FIVE=5;
public static final int FUNC_XUNTA_SHOW=1;
public static final String TYPE_XUNTA="xunta";
public static final String TYPE_RUIQU="ruiqu";
public static final String TYPE_QINZI="qinzi";
@Override
public String toString() {
	return "PageBean [pagenow=" + pagenow + ", pagination=" + pagination
			+ ", item=" + item + "]";
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getFunc() {
	return func;
}

public void setFunc(String func) {
	this.func = func;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public int getPagenow() {
	return pagenow;
}
public void setPagenow(int pagenow) {
	this.pagenow = pagenow;
}
public int getPagination() {
	return pagination;
}
public void setPagination(int pagination) {
	this.pagination = pagination;
}
public int getItem() {
	return item;
}
public void setItem(int item) {
	this.item = item;
}
public void setCount(int count) throws Exception{
	if(item==0) throw new Exception("每页显示数不能为空!");
	this.pagination=(count-1)/this.item+1;
}
public void setCount(int count,int item){
	this.item=item;
	this.pagination=(count-1)/item+1;
}
public PageBean(int pagenow, int pagination, int item) {
	super();
	this.pagenow = pagenow;
	this.pagination = pagination;
	this.item = item;
}
public PageBean(){
	super();
}
}
