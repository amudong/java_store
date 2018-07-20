package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.user_nSelect;
import demo.user_n;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class userPage
 */
@WebServlet("/userPage")
public class userPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public userPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		
		//��ȡҳ����Ϣ
		String num = request.getParameter("num");
		System.out.println(num);
		if(num.equals("")) {
			return;
		}
		//trimȥ�ո�
		
		int numInt = Integer.parseInt(num.trim());
		
		
		//�������ݿ� ��ȡ��ǰҳ�����Ϣ
		List<user_n> lm = user_nSelect.selectPage(numInt);
		
		
		
		//�����ݷ�װ��һ��jsonArray����
		String usernString = JSONArray.fromObject(lm).toString();
		
		//�����ݴ��ݸ�ҳ��
		PrintWriter out  = response.getWriter();
		out.write(usernString);
		}


	

	

}
