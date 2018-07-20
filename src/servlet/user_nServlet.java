package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.deleteUserN;
import day4.insertUserN;
import day4.modifyUserN;

@WebServlet("/user_nServlet")
public class user_nServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public user_nServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sw = request.getParameter("switch");
	    int i = Integer.parseInt(sw);


	    
	    if(i==1) {
			String id = request.getParameter("id");	
			int idint = Integer.parseInt(id);
		    	
		    int j = deleteUserN.delete(idint);
		    if(j==1) {
		    response.sendRedirect("user_n_info.jsp"	);
	    }else {
	    	response.sendRedirect("error.jsp");
	    }  
	    }else if(i==2) {
	    	
	    	    request.setCharacterEncoding("utf-8");
	    	    String idMod = request.getParameter("id");
	    	    String uidMod = request.getParameter("uid");
	    	    String nameMod = request.getParameter("name");
	    	    String sexMod = request.getParameter("sex");
	    	    String phoneMod = request.getParameter("phone");
	    	    
	    	    int idintMod = Integer.parseInt(idMod);
	    	    
	    	    int j = modifyUserN.update(idintMod, uidMod, nameMod, sexMod, phoneMod);
	    	    
	    	    if(j==1) {
	    	    	response.sendRedirect("user_n_info.jsp");
	    	    }else {
	    	    	response.sendRedirect("error.jsp");
	    	    }
	    	    
	    	    

	    }else if(i==3) {
	    	    request.setCharacterEncoding("utf-8");
	    	    String idIns = request.getParameter("id");
	    	    String uidIns = request.getParameter("uid");
	    	    String nameIns = request.getParameter("name");
	    	    String sexIns = request.getParameter("sex");
	    	    String phoneIns = request.getParameter("phone");
	    	    
	    	    int idintIns = Integer.parseInt(idIns);
	    	    
	    	    int j = insertUserN.insert(idintIns,uidIns,nameIns,sexIns,phoneIns);
	    	    
	    	    if(j==1) {
	    	    	response.sendRedirect("user_n_info.jsp");
	    	    }else {
	    	    	response.sendRedirect("error.jsp");
	    	    }
	    	    
	    	    

	    }else if(i==4) {
	    	request.setCharacterEncoding("utf-8");
	    	String uid = request.getParameter("uid");
	    	
	    	
	    	
	    }
	    
	}
	}
	
	    
		
		
		
	
