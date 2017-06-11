package edu.edgewood.svc;

import edu.edgewood.dao.ModificationDAO;
import edu.edgewood.dao.jdbc.ModificationJdbcDAO;
import edu.edgewood.model.Modification;

public class ModificationService {
	
	private ModificationDAO dao;
	
	public ModificationService() {
		dao = new ModificationJdbcDAO();
	}
	
	public boolean insert(Modification mod) {
		return dao.insert(mod);
	}

}
