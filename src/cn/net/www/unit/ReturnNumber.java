package cn.net.www.unit;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

public class ReturnNumber {
public String returnDateNumber(String date_time,String state_number,String human_number,String target_gender){
	String out_str="";//日期(8位),对象期数(4位),对象编号(编号2位),
   StringBuffer sb=new StringBuffer();
	String date_str=new DateUnit().changeStyle(date_time);
	String state_str="";
	state_str=TextUnit.getchangeString(4,state_number);
	String target_number="";
	target_number=TextUnit.getchangeString(2,human_number);
	String gender_str="W";
	if(target_gender.equals("男")) gender_str="M";
	sb.append(date_str);
	sb.append(state_str);
	sb.append(target_number);
	sb.append(gender_str);
	out_str=sb.toString();
	return out_str;
}
public static String returnMembernumber(Date createdate,Date reviewdate,int id,int random_length,String gender) throws UnsupportedEncodingException{
   StringBuffer sb=new StringBuffer();
   String create_date=DateUnit.getDateString(createdate);//取日期
   String review_date=DateUnit.getDay(reviewdate);//取day
   String str_id=formatNumber(id,3);//取1000区间内id
   String random=MathUnit.returnRandom(2,10);//取随机数2位
   String gender_str="";//取性别WM
   System.out.println(new String(gender.getBytes("ISO-8859-1"),"UTF-8"));
   if(gender.equals("男")){
	   gender_str="M";
   }else if(gender.equals("女")){
	   gender_str="W";
   }
   sb.append(create_date);
   sb.append(review_date);
   sb.append(str_id);
   sb.append(random);
   sb.append(gender_str);
   return sb.toString();
}
public static String formatNumber(int number,int out_length){
	String str_number=String.valueOf(number);
	int in_length=str_number.length();
	if(out_length<in_length){
	str_number=str_number.substring(in_length-out_length);	
	}else if(out_length>in_length){
		String zero_str="";
		for(int i=0;i<(out_length-in_length);i++){
			zero_str+="0";
		}
		str_number=zero_str.trim()+str_number;
	}
	return str_number;
}
}
