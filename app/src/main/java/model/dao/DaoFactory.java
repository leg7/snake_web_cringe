package model.dao;

import model.beans.Match;
import model.beans.User;

public interface DaoFactory {
	public Dao<User, Integer> getUserDao();
	public Dao<Match, Integer> getMatchDao();
}
