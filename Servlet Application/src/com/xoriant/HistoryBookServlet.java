package com.xoriant;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HistoryBookServlet extends HttpServlet{
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   
		HttpSession session=request.getSession();  
		PrintWriter out =response.getWriter();
		session.setAttribute("compBooks", request.getParameterValues("comp"));   			
		response.setContentType("text/html");
		
		out.println("<h2>Welcome "+session.getAttribute("uname")+"</h2>"
					+ "<form action='controller?forward=showcart' method='post'>"
					+ "  <input type='checkbox' value='H1'  name='hist'> H1<br>"
					+ "  <input type='checkbox' value='H2' name='hist'> H2<br>"
					+ "  <input type='checkbox' value='H3' name='hist'> H3<br>"
					+ "  <input type='submit' value='Show'>"
					+ "</form>");
	   }
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	   }
}
