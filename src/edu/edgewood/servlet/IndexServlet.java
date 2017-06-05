package edu.edgewood.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.edgewood.model.Post;
import edu.edgewood.svc.PostService;


@WebServlet(name = "index", urlPatterns = { "/index" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PostService service;

    public IndexServlet() {
    	service = new PostService();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get all posts and forward to jsp
		
		List<Post> posts = service.getAll();
		request.setAttribute("postList", posts);
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
