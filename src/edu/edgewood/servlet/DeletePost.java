package edu.edgewood.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.edgewood.svc.PostService;


@WebServlet(name = "deletepost", urlPatterns = { "/deletepost" })
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PostService service;
       

    public DeletePost() {
        service = new PostService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
