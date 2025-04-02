package model.beans;

public class Match {
	private Integer id;
	private Integer winner_id;
	private Integer loser_id;

	public Match(Integer winner_id, Integer loser_id) {
		this.winner_id = winner_id;
		this.loser_id  = loser_id;
	}

	public Match(Integer id, Integer winner_id, Integer loser_id) {
		this(winner_id, loser_id);
		this.id = id;
	}

	public Integer getWinner_id() {
		return winner_id;
	}

	public void setWinner_id(Integer winner_id) {
		this.winner_id = winner_id;
	}

	public Integer getLoser_id() {
		return loser_id;
	}

	public void setLoser_id(Integer loser_id) {
		this.loser_id = loser_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
