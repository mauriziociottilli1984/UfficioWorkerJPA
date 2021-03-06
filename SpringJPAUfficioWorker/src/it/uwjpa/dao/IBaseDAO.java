package it.uwjpa.dao;

import java.util.List;

public interface IBaseDAO<T> {

	public List<T> list();

	public T get(Long id);

	public void update(T o);

	public void insert(T o);

	public void delete(T o);

	public List<T> findByExample(T o);
	
	//forza il ricaricamento dalla base dati
	public void refresh(T o);
	
}
