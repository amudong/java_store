package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.StringHolder;

public class insertUserN {
	
	
	public static int insert(int id,String uid, String name,String sex,String phone) {
		
		Connection conn  = DB.openconn();
		String sql ="insert into user(id,uid,name,sex,phone) values(?,?,?,?,?)";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setInt(1, id);
			 p.setString(2, uid);
			 p.setString(3, name);
			 p.setString(4, sex);
			 p.setString(5, phone);
			 int re = p.executeUpdate();
			    
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
	
	public static int insertVip(String uid,String hid) {
		Connection conn= DB.openconn();
		String sql ="insert into huser(uid,createTime,hid) values(?,?,?)";
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String createTime = year.format(date);
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1, uid);
			 p.setString(2, createTime);
			 p.setString(3, hid);
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
