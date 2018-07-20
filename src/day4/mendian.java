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
		
		//��ȡ���������������
		Connection conn  = DB.openconn();
		
		//����һ��sql���
		//��ȡ���ݿ�����ݵ� 0 �� 10 ������ ��Ҳ����ǰʮ������
		String sql ="select * from mendian LIMIT 0,10";
		
		//����һ��list����
		List<mendianshiti> listmen =new  ArrayList<mendianshiti>();
		
		//����mysqlִ������
		try {
			//�ѹ��������ӵ�ִ��Ȩ���赽��Ӧ��ִ����������
			PreparedStatement p = conn.prepareStatement(sql);
			
			//ִ���������
			ResultSet re = p.executeQuery();
			
			//�������ݷ��� ��ResultSet�в�����һֱѭ������
			while(re.next()){
						
				//�����ŵ�ʵ���� �����ŵ�ʵ����
				mendianshiti m = new mendianshiti();
				//һ��һ��������ӽ�ȥ
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

	//ͨ��ҳ����±��ѯ����Ӧ������
	public static List<mendianshiti> selectPage(int byPage) {
			
			 //��һ������
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

//��ѯҳ���������
public static int selectNum() {
	
	//��ȡ���������������
	Connection conn  = DB.openconn();
	
	//����һ��sql���
	String sql ="select COUNT(*) from mendian";
	
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
}
