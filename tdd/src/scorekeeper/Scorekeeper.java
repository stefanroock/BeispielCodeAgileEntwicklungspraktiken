package scorekeeper;

public class Scorekeeper {
	private int teamAScore = 0;
	private int teamBScore = 0;
	private boolean teamASelected;

	public int getTeamAScore() {
		return teamAScore;
	}

	public int getTeamBScore() {
		return teamBScore;
	}

	public void teamAClicked() {
		teamASelected = true;
	}

	public void teamBClicked() {
		teamASelected = false;
  }

	public void score1Clicked() {
		if (teamASelected)
			teamAScore++;
		else
			teamBScore++;
	}
}
