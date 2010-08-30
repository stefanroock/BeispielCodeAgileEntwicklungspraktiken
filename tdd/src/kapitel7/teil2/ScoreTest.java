package kapitel7.teil2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void newScoreStoresCreationValuesForBothTeams() {
		Score score = new Score(3,5);
		assertEquals(3, score.getA());
		assertEquals(5, score.getB());
	}
	
	@Test
	public void incrementingScoreOfTeamAReturnsNewScoreObject() {
		Score score = new Score(1,0);
		Score incrementedScore = score.incA();
		assertNotSame(score, incrementedScore);
		assertEquals(2, incrementedScore.getA());
		assertEquals(0, incrementedScore.getB());
		fail(); // to remind me where to continuer after my vacation
	}
}
