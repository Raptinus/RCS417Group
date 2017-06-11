package edu.edgewood.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import edu.edgewood.dao.ModificationDAO;
import edu.edgewood.model.Modification;

public class ModificationJdbcDAO extends BaseJdbcDAO implements ModificationDAO{
	
	private static final String INSERT_SQL = "insert into modification(postId, modifierId, dateModified) "
			+ " values(?, ?, ?)";

	@Override
	public Modification get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Modification mod) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		java.sql.Date sqlDate = new java.sql.Date(mod.getDateModified().getTime());
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setInt(1,  mod.getPostId());
			stmt.setString(2, mod.getModifierId());
			stmt.setDate(3,  sqlDate);
			
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
	public List<Modification> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Modification t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
