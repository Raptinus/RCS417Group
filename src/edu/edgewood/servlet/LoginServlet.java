package edu.edgewood.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.edgewood.model.User;
import edu.edgewood.svc.UserService;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service;
  
    public LoginServlet() {
        service = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		User user = service.getUser(userId, pwd);
		
		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("/index").forward(request, response);
			
		} else {
			request.setAttribute("errmsg", "User not found.");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,  response);
			
		}
		
		
		
		
		
	}

}
