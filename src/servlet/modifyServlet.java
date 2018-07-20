package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.modify;
/**
 * Servlet implementation class modifyServlet
 */
@WebServlet("/modifyServlet")
public class modifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public modifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String midMod = request.getParameter("mid");
    String mnameMod = request.getParameter("Mname");
    String dizhiMod = request.getParameter("dizhi");
    String phoneMod = request.getParameter("Phone");
    
    int i = Integer.parseInt(midMod);
    
    int j = modify.modifyM(i,mnameMod,dizhiMod,phoneMod);
    
    if(j==1) {
    	response.sendRedirect("index.jsp");
    }else {
    	response.sendRedirect("error.jsp");
    }
    
    

	}

}
