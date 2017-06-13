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
		
		// pulls parameters from front-end
		String creatorId = request.getParameter("creatorid");
		String title = request.getParameter("title");
		String shortDesc = request.getParameter("shortdesc");
		String longDesc = request.getParameter("longdesc");
		
		// date post is created (now!)
		Date dateCreated = new Date();

		//using zero here for postId, we won't use this value, db will create its own via autoincrement
		Post post = new Post(0, creatorId, title, shortDesc, longDesc, dateCreated);
		
		// attempt to insert post
		boolean success = service.insert(post);
		
		
		String message;
		
		if (success) {
			message = "Post saved.";
		} else {
			message = "Unable to save the following information.";
		}
		
		// attach success/failure msg to request and return to view post
		request.setAttribute("errmsg", message);
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp").forward(request, response);
		
	}

}
