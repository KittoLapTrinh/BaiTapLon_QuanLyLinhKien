package dao;

import java.util.List;

public interface DAOInterface<T> {
	
	public List<T> getAll();
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public T selectByID(T t);
}
