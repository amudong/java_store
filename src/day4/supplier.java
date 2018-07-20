package day4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import demo.supplierDB;

public class supplier {
	public static int selectNum() {
		
		//��ȡ���������������
		Connection conn  = DB.openconn();
		
		//����һ��sql���
		String sql ="select COUNT(*) from supplier";
		
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
	
	public static List<supplierDB> selectPage(int byPage){
		Connection conn = DB.openconn();
		
		 int bg=0;
		 
	     if(byPage==1) {
	    	 bg=0;
	     }else {
	    	 bg = (byPage-1)*10;
	     }
	     String sql ="select * from supplier LIMIT ?,?";		

		
		List<supplierDB> ls =new  ArrayList<supplierDB>();
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, bg);
			p.setInt(2, 10);
			ResultSet re = p.executeQuery();
			
			while(re.next()) {
				supplierDB n = new supplierDB();
				n.setId(re.getInt(1));
				n.setSupid(re.getString(2));
				n.setSupname(re.getString(3));
				ls.add(n);
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
		
	}
	public static List<supplierDB> selectPage(){
		Connection conn = DB.openconn();
		
		String sql = "select * from supplier LIMIT 0,10";		

		
		List<supplierDB> ls =new  ArrayList<supplierDB>();
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet re = p.executeQuery();
			
			while(re.next()) {
				supplierDB n = new supplierDB();
				n.setId(re.getInt(1));
				n.setSupid(re.getString(2));
				n.setSupname(re.getString(3));
				ls.add(n);
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
		
	}
	
	public static List<supplierDB> select(){
		Connection conn = DB.openconn();
		
		String sql = "select * from supplier";
		
		List<supplierDB> ls =new  ArrayList<supplierDB>();
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet re = p.executeQuery();
			
			while(re.next()) {
				supplierDB n = new supplierDB();
				n.setId(re.getInt(1));
				n.setSupid(re.getString(2));
				n.setSupname(re.getString(3));
				ls.add(n);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
		
	}
	
	public static int delete(int id) {
	
		Connection conn  = DB.openconn();
		String sql ="delete from supplier where id=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setInt(1,id);
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	System.out.println("ɾ���ɹ�");
	        	return 1;
	        	
	        }
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	return 0;
	}
	
public static int modify(int id, String supid, String supname) {
		
		Connection conn  = DB.openconn();
		String sql ="update supplier set supId=?,supName=? where id=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1,supid);
			 p.setString(2,supname);
			 p.setInt(3, id);
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	System.out.println("�޸ĳɹ�");
	        	return 1;
	        	
	        }
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

public static int insert(int id,String supid, String supname) {
	
	Connection conn  = DB.openconn();
	String sql ="insert into supplier(id,supId,supName) values(?,?,?)";

	try {
		PreparedStatement p = conn.prepareStatement(sql);
		 p.setInt(1, id);
		 p.setString(2, supid);
		 p.setString(3, supname);
		 int re = p.executeUpdate();
		    
        if(re!=0) {
        	System.out.println("�����ɹ�");
        	return 1;
        	
        }
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}

	
}
