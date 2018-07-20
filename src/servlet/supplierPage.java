package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.supplier;
import demo.supplierDB;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class supplierPage
 */
@WebServlet("/supplierPage")
public class supplierPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierPage() {
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
				List<supplierDB> lm = supplier.selectPage(numInt);
				
				
				
				//�����ݷ�װ��һ��jsonArray����
				String supplierString = JSONArray.fromObject(lm).toString();
				
				//�����ݴ��ݸ�ҳ��
				PrintWriter out  = response.getWriter();
				out.write(supplierString);
				}


}
