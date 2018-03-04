package cn.net.www.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import cn.net.www.bean.PageBean;
import cn.net.www.bean.YohooUser;
import cn.net.www.dao.QueryDao;

public class PageSpan {
public static void first(PageBean pb){
	pb.setPagenow(1);
}
public static void prev(PageBean pb){
	pb.setPagenow(pb.getPagenow()>1?(pb.getPagenow()-1):1);
}
public static void to(PageBean pb,int want){
	pb.setPagenow(want);
}
public static void next(PageBean pb){
	pb.setPagenow(pb.getPagenow()<pb.getPagination()?(pb.getPagenow()+1):pb.getPagination());	
}
public static void last(PageBean pb){
	pb.setPagenow(pb.getPagination());
}
public static void pagination(PageBean pb) throws Exception{
	int count=new QueryDao().countUserListByState(pb.getType(),YohooUser.WYZQ_REQUEST_PASS,pb.getState());
    pb.setCount(count);
}
}
