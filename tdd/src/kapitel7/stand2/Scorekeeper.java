package kapitel7.stand2;

public class Scorekeeper {
	private Score score = new Score(0, 0);
	private Team selectedTeam = Team.NONE;

	public void teamAClicked() {
		selectedTeam = Team.A;
	}

	public void teamBClicked() {
		selectedTeam = Team.B;
	}

	public void score1Clicked() {
		score = selectedTeam.scorePointsOn(1, score);
		selectedTeam = Team.NONE;
	}

	public Score getScore() {
		return score;
	}
}
