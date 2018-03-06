package cn.net.www.bean;

public class Select {
private String[] items;
private String name;
private String select_now;
private int flag=10;
private int count=4;
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String[] getItems() {
	return items;
}
public void setItems(String[] items) {
	this.items = items;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSelect_now() {
	return select_now;
}
public void setSelect_now(String select_now) {
	this.select_now = select_now;
}
public void setItems(String str) {
	String[] string=str.split(",");
	this.items =string;
}
public String getItemsString(){
	String string="";
	for(String item:items){
		string+=item+",";
	}
	string.trim();
	string.substring(0,string.lastIndexOf(","));
	return string;
}
}
