package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mendian;
import demo.mendianshiti;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class mendianPage
 */
@WebServlet("/mendianPage")
public class mendianPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mendianPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		mendian m = new mendian();
		List<mendianshiti> lm = m.selectPage(numInt);
		
		
		
		//�����ݷ�װ��һ��jsonArray����
		String mendianString = JSONArray.fromObject(lm).toString();
		
		//�����ݴ��ݸ�ҳ��
		PrintWriter out  = response.getWriter();
		out.write(mendianString);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
