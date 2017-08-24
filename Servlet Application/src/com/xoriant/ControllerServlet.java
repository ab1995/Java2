package com.xoriant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ControllerServlet extends HttpServlet{
	
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward=request.getParameter("forward");
		
		if(forward.equals("authenticate")){
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/login");
			rd.forward(request, response);
		}
		else if(forward.equals("compbooks")){
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/compbooks");
			rd.forward(request, response);
		}
		else if(forward.equals("histbooks")){
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/histbooks");
			rd.forward(request, response);
		}
		
		else if(forward.equals("showcart")){
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/showcart");
			rd.forward(request, response);
		}
		
		else if(forward.equals("logout")){
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/logout");
			rd.forward(request, response);
		}
          
		
	}
	   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}
}
