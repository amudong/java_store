package day4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.mendianshiti;

public class mendian {
public static List<mendianshiti> selectPage() {
		
		//获取工具类里面的连接
		Connection conn  = DB.openconn();
		
		//创建一个sql语句
		//获取数据库表数据的 0 到 10 的数据 ，也就是前十条数据
		String sql ="select * from mendian LIMIT 0,10";
		
		//创建一个list集合
		List<mendianshiti> listmen =new  ArrayList<mendianshiti>();
		
		//创建mysql执行命令
		try {
			//把工具类连接的执行权赋予到对应的执行命令里面
			PreparedStatement p = conn.prepareStatement(sql);
			
			//执行命令操作
			ResultSet re = p.executeQuery();
			
			//进行数据分析 当ResultSet有参数就一直循环下来
			while(re.next()){
						
				//存入门店实体类 创建门店实体类
				mendianshiti m = new mendianshiti();
				//一个一个参数添加进去
				m.setId(re.getInt(1));
				m.setDizhi(re.getString(3));
				m.setMname(re.getString(2));
				m.setPhone(re.getString(4));
				
				listmen.add(m);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listmen;
		
	}

	//通过页面的下标查询出对应的数据
	public static List<mendianshiti> selectPage(int byPage) {
			
			 //第一个参数
			 int bg=0;
			 
		     if(byPage==1) {
		    	 bg=0;
		     }else {
		    	 bg = (byPage-1)*10;
		     }
		
		
		
			Connection conn  = DB.openconn();
			
			String sql ="select * from mendian LIMIT ?,?";
			
		
			List<mendianshiti> listmen =new  ArrayList<mendianshiti>();
			
		
			try {
			
				PreparedStatement p = conn.prepareStatement(sql);
				p.setInt(1,bg);
				p.setInt(2,10);
	
				ResultSet re = p.executeQuery();
		
				while(re.next()){
					
					mendianshiti m = new mendianshiti();
		
					m.setId(re.getInt(1));
					m.setDizhi(re.getString(3));
					m.setMname(re.getString(2));
					m.setPhone(re.getString(4));
					
					listmen.add(m);
					
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listmen;
			
		}
public static List<mendianshiti> select() {
		Connection conn  = DB.openconn();
		String sql ="select * from mendian";
		
		List<mendianshiti> listmen =new  ArrayList<mendianshiti>();
		
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			
			ResultSet re = p.executeQuery();
			
			while(re.next()){
				mendianshiti m = new mendianshiti();
				m.setId(re.getInt(1));
				m.setDizhi(re.getString(3));
				m.setMname(re.getString(2));
				m.setPhone(re.getString(4));
				
				listmen.add(m);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listmen;
		
	}

//查询页面的总数量
public static int selectNum() {
	
	//获取工具类里面的连接
	Connection conn  = DB.openconn();
	
	//创建一个sql语句
	String sql ="select COUNT(*) from mendian";
	
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
}
