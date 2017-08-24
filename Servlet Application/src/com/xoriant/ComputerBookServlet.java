package com.xoriant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComputerBookServlet extends HttpServlet{
	
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		out.println("<h2>Welcome "+session.getAttribute("uname")+"</h2>"
				+ "<form action='controller?forward=histbooks' method='post'>"
				+ "  <input type='checkbox' value='c'  name='comp'> C<br>"
				+ "  <input type='checkbox' value='cpp' name='comp'> C++<br>"
				+ "  <input type='checkbox' value='java' name='comp'> JAVA<br>"
				+ "  <input type='submit' value='Next'>"
				+ "</form>");
		
	 }
	  
		
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	   }
}
