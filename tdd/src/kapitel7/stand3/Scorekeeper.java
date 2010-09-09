package kapitel7.stand3;

public class Scorekeeper {
	private Score score = new Score(0, 0);
	private Team selectedTeam = Team.NONE;
	private ScoreViewer scoreViewer = ScoreViewer.NULL;
	private final GameTimeService timeService;
	private GameReport gameReport = GameReport.NULL;
	private ScoringPolicy scoringPolicy = ScoringPolicy.DEFAULT;

	public Scorekeeper(GameTimeService timeService) {
		this.timeService = timeService;
	}

	public Score getScore() {
		return score;
	}

	public void teamAClicked() {
		selectedTeam = Team.A;
	}

	public void teamBClicked() {
		selectedTeam = Team.B;
	}

	public void score1Clicked() {
		score(1);
	}

	public void score2Clicked() {
		score(2);
	}

	public void score3Clicked() {
		score(3);
	}

	private void score(int points) {
		int countingPoints = scoringPolicy.countingPoints(points);
		score = selectedTeam.scorePointsOn(countingPoints, score);
		selectedTeam = Team.NONE;
		scoreViewer.display(score);
		gameReport.reportScored(timeService.currentTime(), score);
	}

	public void registerViewer(ScoreViewer viewer) {
		this.scoreViewer = viewer;
		scoreViewer.display(score);
	}

	public void setReport(GameReport report) {
		this.gameReport = report;
	}

	public void setScoringPolicy(ScoringPolicy policy) {
		this.scoringPolicy = policy;
	}
}
