package cn.net.www.unit;

public class TextUnit {
public static String getchangeString(int out_length,String in_str){
	String out_str="";
	int length=in_str.length();
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<out_length-length;i++){
		sb.append("0");
	}
	sb.append(in_str);
	out_str=sb.toString();
	return out_str;
}
public static String returnString(String[] str){
	StringBuffer sb=new StringBuffer();
	for(String str_i:str){
	sb.append(str_i);
	sb.append(",");
	}
	String out=sb.toString();
	out.substring(0,out.length()-1);
	return out;
}
}
