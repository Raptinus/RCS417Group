package edu.edgewood.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.edgewood.model.Post;
import edu.edgewood.svc.PostService;


@WebServlet(description = "viewpost", urlPatterns = { "/viewpost" })
public class ViewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PostService service;

    public ViewPostServlet() {
        service = new PostService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("postId");
		
		Post post = service.getPost(id);
		
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
