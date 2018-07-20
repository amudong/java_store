package day4;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class DB {

	
	public static String URL="jdbc:mysql://localhost:3306/microele";//数据库地址
	public static String USER="root";//数据库的账号名
	public static String PASSWORD="";//数据库密码
	
	
	//引入一个mysql驱动包
	static {
		try {
			//加载启动包
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			
		}
	}
	
	
	//获取驱动包连接
	public static Connection openconn() {
		//创建一个连接
		Connection conn = null;
		
		//获取一个连接 传三个参数给驱动包
		try {
			conn = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = openconn();
		if(conn!=null) {
			System.out.println("mysql数据库连接成功！！！");
		}
	}
	
	
}
