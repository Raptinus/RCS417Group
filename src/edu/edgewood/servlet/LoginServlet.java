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
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// fetch parameters from user-entered data in the front-end
		String userId = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// if string is empty or null, return to log in with error
		if ((isStringInvalid(userId) || isStringInvalid(pwd)) ) {
			request.setAttribute("errmsg", "Please fill out both fields.");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,  response);
		}
		
		// service class retrieves user from db
		User user = service.getUser(userId, pwd);
		
		// if user is found, set session cookie and return to index, otherwise back to login.jsp with an error
		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("/index").forward(request, response);
			
		} else {
			request.setAttribute("errmsg", "User not found.");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,  response);
			
		}
	
		
	}


	private boolean isStringInvalid(String str) {
		
		return (str == null || str.trim().length() == 0);
	}

}
