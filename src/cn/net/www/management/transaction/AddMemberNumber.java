package cn.net.www.management.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import cn.net.www.bean.UserInformation;
import cn.net.www.bean.XuntaUser;
import cn.net.www.bean.YohooMember;
import cn.net.www.dao.InsertDao;
import cn.net.www.dao.QueryDao;
import cn.net.www.unit.DateUnit;
import cn.net.www.unit.ReturnNumber;

public class AddMemberNumber {
public static boolean add(String phone) throws Exception{
  XuntaUser xtu=new QueryDao().queryUserInformation(phone);
  String creating_time=xtu.getCreating_time();
 Date createdate=DateUnit.returnDateByString(DateUnit.PATTERN,creating_time);
 Date reviewdate=new Date();
 int id=xtu.getId();
 int random_length=2;
 String gender=xtu.getGender();
  String number=ReturnNumber.returnMembernumber(createdate, reviewdate, id, random_length, gender);
  YohooMember ym=new YohooMember(phone, number,DateUnit.returnStringAboutPattern(DateUnit.PATTERN,reviewdate));
  boolean flag=new InsertDao().insertObject(ym, YohooMember.class);
  return flag;
}
}
