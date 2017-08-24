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

public class LoginServlet extends HttpServlet{
   
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   String id=request.getParameter("uesrId");
		   String password=request.getParameter("password");
		   
		   PrintWriter out =response.getWriter();
		   response.setContentType("text/html");
		   
		   if(password.equals(id)){
			   HttpSession session=request.getSession();
			   if(session.isNew())
			   {
				   session.setAttribute("uname", id);
			   }
			 RequestDispatcher rd=this.ctx.getRequestDispatcher("/controller?forward=compbooks");
			 rd.forward(request, response);
		   }
	   }
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	   }
}
