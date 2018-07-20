package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.log_reg;



@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("ÓÃ»§Ãû£º" + username);
		System.out.println("ÃÜÂë£º" + password);
		
		
		
		
	
		int i = log_reg.login(username,password);
		
		if(i==1) {
			
			
			request.getSession().setAttribute("usernametest", username);
			
			
			response.sendRedirect("main.jsp");
			
			
		}else {
			System.out.println("µÇÂ¼Ê§°Ü£¡£¡£¡");
			response.sendRedirect("login.jsp");
		}

}
}
