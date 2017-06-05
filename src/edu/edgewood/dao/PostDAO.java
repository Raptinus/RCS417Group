package edu.edgewood.dao;

import java.sql.SQLException;

import edu.edgewood.model.Post;


public interface PostDAO extends DAOSupport<Post>{
		
		Post get(String id, String pwd) throws SQLException;

}


