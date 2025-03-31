package model.dao;

import java.io.Serializable;
import java.util.List;

public abstract class Dao<T, Id extends Serializable> {
	protected DaoFactory daoFactory;

	public Dao(DaoFactory f) {
		daoFactory = f;
	}

	abstract public void create(T entity) throws DaoException;
	abstract public T read(Id id) throws DaoException;
	abstract public Id read(T entity) throws DaoException;
	abstract public void update(T entity) throws DaoException;
	abstract public void delete(Id id) throws DaoException;
	abstract public List<T> getAll() throws DaoException;
}
