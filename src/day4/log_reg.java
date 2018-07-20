package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class log_reg {
	
	
public static int login(String username,String password) {
		
		Connection conn  = DB.openconn();
		String sql ="select * from userlist where username=? and password=?";
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1, username);
			 p.setString(2, password);
			 
			ResultSet re = p.executeQuery();
			
			while(re.next()){
	
				System.out.println("µÇÂ¼³É¹¦");
				return 1;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}



	
	public static int register(String username,String password) {
		Connection conn  = DB.openconn();
		String sql = "insert userlist(username,password) values(?,?)";
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
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
	
	
}
