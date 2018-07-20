package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import day4.gsup;

import demo.gsupDB;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class gsupPage
 */
@WebServlet("/gsupPage")
public class gsupPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public gsupPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		
		//获取页面信息
		String num = request.getParameter("num");
		System.out.println(num);
		if(num.equals("")) {
			return;
		}
		//trim去空格
		
		int numInt = Integer.parseInt(num.trim());
		
		
		//访问数据库 获取当前页面的信息
		List<gsupDB> lm = gsup.selectPage(numInt);
		
		
		
		//把数据封装成一个jsonArray参数
		String gsupString = JSONArray.fromObject(lm).toString();
		
		//把数据传递给页面
		PrintWriter out  = response.getWriter();
		out.write(gsupString);

	}

	

}
