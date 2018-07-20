package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modify {
	
	
	public static int modifyM(int mid,String mname,String address,String phone) {
		
		Connection conn  = DB.openconn();
		String sql ="update mendian set Mname=?,dizhi=?,Phone=? where mid=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1,mname);
			 p.setString(2,address);
			 p.setString(3,phone);
			 p.setInt(4,mid);
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	System.out.println("ÐÞ¸Ä³É¹¦");
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
