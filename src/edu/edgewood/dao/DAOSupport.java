package edu.edgewood.dao;

import java.util.List;

// basic functions DAOs might support
public interface DAOSupport<T> {
	
	T get (String id);
	boolean insert (T t);
	List<T> getAll();
	boolean update(T t);
	boolean delete(String id);

}
