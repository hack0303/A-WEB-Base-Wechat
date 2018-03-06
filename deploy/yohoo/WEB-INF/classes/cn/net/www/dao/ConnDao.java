package cn.net.www.dao;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnDao {
	Connection conn = null;

	public Connection getConn() throws NamingException, SQLException,
			FileNotFoundException, IOException {
		// Properties props=new Properties();
		// props.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		Context context = new InitialContext();// 上下文
		Context initialcontext = (Context) context.lookup("java:comp/env");
		DataSource ds = (DataSource) initialcontext.lookup("jdbc/test");
		conn = ds.getConnection();
		/*
		 * <resource-ref id="JNDI01"> <description>连接池</description>
		 * <res-ref-name>MyDataSource</res-ref-name>
		 * <res-type>javax.sql.DataSource</res-type>
		 * <res-auth>Container</res-auth> <mapped-name>jdbc/test</mapped-name>
		 * <lookup-name>test/youhuo</lookup-name> </resource-ref>
		 */
		return conn;
	}

	public void close() {
		if (conn != null)
			conn = null;
	}

	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = new ConnDao().getConn();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (conn != null)
			System.out.println("获取连接成功");
		else
			System.out.println("获取连接失败");
	}
}
