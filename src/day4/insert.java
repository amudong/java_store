package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
	
	
	public static int updateM(String MnameInsert, String addressInsert, String PhoneInsert) {
		
		Connection conn  = DB.openconn();
		String sql ="insert into mendian(Mname,dizhi,Phone) values(?,?,?)";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1, MnameInsert);
			 p.setString(2, addressInsert);
			 p.setString(3, PhoneInsert);
			 System.out.println("sssssss");
			 int re = p.executeUpdate();
			System.out.println("ss3213ss");
			    
	        if(re!=0) {
	        	System.out.println("新增成功");
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
