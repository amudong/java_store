package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.insertUserN;

/**
 * Servlet implementation class insertVipServlet
 */
@WebServlet("/insertVipServlet")
public class insertVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public insertVipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String hid = request.getParameter("hid");
		
		int i = insertUserN.insertVip(uid, hid);
		if(i!=0) {
			response.sendRedirect("user_n_h_info.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}
	
	
	}

	
}
