package kapitel7.teil2;

public class Scorekeeper {
	private Score score = new Score(0,0);
	private boolean teamASelected;

	public int getTeamAScore() {
		return score.getA();
	}

	public int getTeamBScore() {
		return score.getB();
	}

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
}
