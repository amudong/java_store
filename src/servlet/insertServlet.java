package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.insert;

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public insertServlet() {
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		String MnameInsert = request.getParameter("Mname");
		String addressInsert = request.getParameter("dizhi");
		String PhoneInsert = request.getParameter("Phone");
		
		System.out.println("门店名称：" + MnameInsert);
		System.out.println("所在的地区：" + addressInsert);
		System.out.println("电话号码：" + PhoneInsert);
		
		int i = insert.updateM(MnameInsert, addressInsert, PhoneInsert);
		if(i==1) {
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("新增失败！！！");
			response.sendRedirect("insert.jsp");
		}
	}

}
