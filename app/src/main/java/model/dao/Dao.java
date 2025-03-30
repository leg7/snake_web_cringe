package model.dao;

import java.io.Serializable;
import java.util.List;

public abstract class Dao<T, Id extends Serializable> {
	protected DaoFactory daoFactory;

	public Dao(DaoFactory f) {
		daoFactory = f;
	}

	abstract public void create(T entity);
	abstract public T read(Id id);
	abstract public void update(T entity);
	abstract public void delete(Id id);
	abstract public List<T> getAll();
}
