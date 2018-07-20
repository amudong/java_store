package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteUserN {
	public static int delete(int id){
		Connection conn  = DB.openconn();
		String sql ="delete from user where id=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setInt(1,id);
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	System.out.println("É¾³ý³É¹¦");
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
