package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.goods;
import day4.supplier;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet("/goodsServlet")
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public goodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sw = request.getParameter("sw");
		int i = Integer.parseInt(sw);
		if(i==1) {
			String id = request.getParameter("id");
			int idint = Integer.parseInt(id);
			int j = goods.delete(idint);
			if(j!=0) {
				response.sendRedirect("goodsList.jsp");
				
			}else {
				response.sendRedirect("error.jsp");
			}
		}else if(i==2) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String gid = request.getParameter("gid");
			String gname = request.getParameter("gname");
			String price = request.getParameter("price");
			String gcode = request.getParameter("gcode");
			String type = request.getParameter("type");
			String disc = request.getParameter("disc");
			String hy = request.getParameter("hy");
			String supid = request.getParameter("supid");
			
			int idMod = Integer.parseInt(id);
			
			int j = goods.modify(idMod,gid,gname,price,gcode,type,disc,hy,supid);
			
			if(j!=0) {
				response.sendRedirect("goodsList.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}
		else if(i==3) {
			request.setCharacterEncoding("utf-8");
			String idIns = request.getParameter("id");
			String gid = request.getParameter("gid");
			String gname = request.getParameter("gname");
			String price = request.getParameter("price");
			String gcode = request.getParameter("gcode");
			String type = request.getParameter("type");
			String disc = request.getParameter("disc");
			String hy = request.getParameter("hy");
			String supid = request.getParameter("supid");
    	    
    	    
    	    int idintIns = Integer.parseInt(idIns);
    	    
    	    int j = goods.insert(idintIns, gid, gname,price,gcode,type,disc,hy,supid);
    	    
    	    if(j==1) {
    	    	response.sendRedirect("goodsList.jsp");
    	    }else {
    	    	response.sendRedirect("error.jsp");
    	    }
			
		}
		
	}

	
}
