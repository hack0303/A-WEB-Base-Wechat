package cn.net.www.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class DeleteDao {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	public boolean delete(String sql) throws SQLException, FileNotFoundException, NamingException, IOException{
		boolean flag=false;
		try{
		conn=new ConnDao().getConn();
		st=conn.createStatement();
		int int_flag=st.executeUpdate(sql);
		if(int_flag==0){
			flag=false;
		}else{
			flag=true;
		}
		}finally{
			close();
		}
		return flag;
		
	}
	public boolean deleteDateTable(String from,String to,int dateflag) throws FileNotFoundException, SQLException, NamingException, IOException{
		String sql="DELETE FROM yohoo_date WHERE from_phone='"+from+"' and to_phone='"+to+"' and date_flag='"+dateflag+"'";
		boolean flag=delete(sql);
		return flag;
	}
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
	}
}
