package day4;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class DB {

	
	public static String URL="jdbc:mysql://localhost:3306/microele";//���ݿ��ַ
	public static String USER="root";//���ݿ���˺���
	public static String PASSWORD="";//���ݿ�����
	
	
	//����һ��mysql������
	static {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			
		}
	}
	
	
	//��ȡ����������
	public static Connection openconn() {
		//����һ������
		Connection conn = null;
		
		//��ȡһ������ ������������������
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
			System.out.println("mysql���ݿ����ӳɹ�������");
		}
	}
	
	
}
