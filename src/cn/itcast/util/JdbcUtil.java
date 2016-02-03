package cn.itcast.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String className;
	private static String url;
	private static String user;
	private static String password;
	static{
		try {
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			Properties props = new Properties();
			props.load(in);
			className = props.getProperty("className");
			Class.forName(className);    // 1、加载驱动程序并注册驱动
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 完成第1、2个步骤
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url,user,password);  // 2、获取与数据库的连接
	}
	
	 // 3、得到代表SQL语句的对象，并发送SQL给数据库
	public static void release(ResultSet rs,Statement stmt,Connection conn){ 
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
