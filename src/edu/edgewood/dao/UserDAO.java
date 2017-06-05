package edu.edgewood.dao;

import java.sql.SQLException;

import edu.edgewood.model.User;

public interface UserDAO extends DAOSupport<User>{
	
	User get(String UserId, String pwd) throws SQLException;

}
