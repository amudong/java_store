package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.user_h_nSelect;

@WebServlet("/deleteVipServlet")
public class deleteVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteVipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String hid = request.getParameter("hid");
		
		int i = user_h_nSelect.deleteVip(uid, hid);
		
		if(i!=0) {
			response.sendRedirect("user_n_h_info.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}
	}


}
