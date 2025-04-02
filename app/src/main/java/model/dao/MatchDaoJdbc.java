package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Match;

public class MatchDaoJdbc extends Dao<Match, Integer> {

	public MatchDaoJdbc(DaoFactory f) {
		super(f);
	}

	@Override
	public void create(Match entity) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ((DaoFactoryJdbc)daoFactory).getConnection();
			statement = connection.prepareStatement("insert into matches(winner_id, loser_id) values(?, ?)");
			statement.setInt(1, entity.getWinner_id());
			statement.setInt(2, entity.getLoser_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not insert match into the database");
		} finally {
			try {
				if (connection != null) connection.close();
				if (statement != null) statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Match read(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ((DaoFactoryJdbc)daoFactory).getConnection();
			statement = connection.prepareStatement("select (winner_id, loser_id) from matches where id = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Integer winner_id = resultSet.getInt("winner_id");
				Integer loser_id = resultSet.getInt("loser_id");
				return new Match(id, winner_id, loser_id);
			} else {
				throw new DaoException("Could not find match of id " + id + " in the database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not read match from the database");
		} finally {
			try {
				if (connection != null) connection.close();
				if (statement != null) statement.close();
				if (resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer read(Match entity) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Integer id = -1;

		try {
			connection = ((DaoFactoryJdbc)daoFactory).getConnection();
			statement = connection.prepareStatement("select id from matches where winner_id = ? and loser_id = ?");
			statement.setInt(1, entity.getWinner_id());
			statement.setInt(2, entity.getLoser_id());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				throw new DaoException("Could not find match of winner_id " + entity.getWinner_id() + " and loser_id " + entity.getLoser_id() + " in the database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not read match from the database");
		} finally {
			try {
				if (connection != null) connection.close();
				if (statement != null) statement.close();
				if (resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Match entity) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ((DaoFactoryJdbc) daoFactory).getConnection();
			// Assuming entity.getId() returns a valid id for an existing match.
			statement = connection.prepareStatement("UPDATE matches SET winner_id = ?, loser_id = ? WHERE id = ?");
			statement.setInt(1, entity.getWinner_id());
			statement.setInt(2, entity.getLoser_id());
			statement.setInt(3, entity.getId());
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new DaoException("No match found with id " + entity.getId() + " to update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not update match in the database");
		} finally {
			try {
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ((DaoFactoryJdbc) daoFactory).getConnection();
			statement = connection.prepareStatement("DELETE FROM matches WHERE id = ?");
			statement.setInt(1, id);
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new DaoException("No match found with id " + id + " to delete");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not delete match from the database");
		} finally {
			try {
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Match> getAll() throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Match> matches = new ArrayList<>();

		try {
			connection = ((DaoFactoryJdbc) daoFactory).getConnection();
			statement = connection.prepareStatement("SELECT id, winner_id, loser_id FROM matches");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int winner_id = resultSet.getInt("winner_id");
				int loser_id = resultSet.getInt("loser_id");
				matches.add(new Match(id, winner_id, loser_id));
			}
			return matches;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Could not retrieve matches from the database");
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
