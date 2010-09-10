package kapitel7.stand4;

public class GameTime {

	public static final GameTime UNAVAILABLE = new GameTime(0,0);
	private final int quarter;
	private final int minute;

	public GameTime(int quarter, int minute) {
		this.quarter = quarter;
		this.minute = minute;
	}

	public int getQuarter() {
		return quarter;
	}

	public int getMinute() {
		return minute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + minute;
		result = prime * result + quarter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameTime other = (GameTime) obj;
		if (minute != other.minute)
			return false;
		if (quarter != other.quarter)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Q" + quarter + ":" + minute + "'";
	}
}
