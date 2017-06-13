package edu.edgewood.svc;

import java.sql.SQLException;
import java.util.List;

import edu.edgewood.dao.PostDAO;
import edu.edgewood.dao.UserDAO;
import edu.edgewood.dao.jdbc.PostJdbcDAO;
import edu.edgewood.dao.jdbc.UserJdbcDAO;
import edu.edgewood.model.Post;
import edu.edgewood.model.User;

//service class operating between the user dao and the servlet
public class UserService {
	
	private UserDAO dao;
	
	public UserService() {
		dao = new UserJdbcDAO();
	}
	
	public User getUser (String id, String pwd) {
		try {
			return dao.get(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

