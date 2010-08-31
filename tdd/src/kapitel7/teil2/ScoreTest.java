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
	}

	@Test
	public void incrementingScoreOfTeamBReturnsNewScoreObject() {
		Score score = new Score(2,0);
		Score incrementedScore = score.incB();
		assertNotSame(score, incrementedScore);
		assertEquals(1, incrementedScore.getB());
	}
	
	@Test
	public void scoresAreEqualWhenTheirValuesAreEqual() {
		assertTrue(new Score(1,4).equals(new Score(1,4)));
		assertFalse(new Score(4,1).equals(new Score(1,4)));
	}
	
	@Test
	public void staticFactoryMethodCreatesScoreObjects() {
		assertEquals(new Score(22,33), Score.ab(22,33));
	}
}
