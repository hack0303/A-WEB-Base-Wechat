package cn.net.www.unit;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;

import cn.net.www.bean.XuntaUser;

public class DOM {
private Document document=null;
public Document getDocument() {
	return document;
}
public void setDocument(Document document) {
	this.document = document;
    document.setXMLEncoding("utf-8");
}
public DOM() {
	super();
}
public void createDocument(){
 this.document=DocumentHelper.createDocument();
}
public void setUserShow(List<XuntaUser> list) throws Exception{
	String pmain_url="";
	String pphone="";
	String pnumber="";
	String pnickname="";
	String pintroduction="";
	if(document==null) throw new Exception("文档不能为空,请先创建"); 
	Element root=DocumentHelper.createElement("table");
	document.setRootElement(root);
	for(XuntaUser xtu:list){
		pmain_url="image/user/"+xtu.getMain_url();
		pphone=xtu.getPhone();
		pnumber=xtu.getNumber();
		pnickname=xtu.getNickname();
		pintroduction=xtu.getIntroduction();
	Element item=root.addElement("item");
	Element main_url=item.addElement("main_url");
	main_url.setText(pmain_url);
	Element phone=item.addElement("phone");
	phone.setText(pphone);
	Element number=item.addElement("number");
	number.setText(pnumber);
	Element nickname=item.addElement("nickname");
	nickname.setText(pnickname);
	Element introduction=item.addElement("introduction");
	introduction.setText(pintroduction);
	}
	}
}
