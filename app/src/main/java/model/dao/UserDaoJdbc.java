package model.dao;

import model.beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc extends Dao<User, Integer> {
	public UserDaoJdbc(DaoFactory f) {
		super(f);
	}

	@Override
	public void create(User user) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();

			preparedStatement = connexion.prepareStatement("INSERT INTO users(nick, email, password) VALUES(?, ?, ?);");
			preparedStatement.setString(1, user.getNick());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());

			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					int id = generatedKeys.getInt(1);
					user.setId(id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not insert user into the database");
		} finally {
			try {
				if (generatedKeys != null) {
					generatedKeys.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User read(Integer id) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM users WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int userId = resultSet.getInt("id");
				String nick = resultSet.getString("nick");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				user = User.userInDB(userId, nick, email, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Could not read user from the database");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public Integer read(User entity) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();
			preparedStatement = connexion.prepareStatement("SELECT id FROM users WHERE nick = ? and password = ?");
			preparedStatement.setString(1, entity.getNick());
			preparedStatement.setString(2, entity.getPassword());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				throw new DaoException("Could not read user " + entity.getNick() + " from the database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not read user from the database");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(User user) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE users SET nick = ?, email = ?, password = ? WHERE id = ?");
			preparedStatement.setString(1, user.getNick());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not update user in the database");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM users WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not delete user from the database");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> getAll() throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();

		try {
			connexion = ((DaoFactoryJdbc)daoFactory).getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM users");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int userId = resultSet.getInt("id");
				String nick = resultSet.getString("nick");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				User user = User.userInDB(userId, nick, email, password);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Could not read all users from the database");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}

