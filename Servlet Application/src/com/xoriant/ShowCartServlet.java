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

public class ShowCartServlet extends HttpServlet{
	
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();  
		response.setContentType("text/html");
		session.setAttribute("histBooks", request.getParameterValues("hist"));
		
		
		
		out.println("<h3>Selected Books</h3>");
		String[] selectedBooks=(String[])session.getAttribute("compBooks");
		if(selectedBooks!=null && selectedBooks.length>0){
			for(int i=0;i<selectedBooks.length;i++){
				out.println("<h2>"+selectedBooks[i]+"</h2>");
			}
		}
		
		selectedBooks=(String[])session.getAttribute("histBooks");
		if(selectedBooks!=null && selectedBooks.length>0){
			for(int i=0;i<selectedBooks.length;i++){
				out.println("<h2>"+selectedBooks[i]+"</h2>");
			}
		}
		
		
		out.println("<form action='controller?forward=logout' method='post'>"
				+ "<input type='submit' value='Logout'/>"
				+ "</form>");
		
	 }
	  
		
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	   }
}
