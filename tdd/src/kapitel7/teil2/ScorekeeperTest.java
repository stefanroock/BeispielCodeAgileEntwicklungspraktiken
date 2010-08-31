package kapitel7.teil2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ScorekeeperTest {
	private Scorekeeper scorekeeper;

	@Before
	public void init() {
		scorekeeper = new Scorekeeper();
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

	private void assertScore(int expectedAScore, int expectedBScore) {
		assertEquals(Score.ab(expectedAScore, expectedBScore), scorekeeper.getScore());
	}
}
