package kapitel7.stand3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TeamTest {

	@Test
	public void scoring1OnTeamAIncreasesScoreForAByOne() {
		Score newScore = Team.A.scorePointsOn(1, Score.ab(2, 7));
		assertEquals(Score.ab(3, 7), newScore);
	}

	@Test
	public void scoring3OnTeamBIncreasesScoreForBByThree() {
		Score newScore = Team.B.scorePointsOn(3, Score.ab(2, 7));
		assertEquals(Score.ab(2, 10), newScore);
	}

	@Test
	public void scoringOnTeamNONEdoesNotChangeScore() {
		Score newScore = Team.NONE.scorePointsOn(3, Score.ab(2, 7));
		assertEquals(Score.ab(2, 7), newScore);
	}
}
