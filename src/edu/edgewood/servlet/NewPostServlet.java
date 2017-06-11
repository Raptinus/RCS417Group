package edu.edgewood.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.edgewood.model.Post;
import edu.edgewood.svc.PostService;


@WebServlet(name = "newpost", urlPatterns = { "/newpost" })
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PostService service;
    
    public NewPostServlet() {
        service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/newpost.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String creatorId = request.getParameter("creatorid");
		String title = request.getParameter("title");
		String shortDesc = request.getParameter("shortdesc");
		String longDesc = request.getParameter("longdesc");
		
		Date dateCreated = new Date();

		//using zero here, we won't use this value, db will create its own auto increment
		Post post = new Post(0, creatorId, title, shortDesc, longDesc, dateCreated);
		
		boolean success = service.insert(post);
		
		
		String message;
		
		if (success) {
			message = "Post saved.";
		} else {
			message = "Unable to save the following information.";
		}
		
		
		request.setAttribute("errmsg", message);
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp").forward(request, response);
		
	}

}
