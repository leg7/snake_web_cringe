package model.beans;

public class MatchDisplayer {
	int opponent_id;
	boolean won;

	public MatchDisplayer(int opponent_id, boolean won) {
		this.opponent_id = opponent_id;
		this.won = won;
	}

	public int getOpponent_id() {
		return opponent_id;
	}
	public void setOpponent_id(int opponent_id) {
		this.opponent_id = opponent_id;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
}
