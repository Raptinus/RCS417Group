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

import edu.edgewood.model.Modification;
import edu.edgewood.model.Post;
import edu.edgewood.svc.ModificationService;
import edu.edgewood.svc.PostService;


@WebServlet(name = "editpost", urlPatterns = { "/editpost" })
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PostService service;
	ModificationService modService;
	
	public EditPostServlet() {
		service = new PostService();
		modService =  new ModificationService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// pulls postId from hidden input tag in front-end	
		String id = request.getParameter("postId");
		
		// fetches post from db
		Post post = service.getPost(id);
		
		// attaches post in question to the request
		request.setAttribute("post", post);
		
		// forward to jsp
		request.getRequestDispatcher("/WEB-INF/jsp/editpost.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// pulls post data from front-end
		int id = Integer.parseInt(request.getParameter("id"));
		String creatorId = request.getParameter("creatorid");
		String date = request.getParameter("datecreated");
		String title = request.getParameter("title");
		String shortDesc = request.getParameter("shortdesc");
		String longDesc = request.getParameter("longdesc");
		
		Date dateCreated = null;
		
		//irritating way of parsing a string date as stored in an html tag to Date object
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
		  dateCreated = formatter.parse(date);
		} catch (ParseException e) {
		  e.printStackTrace();
		}
		
		
		Post post = new Post(id, creatorId, title, shortDesc, longDesc, dateCreated);
		
		Modification mod = new Modification(id, creatorId, dateCreated);
		
		// upon edit we need to both update the post and store the date and user of the edit
		boolean postUpdated = service.updatePost(post);
		boolean modificationLogged = modService.insert(mod);
		
		String message;
		
		// if the updates succeed, we view the post with a success message--
		// otherwise we view the post with an error message
		if (postUpdated && modificationLogged) {
			message = "Post updated.";
		} else {
			message = "Unable to update with the following information.";
		}
		
		request.setAttribute("errmsg", message);
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp").forward(request, response);
		
	}

}
