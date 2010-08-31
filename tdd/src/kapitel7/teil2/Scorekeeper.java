package kapitel7.teil2;

public class Scorekeeper {
	private Score score = new Score(0,0);
	private boolean teamASelected;
	private Team selectedTeam = null;

	public void teamAClicked() {
		teamASelected = true;
	}

	public void teamBClicked() {
		teamASelected = false;
  }

	public void score1Clicked() {
		if (teamASelected) {
			score = score.incA();
		} else {
			score = score.incB();
		}
	}

	public Score getScore() {
		return score;
	}
}
