package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.log_reg;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
	
		int i = log_reg.register(username,password);
		
		if(i==1) {
			
			System.out.println("ע��ɹ�������");

			response.sendRedirect("login.jsp");
			
			
		}else {
			System.out.println("ע��ʧ�ܣ�����");
			response.sendRedirect("register.jsp");
		}
	}

}
