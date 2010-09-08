package kapitel7.stand3;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class ScorekeeperTest {
	private Scorekeeper scorekeeper;
	private GameTimeService timeService;

	@Before
	public void init() {
		timeService = mock(GameTimeService.class);
		scorekeeper = new Scorekeeper(timeService);
	}

	@Test
	public void initialScoreIs0to0() {
		assertScore(0, 0);
	}

	@Test
	public void teamAScoresOnePoint() {
		scorekeeper.teamAClicked();
		scorekeeper.score1Clicked();
		assertScore(1, 0);
	}

	@Test
	public void teamBScoresOnePoint() {
		scorekeeper.teamBClicked();
		scorekeeper.score1Clicked();
		assertScore(0, 1);
	}

	@Test
	public void clickOnlyTeamButtonDoesNotRaiseScore() {
		scorekeeper.teamAClicked();
		assertScore(0, 0);
	}

	@Test
	public void teamBScoresAfterTeamA() {
		scorekeeper.teamAClicked();
		scorekeeper.score1Clicked();
		assertScore(1, 0);
		scorekeeper.teamBClicked();
		scorekeeper.score1Clicked();
		assertScore(1, 1);
	}

	@Test
	public void clickingScoreWithoutTeamSelectionIsIgnored() {
		scorekeeper.score1Clicked();
		scorekeeper.score2Clicked();
		scorekeeper.score3Clicked();
		assertScore(0, 0);
	}

	@Test
	public void onlyFirstClickOnScoreCounts() {
		scorekeeper.teamAClicked();
		scorekeeper.score1Clicked();
		assertScore(1, 0);
		scorekeeper.score1Clicked();
		scorekeeper.score1Clicked();
		assertScore(1, 0);
	}

	@Test
	public void scoring2Points() {
		scorekeeper.teamAClicked();
		scorekeeper.score2Clicked();
		assertScore(2, 0);
	}

	@Test
	public void scoring3Points() {
		scorekeeper.teamBClicked();
		scorekeeper.score3Clicked();
		assertScore(0, 3);
	}

	@Test
	public void registeringScoreViewerDisplaysCurrentScore() {
		ScoreViewer viewer = mock(ScoreViewer.class);
		scorekeeper.registerViewer(viewer);
		verify(viewer).display(Score.ab(0, 0));
	}

	@Test
	public void scoreViewerIsNotifiedOfChangedScore() {
		ScoreViewer viewer = mock(ScoreViewer.class);
		scorekeeper.registerViewer(viewer);
		scorekeeper.teamAClicked();
		scorekeeper.score1Clicked();
		scorekeeper.teamBClicked();
		scorekeeper.score3Clicked();
		InOrder scoreChanges = inOrder(viewer);
		scoreChanges.verify(viewer).display(Score.ab(1, 0));
		scoreChanges.verify(viewer).display(Score.ab(1, 3));		
	}
	
	@Test
	public void scoringReportsNewScoreWithCurrentTime() {
		GameReport report = mock(GameReport.class);
		scorekeeper.setReport(report);
		when(timeService.currentQuarter()).thenReturn(2);
		when(timeService.currentMinute()).thenReturn(9);
		scorekeeper.teamBClicked();
		scorekeeper.score2Clicked();
		verify(report).reportScored(2, 9, Score.ab(0, 2));
	}
	
	private void assertScore(int expectedAScore, int expectedBScore) {
		assertEquals(Score.ab(expectedAScore, expectedBScore),
				scorekeeper.getScore());
	}
}
