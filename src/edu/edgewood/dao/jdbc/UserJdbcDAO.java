package edu.edgewood.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.edgewood.dao.UserDAO;
import edu.edgewood.model.User;

// Responsible for retrieving User information from a rel db
public class UserJdbcDAO extends BaseJdbcDAO implements UserDAO {

	private static final String BY_ID_PWD = "select * from user "
			+ " where userId = ? and pwd = ?";
	
	private static final String BY_ID = "select * from user where userId = ?";
	
	private static final String INSERT_SQL = "insert into user(userId, pwd, firstName, lastName, dateRegistered) "
			+ " values(?, ?, ?, ?, ?)";
	
	private static final String SELECT_ALL = "select * from user";
	
	private static final String UPDATE_SQL = "update user set pwd = ?, "
			+ " firstName = ?, lastName = ? where userId = ?";

	public UserJdbcDAO(){}
	
	public boolean update(User user) {
		return false;
	}

	

	public List<User> getAll() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<User> result = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				User user = create(rs);
				result.add(user);
			}
			
			return result;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			releaseResources(conn, stmt, rs);
		}
		
	}
	
	
	// insert a record into db, return whether successful
	@Override
	public boolean insert(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPwd());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getFirstName());
			stmt.setDate(5, (java.sql.Date) new Date());
			
			int count = stmt.executeUpdate();
			return count == 1;
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			releaseResources(conn, stmt, null);
		}
		
		
		return true;
	}
	
	
	@Override
	public User get(String id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		User user = null;
	
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(BY_ID);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = create(rs);
			}
			
			return user;
			
		} catch (Exception ex){
			ex.printStackTrace();
			return null;
			
		} finally {
			releaseResources(conn, stmt, rs);
		}
		
	}

	@Override
	public User get(String id, String pwd) throws SQLException {
		// find the user record using id and pwd
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			
			// get a db connection
			// prepare the sql to be run
			// run sql
			// if records found build the User object and return it
			// else null
			conn = getConnection(); // call BaseJdbcDAO get connection
			stmt = conn.prepareStatement(BY_ID_PWD);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = create(rs);
			}
			
			return user;
			
		} finally {
			releaseResources(conn, stmt, rs);
		}
		
		
	}

	// Return a fully populated User object for the current record
	private User create(ResultSet rs) throws SQLException {
		
		String id = rs.getString("userId");
		String pwd = rs.getString("pwd");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		
		// might need to convert this from sql date form to java date form
		Date dateRegistered = (Date) rs.getDate("dateRegistered");
		
		return new User(id, pwd, firstName, lastName, dateRegistered);
	}


}
