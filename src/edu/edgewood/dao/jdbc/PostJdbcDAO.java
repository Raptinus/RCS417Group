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

public class PostJdbcDAO extends BaseJdbcDAO implements PostDAO {

	private static final String SELECT_ALL = "select * from post";
	
	private static final String DEL_SQL = "delete from post where postId = ?";

	@Override
	public Post get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Post post) {

		return false;
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

	@Override
	public boolean update(Post t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Post get(String id, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

}
