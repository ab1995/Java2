package bookshop.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.javabeans.CartBean;
import bookshop.javabeans.LoginBean;

public class ControllerServlet extends HttpServlet {
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		this.ctx=config.getServletContext();
	}
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward=request.getParameter("forward");
		
		if(forward.equals("authenticate")){
			LoginBean loginBean=new LoginBean(request.getParameter("uesrId"), request.getParameter("password"));
			boolean loginResult=loginBean.login();
			
			if(loginResult){
				HttpSession session=request.getSession();
				session.setAttribute("username", loginBean.getUserName());
				RequestDispatcher rd=this.ctx.getRequestDispatcher("/CompBooks.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd=this.ctx.getRequestDispatcher("/login.html");
				rd.forward(request, response);
			}
			
		}
		
		else if(forward.equals("histbooks")){
			CartBean cart=new CartBean();
			cart.addBookToCart(request.getParameterValues("comp"));	
			HttpSession session =request.getSession();
			session.setAttribute("cart", cart);
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/HistBooks.jsp");
			rd.forward(request, response);
		}
		
		else if(forward.equals("showcart")){
			HttpSession session =request.getSession();
			CartBean cart=(CartBean)session.getAttribute("cart");
			
			cart.addBookToCart(request.getParameterValues("hist"));	
			session.setAttribute("cart", cart);
			
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/ShowCart.jsp");
			rd.forward(request, response);
		}
		
		else if(forward.equals("logout")){
			HttpSession session =request.getSession();
			session.invalidate();
			RequestDispatcher rd=this.ctx.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
          
		
	}
	   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}
}
