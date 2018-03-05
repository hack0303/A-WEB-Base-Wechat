package cn.net.www.management.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import cn.net.www.dao.QueryDao;
import cn.net.www.dao.UpdateDao;

public class AddNumberAndState {
public void add(int state,int number){
	
}
public static synchronized boolean add(int state,String phone,String gender) throws FileNotFoundException, SQLException, NamingException, IOException{
	QueryDao qd=new QueryDao();
	int number=qd.queryMaxNumber(state,gender);
	++number;
	System.out.print(state+":"+phone+":"+number);
	boolean flag=new UpdateDao().updateWYZQPass(state,number,phone);
	return flag;
}
}
