package edu.edgewood.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.edgewood.svc.PostService;


@WebServlet(name = "deletepost", urlPatterns = { "/deletepost" })
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PostService service;
       

    public DeletePostServlet() {
        service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("postId");
		
		boolean success = service.deletePost(id);
		
		String message;
		
		if (success) {
			message = "Post deleted.";
		} else {
			message = "Unable to delete post.";
		}
		
		request.setAttribute("errmsg", message);
		
		request.getRequestDispatcher("/index").forward(request, response);

	}

}
