package edu.edgewood.dao;

import java.util.List;

public interface DAOSupport<T> {
	
	T get (String id);
	boolean insert (T t);
	List<T> getAll();
	boolean update(T t);

}
