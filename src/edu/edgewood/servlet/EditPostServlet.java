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
		
		String id = request.getParameter("postId");
		
		Post post = service.getPost(id);
		
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/jsp/editpost.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String creatorId = request.getParameter("creatorid");
		String date = request.getParameter("datecreated");
		String title = request.getParameter("title");
		String shortDesc = request.getParameter("shortdesc");
		String longDesc = request.getParameter("longdesc");
		
		Date dateCreated = null;
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
		  dateCreated = formatter.parse(date);
		} catch (ParseException e) {
		  e.printStackTrace();
		}
		
		
		Post post = new Post(id, creatorId, title, shortDesc, longDesc, dateCreated);
		
		Modification mod = new Modification(id, creatorId, dateCreated);
		
		boolean postUpdated = service.updatePost(post);
		boolean modificationLogged = modService.insert(mod);
		
		String message;
		
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
