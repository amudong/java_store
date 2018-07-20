package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyUserN {

	public static int update(int id, String uid, String name, String sex, String phone) {
		
		Connection conn  = DB.openconn();
		String sql ="update user set uid=?,name=?,sex=?,Phone=? where id=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1,uid);
			 p.setString(2,name);
			 p.setString(3,sex);
			 p.setString(4,phone);
			 p.setInt(5, id);
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
