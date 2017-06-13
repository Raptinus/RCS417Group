package edu.edgewood.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.edgewood.dao.PostDAO;
import edu.edgewood.model.Post;

// manages db changes for posts
public class PostJdbcDAO extends BaseJdbcDAO implements PostDAO {

	private static final String SELECT_ALL = "select * from post";
	
	private static final String DEL_SQL = "delete from post where postId = ?";
	
	private static final String SELECT_BY_ID = "select * from post where postId = ?";
	
	private static final String UPDATE_SQL = "update post set title = ?, shortDesc = ?, longDesc = ? where postId = ?";
	
	private static final String INSERT_SQL = "insert into post(creatorId, title, shortDesc, longDesc, dateCreated) "
			+ " values(?, ?, ?, ?, ?)";

	@Override
	public Post get(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Post post = null;


		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1,  id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				post = create(rs);
			}

			return post;

		} catch (Exception ex) {
			ex.printStackTrace();
			return post;
		} finally {
			releaseResources(conn, stmt, rs);
		}
	}

	@Override
	public boolean insert(Post post) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		java.sql.Date sqlDate = new java.sql.Date(post.getDateCreated().getTime());
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1,  post.getCreatorId());
			stmt.setString(2, post.getTitle());
			stmt.setString(3,  post.getShortDesc());
			stmt.setString(4,  post.getLongDesc());
			stmt.setDate(5,  sqlDate);
			
			int count = stmt.executeUpdate();
			
			return count == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			releaseResources(conn, stmt, rs);
		}
	
	

	}

	@Override
	public List<Post> getAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Post> result = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);

			while (rs.next()) {
				Post post = create(rs);
				result.add(post);
			}

			return result;

		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			releaseResources(conn, stmt, rs);
		}
	}

	

	private Post create(ResultSet rs) throws SQLException {
		
		int postId = rs.getInt("postId");
		String creatorId = rs.getString("creatorId");
		String title = rs.getString("title");
		String shortDesc = rs.getString("shortDesc");
		String longDesc = rs.getString("longDesc");
		Date dateCreated = (Date) rs.getDate("dateCreated");

		return new Post(postId, creatorId, title, shortDesc, longDesc, dateCreated);
	}
	
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(DEL_SQL);
			stmt.setString(1,  id);
			
			int result = stmt.executeUpdate();
			return result == 1;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			releaseResources(conn, stmt, null);
		}

		
	}

	@Override
	public boolean update(Post post) {

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(UPDATE_SQL);
			stmt.setString(1,  post.getTitle());
			stmt.setString(2,  post.getShortDesc());
			stmt.setString(3,  post.getLongDesc());
			stmt.setInt(4,  post.getPostId());
			
			int result = stmt.executeUpdate();
			return result == 1;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			releaseResources(conn, stmt, null);
		}
		
	}

}
