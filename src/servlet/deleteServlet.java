package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.delete;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public deleteServlet() {
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String midDelete = request.getParameter("mid");
		int i = Integer.parseInt(midDelete);
		int j = delete.deleteM(i);
		if(j==1) {
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("É¾³ýÊ§°Ü£¡£¡£¡");
			response.sendRedirect("error.jsp");
		}
	}

}
