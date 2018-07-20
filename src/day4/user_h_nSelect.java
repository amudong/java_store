package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.user_n;
import demo.userhn;


public class user_h_nSelect {
	
	public static int deleteVip(String uid, String hid) {
		Connection conn = DB.openconn();
		String sql ="delete from huser where uid=? and hid=?";
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, uid);
			p.setString(2, hid);
			
			int re = p.executeUpdate();
			
			if(re!=0) {
				return 1;
			}
			
			
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
public static int selectNum() {
		
		//��ȡ���������������
		Connection conn  = DB.openconn();
		
		//����һ��sql���
		String sql ="select COUNT(*) from user u join huser h on u.uid=h.uid";
		
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

public static List<userhn> selectPage(int byPage){
	Connection conn = DB.openconn();
	
	 int bg=0;
	 
     if(byPage==1) {
    	 bg=0;
     }else {
    	 bg = (byPage-1)*10;
     }
     System.out.println(byPage);
     String sql ="select * from user u join huser h on u.uid=h.uid LIMIT ?,?";		

	
	List<userhn> ls =new  ArrayList<userhn>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, bg);
		p.setInt(2, 10);
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			userhn n = new userhn();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			n.setHid(re.getString(7));
			n.setCreateTime(re.getString(8));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}

public static List<userhn> selectPage(){
	Connection conn = DB.openconn();
	
	String sql = "select * from user u join huser h on u.uid=h.uid LIMIT 0,10";		

	
	List<userhn> ls =new  ArrayList<userhn>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			userhn n = new userhn();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			n.setHid(re.getString(7));
			n.setCreateTime(re.getString(8));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}
	

public static List<userhn> select() {

	Connection conn  = DB.openconn();
	
	String sql ="select u.id,u.uid,name,sex,phone,hid,createTime from user u join huser h on u.uid=h.uid";
	
	List<userhn> listu_n =new  ArrayList<userhn>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			userhn n = new userhn();
			n.setId(re.getInt(1));
			n.setUid(re.getString(2));
			n.setName(re.getString(3));
			n.setSex(re.getString(4));
			n.setPhone(re.getString(5));
			n.setHid(re.getString(6));
			n.setCreateTime(re.getString(7));
				
			listu_n.add(n);
			
		}
		
	}
	
	catch (Exception e) {
		// TODO: handle exception
	}
	return listu_n;
	
	
}

	
	
	
}
