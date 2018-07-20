package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.goods;

import demo.goodsDB;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class goodsPage
 */
@WebServlet("/goodsPage")
public class goodsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public goodsPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		//��ȡҳ����Ϣ
		String num = request.getParameter("num");
		if(num.equals("")) {
			return;
		}
		//trimȥ�ո�
		
		int numInt = Integer.parseInt(num.trim());
		
		
		//�������ݿ� ��ȡ��ǰҳ�����Ϣ
		List<goodsDB> lm = goods.selectPage(numInt);
		
		
		
		//�����ݷ�װ��һ��jsonArray����
		String goodsString = JSONArray.fromObject(lm).toString();
		
		//�����ݴ��ݸ�ҳ��
		PrintWriter out  = response.getWriter();
		out.write(goodsString);
			}


}
