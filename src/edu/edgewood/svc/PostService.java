package edu.edgewood.svc;

import java.util.List;

import edu.edgewood.dao.PostDAO;
import edu.edgewood.dao.jdbc.PostJdbcDAO;
import edu.edgewood.model.Post;

public class PostService {
	private PostDAO dao;
	
	public PostService() {
		dao = new PostJdbcDAO();
	}
	
	public List<Post> getAll() {
		return dao.getAll();
	}

	public boolean deletePost(String id) {	
		return dao.delete(id);
	}

	public Post getPost(String id) {
		return dao.get(id);
	}

	public boolean updatePost(Post post) {
		return dao.update(post);
	}

	public boolean insert(Post post) {
		return dao.insert(post);
		
	}

}
