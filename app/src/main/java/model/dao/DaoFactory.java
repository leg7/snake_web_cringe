package model.dao;

import model.beans.User;

public interface DaoFactory {
	public Dao<User, Integer> getUserDao();
}
