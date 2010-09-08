package kapitel7.stand3;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTimeTest {

	@Test
	public void newGameTimeStoresQuarterAndMinute() {
		GameTime time = new GameTime(1, 9);
		assertEquals(1, time.getQuarter());
		assertEquals(9, time.getMinute());
	}
	
	@Test
	public void gameTimesAreEqualWhenTheirValuesAreEqual() {
		assertTrue(new GameTime(1, 4).equals(new GameTime(1, 4)));
		assertFalse(new GameTime(1, 5).equals(new GameTime(1, 4)));
		assertFalse(new GameTime(2, 4).equals(new GameTime(1, 4)));
		assertFalse(new GameTime(4, 1).equals(null));
		assertFalse(new GameTime(4, 1).equals(new Object()));
	}
	
	@Test
	public void equalGameTimesReturnSameHashCode() {
		assertEquals(new GameTime(4, 10).hashCode(), new GameTime(4, 10).hashCode());
	}
	
	@Test
	public void toStringIncludesQuarterAndMinute() {
		GameTime time = new GameTime(1, 10);
		assertTrue(time.toString().contains("Q1"));
		assertTrue(time.toString().contains("10'"));
	}
}
