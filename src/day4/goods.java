package day4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import demo.goodsDB;



public class goods {
	
public static int selectNum() {
		
		//获取工具类里面的连接
		Connection conn  = DB.openconn();
		
		//创建一个sql语句
		String sql ="select COUNT(*) from goods g join g_sup gs on g.gid=gs.gid join supplier s on gs.supId=s.supId";
		
		//创建mysql执行命令
		try {
			//把工具类连接的执行权赋予到对应的执行命令里面
			PreparedStatement p = conn.prepareStatement(sql);
			
			//执行命令操作
			ResultSet re = p.executeQuery();
			
			//进行数据分析 当ResultSet有参数就一直循环下来
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
public static List<goodsDB> selectPage(int byPage){
	Connection conn = DB.openconn();
	
	 int bg=0;
	 
     if(byPage==1) {
    	 bg=0;
     }else {
    	 bg = (byPage-1)*10;
     }
     String sql ="select * from goods g join g_sup gs on g.gid=gs.gid join supplier s on gs.supId=s.supId LIMIT ?,?";		

	
	List<goodsDB> ls =new  ArrayList<goodsDB>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, bg);
		p.setInt(2, 10);
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			goodsDB n = new goodsDB();
			n.setId(re.getInt(1));
			n.setGid(re.getString(2));
			n.setGname(re.getString(3));
			n.setPrice(re.getString(4));
			n.setGcode(re.getString(5));
			n.setType(re.getString(6));
			n.setDisc(re.getString(7));
			n.setHy(re.getString(8));
			n.setSupid(re.getString(13));
			n.setSupname(re.getString(14));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}
public static List<goodsDB> selectPage(){
	Connection conn = DB.openconn();
	
	String sql = "select * from goods g join g_sup gs on g.gid=gs.gid join supplier s on gs.supId=s.supId LIMIT 0,10";		

	
	List<goodsDB> ls =new  ArrayList<goodsDB>();
	
	try {
		PreparedStatement p = conn.prepareStatement(sql);
		
		ResultSet re = p.executeQuery();
		
		while(re.next()) {
			goodsDB n = new goodsDB();
			n.setId(re.getInt(1));
			n.setGid(re.getString(2));
			n.setGname(re.getString(3));
			n.setPrice(re.getString(4));
			n.setGcode(re.getString(5));
			n.setType(re.getString(6));
			n.setDisc(re.getString(7));
			n.setHy(re.getString(8));
			n.setSupid(re.getString(13));
			n.setSupname(re.getString(14));
			ls.add(n);
			
		}
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ls;
	
}

	public static List<goodsDB> select(){
		Connection conn = DB.openconn();
		
		String sql = "select * from goods g join g_sup gs on g.gid=gs.gid join supplier s on gs.supId=s.supId";
		
		List<goodsDB> lg =new  ArrayList<goodsDB>();
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet re = p.executeQuery();
			
			while(re.next()) {
				goodsDB n = new goodsDB();
				n.setId(re.getInt(1));
				n.setGid(re.getString(2));
				n.setGname(re.getString(3));
				n.setPrice(re.getString(4));
				n.setGcode(re.getString(5));
				n.setType(re.getString(6));
				n.setDisc(re.getString(7));
				n.setHy(re.getString(8));
				n.setSupid(re.getString(13));
				n.setSupname(re.getString(14));
				lg.add(n);
				
			}
			conn.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lg;
		
	}
	
	public static int delete(int id) {
		
		Connection conn  = DB.openconn();
		String sql ="delete from goods where id=?";
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setInt(1,id);
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	System.out.println("删除成功");
	        	return 1;
	        	
	        }
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	return 0;
	}
public static int modify(int id, String gid, String gname,String price,String gcode,String type,String disc,String hy,String supid) {
		
		Connection conn  = DB.openconn();
		String sql ="update goods set gid=?,gname=?,price=?,gcode=?,type=?,disc=?,hy=? where id=?";		
	
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			 p.setString(1,gid);
			 p.setString(2,gname);
			 p.setString(3, price);
			 p.setString(4, gcode);
			 p.setString(5, type);
			 p.setString(6, disc);
			 p.setString(7, hy);
			 p.setInt(8, id);
			 
			 int re = p.executeUpdate();
			    
	        if(re!=0) {
	        	String sql1 = "update g_sup set supid=? where gid=?";
	        	PreparedStatement o = conn.prepareStatement(sql1);
	        	o.setString(1, supid);
	        	o.setString(2, gid);
	        	int re1 = o.executeUpdate();
	        	if(re1!=0) {
	        		return 1;
	        	}
	        	
	        	
	        }
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
public static int insert(int id,String gid, String gname,String price,String gcode,String type,String disc,String hy,String supid) {
	
	Connection conn  = DB.openconn();
	String sql ="insert into goods(id,gid,gname,price,gcode,type,disc,hy) values(?,?,?,?,?,?,?,?)";

	try {
		PreparedStatement p = conn.prepareStatement(sql);
		 p.setInt(1, id);
		 p.setString(2, gid);
		 p.setString(3, gname);
		 p.setString(4, price);
		 p.setString(5, gcode);
		 p.setString(6, type);
		 p.setString(7, disc);
		 p.setString(8, hy);
		 int re = p.executeUpdate();
		    
        if(re!=0) {
        	String sql1 = "insert into g_sup(gid,supId) values(?,?)";
        	PreparedStatement o = conn.prepareStatement(sql1);
        	o.setString(1, gid);
        	o.setString(2, supid);
        	int re1 = o.executeUpdate();
        	if(re1!=0) {
        		return 1;
        	}
        	
        	
        }
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}

	
	
	
}
