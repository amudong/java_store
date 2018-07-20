package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.insertUserN;
import day4.supplier;


@WebServlet("/supplierServlet")
public class supplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public supplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sw = request.getParameter("sw");
		int i = Integer.parseInt(sw);
		
		if(i==1) {
			String id = request.getParameter("id");
			int idint = Integer.parseInt(id);
			int j = supplier.delete(idint);
			if(j!=0) {
				response.sendRedirect("supplierList.jsp");
				
			}else {
				response.sendRedirect("error.jsp");
			}
			
		}else if(i==2) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String supid = request.getParameter("supid");
			String supname = request.getParameter("supname");
			
			int idMod = Integer.parseInt(id);
			int j = supplier.modify(idMod, supid, supname);
			if(j!=0) {
				response.sendRedirect("supplierList.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}else if(i==3) {
			request.setCharacterEncoding("utf-8");
    	    String idIns = request.getParameter("id");
    	    String supidIns = request.getParameter("supid");
    	    String supnameIns = request.getParameter("supname");
    	    
    	    
    	    int idintIns = Integer.parseInt(idIns);
    	    
    	    int j = supplier.insert(idintIns, supidIns, supnameIns);
    	    
    	    if(j==1) {
    	    	response.sendRedirect("supplierList.jsp");
    	    }else {
    	    	response.sendRedirect("error.jsp");
    	    }
			
		}
		
		
	}

}
