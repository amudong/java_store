package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.goodsDB;
import demo.user_n;

public class user_nSelect {

public static int selectNum() {
		
		//��ȡ���������������
		Connection conn  = DB.openconn();
		
		//����һ��sql���
		String sql ="select COUNT(*) from user";
		
		//����mysqlִ������
		try {
			//�ѹ��������ӵ�ִ��Ȩ���赽��Ӧ��ִ����������
			PreparedStatement p = conn.prepareStatement(sql);
			
			//ִ���������
			ResultSet re = p.executeQuery();
			
			//�������ݷ��� ��ResultSet�в�����һֱѭ������
			while(re.next()){
				int a = re.getInt(1);
				return a;
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}	

public static List<user_n> selectPage(int byPage){
	Connection conn = DB.openconn();
	
	 int bg=0;
	 
     if(byPage==1) {
    	 bg=0;
     }else {
    	 bg = (byPage-1)*10;
     }
     System.out.println(byPage);
     String sql ="select * from user LIMIT ?,?";		

	
	List<user_n> ls =new  ArrayList<user_n>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, bg);
		p.setInt(2, 10);
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			user_n n = new user_n();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}

public static List<user_n> selectPage(){
	Connection conn = DB.openconn();
	
	String sql = "select * from user LIMIT 0,10";		

	
	List<user_n> ls =new  ArrayList<user_n>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			user_n n = new user_n();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}
	
public static List<user_n> select() {

	Connection conn  = DB.openconn();
	
	String sql ="select * from user";
	
	List<user_n> listu_n =new  ArrayList<user_n>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			user_n n = new user_n();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			listu_n.add(n);
			
		}
		
	}
	
	catch (Exception e) {
		// TODO: handle exception
	}
	return listu_n;
	
	
}

	
	
	
}
