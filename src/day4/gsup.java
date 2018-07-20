package day4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import demo.goodsDB;
import demo.gsupDB;


public class gsup {

public static int selectNum() {
		
		//��ȡ���������������
		Connection conn  = DB.openconn();
		
		//����һ��sql���
		String sql ="select COUNT(*) from g_sup gs join supplier s on gs.supId=s.supId";
		
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

public static List<gsupDB> selectPage(int byPage){
	Connection conn = DB.openconn();
	 int bg=0;
	 
     if(byPage==1) {
    	 bg=0;
     }else {
    	 bg = (byPage-1)*10;
     }
     String sql ="select * from g_sup gs join supplier s on gs.supId=s.supId LIMIT ?,?";		

	
	List<gsupDB> ls =new  ArrayList<gsupDB>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, bg);
		p.setInt(2, 10);
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			gsupDB n = new gsupDB();
			n.setId(re.getInt(1));
			n.setGid(re.getString(2));
			n.setSupid(re.getString(3));
			n.setId1(re.getInt(4));
			n.setSupname(re.getString(6));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}


public static List<gsupDB> selectPage(){
	Connection conn = DB.openconn();
	
	String sql = "select * from g_sup gs join supplier s on gs.supId=s.supId LIMIT 0,10";		

	
	List<gsupDB> ls =new  ArrayList<gsupDB>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			gsupDB n = new gsupDB();
			n.setId(re.getInt(1));
			n.setGid(re.getString(2));
			n.setSupid(re.getString(3));
			n.setId1(re.getInt(4));
			n.setSupname(re.getString(6));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}

	public static List<gsupDB> select(){
		Connection conn = DB.openconn();
		
		String sql = "select * from g_sup gs join supplier s on gs.supId=s.supId ";
		
		List<gsupDB> lgs =new  ArrayList<gsupDB>();
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet re = p.executeQuery();
			
			while(re.next()) {
				gsupDB n = new gsupDB();
				n.setId(re.getInt(1));
				n.setGid(re.getString(2));
				n.setSupid(re.getString(3));
				n.setId1(re.getInt(4));
				n.setSupname(re.getString(6));
				lgs.add(n);
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lgs;
		
	}
	/*
	public static int delete(int id,int id1) {
			
			Connection conn  = DB.openconn();
			String sql ="delete from supplier where id=?";
			String sql1 ="delete from g_sup where id=?";
		
			try {
				PreparedStatement p = conn.prepareStatement(sql);
				PreparedStatement p1 = conn.prepareStatement(sql1);
				 p.setInt(1,id);
				 p1.setInt(1, id1);
				 int re = p.executeUpdate();
				 int re1 = p1.executeUpdate();  
		        if(re!=0&&re1!=0) {
		        	System.out.println("ɾ���ɹ�");
		        	return 1;
		        	
		        }
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return 0;
		}*/
}
