package kapitel7.teil2;

public class Score {

	private final int a;
	private final int b;

	public Score(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public Score incABy(int points) {
		return new Score(a + points, b);
	}

	public Score incBBy(int points) {
		return new Score(a, b + points);
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

	public static Score ab(int a, int b) {
		return new Score(a, b);
	}

	@Override
	public String toString() {
		return a + ":" + b;
	}

}
