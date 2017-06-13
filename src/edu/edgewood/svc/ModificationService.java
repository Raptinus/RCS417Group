package edu.edgewood.svc;

import edu.edgewood.dao.ModificationDAO;
import edu.edgewood.dao.jdbc.ModificationJdbcDAO;
import edu.edgewood.model.Modification;

// service class operating between the modification dao and the servlet
public class ModificationService {
	
	private ModificationDAO dao;
	
	public ModificationService() {
		dao = new ModificationJdbcDAO();
	}
	
	public boolean insert(Modification mod) {
		return dao.insert(mod);
	}

}
