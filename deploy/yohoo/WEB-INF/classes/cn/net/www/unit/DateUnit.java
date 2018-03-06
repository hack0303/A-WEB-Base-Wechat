package cn.net.www.unit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * @author daxian
 * @date : 2016-8-30 下午10:40:49
 */  
public class DateUnit {
	public static final String PATTERN="yyyy-MM-dd HH:mm:ss";//时间格式模版  
	public static final String PATTERNDATE="yyyy-MM-dd";//时间格式模版  
	private String datestring;
	private Date date;
	private String year;
	public String getYear(String datestring){
		String str="";
		String strarray[]=datestring.split("-");
		if(strarray.length!=0) str=strarray[0];
		else{
			str=null;
		}
		return str;
	}
   public static String parseDatetoBirth(String date_str){
	   String out="";
	   if(date_str.length()>10) {
	   out=date_str.substring(0,10);
	   String[] array=out.split("-");
	   out=array[0]+"/"+array[1]+"/"+array[2];
	   }
	   return out;
   }
   public static String parseDatetoAge(String date_str){
	   String out="";
	   if(date_str.length()>=10) {
	   out=date_str.substring(0,8);
	   String[] array=out.split("-");
     int nowyear=Calendar.getInstance().get(Calendar.YEAR);
	   out=String.valueOf(nowyear-Integer.parseInt(array[0]));
	   }
	   return out;
   }
   public static String changeStyle(String date_time){
	   String[] str=date_time.split("-");
	   String str_out="";
	   for(String part:str){
		   str_out+=part;
	   }
	   return str_out.trim();
   }
   public static String returnStringAboutPattern(String pattern,Date dt){
	   String outstr="";
	   outstr=new SimpleDateFormat(pattern).format(dt);
	   return outstr;
   }
   public static Date returnDateByString(String pattern,String date_string) throws Exception{
	   int year=0;
	   int month=0;
	   int day=0;
	   int hourOfDay=0;
	   int minute=0;
	   int second=0;
	   Date date=null;
	   if(pattern.equals("yyyy-MM-dd HH:mm:ss")){
	   String[] string=date_string.split(" ");
	   String PartA[]=string[0].split("-");
	   String PartB[]=string[1].split(":");	  
	   year=Integer.parseInt(PartA[0]);
	   month=Integer.parseInt(PartA[1])-1;//month the value used to set the MONTH calendar field. Month value is 0-based. e.g., 0 for January.

	   day=Integer.parseInt(PartA[2]);
	   hourOfDay=Integer.parseInt(PartB[0]);
	   minute=Integer.parseInt(PartB[1]);
	   second=Integer.parseInt(PartB[2]);
	   if(string.length!=2) throw new Exception("格式不对,检测中间:dd hh部分");
	   Calendar c=Calendar.getInstance();
	   c.set(year, month, day, hourOfDay, minute, second);
	   date=c.getTime();
	   }
	   return date;
   }
public static String getDay(String date){
	String out="";
	out=date.substring(8,10);
	return out;
}
public static String getDay(Date date){
	String out=returnStringAboutPattern(PATTERNDATE, date);
	out=out.substring(8,10);
	return out;
}
public static String getDateString(String date){
	String[] str=date.split("-");
	StringBuffer sb=new StringBuffer();
	for(String s:str){
	sb.append(s);
	}
	return sb.toString();
}
public static String getDateString(Date date){
	String out=returnStringAboutPattern(PATTERNDATE, date);
	String[] str=out.split("-");
	StringBuffer sb=new StringBuffer();
	for(String s:str){
	sb.append(s);
	}
	return sb.toString();
}
}
