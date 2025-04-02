package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.beans.Match;
import model.beans.User;

// Je n'utilise pas le dp singleton pareceque on pourrait vouloir utiliser 2 bases sql differentes
public class DaoFactoryJdbc implements DaoFactory {
	private String url;
	UserDaoJdbc userDao;
	MatchDaoJdbc matchDao;
	static private String defaultDB = "jdbc:sqlite:database.db";

	public DaoFactoryJdbc(String url) {
		this.url = url;

		try {
			Class.forName("org.sqlite.JDBC"); // Load the squeel driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Statement stmt = getConnection().createStatement();
			String sql =
			"create table if not exists users ("
			+ "id integer primary key AUTOINCREMENT,"
			+ "nick text not null unique,"
			+ "email text not null unique,"
			+ "password text not null"
			+ ");"

			+ "create table if not exists matches ("
			+ "id integer primary key autoincrement,"
			+ "winner_id integer,"
			+ "loser_id integer,"
			+ "foreign key (winner_id) references users(id),"
			+ "foreign key (loser_id) references users(id)"
			+ ");";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		userDao = new UserDaoJdbc(this);
		matchDao = new MatchDaoJdbc(this);
	}

	public DaoFactoryJdbc() {
		this(defaultDB);
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url);
	}

	@Override
	public Dao<User, Integer> getUserDao() {
		return userDao;
	}

	public Dao<Match, Integer> getMatchDao() {
		return matchDao;
	}
}
