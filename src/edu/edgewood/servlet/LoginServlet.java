package edu.edgewood.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yenterprises";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "mysql";
	
	UserService service;
	  
    public LoginServlet() {
        service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection myConnection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName(DRIVER_NAME);
			myConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String userId = request.getParameter("id");
			String pwd = request.getParameter("pwd");
		
			if(userId != null && !userId.isEmpty()) {
				String selectSql = "select count(1) from user where userId = ? and pwd = ?";
				stmt = myConnection.prepareStatement(selectSql);
				stmt.setString(1, userId);
				stmt.setString(2, pwd);
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					if (rs.getInt(1) == 0) {
						request.setAttribute("errormsg", "Access Denied");
						request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
					} else {
						
					}
					User user = service.getUser(userId, pwd);
					
					HttpSession session = request.getSession(true);
										
					session.setAttribute("loginUser", user);
					
					request.getRequestDispatcher("/index").forward(request, response);

				}
				
			} else {
				request.setAttribute("errormsg", "Please provide login credentials");
				request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			}
				
				
			} catch (Exception ex){
				throw new RuntimeException(ex);
			}
			
			finally {
				try {
					if (stmt != null)
						stmt.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		
	}
	
}
		
		