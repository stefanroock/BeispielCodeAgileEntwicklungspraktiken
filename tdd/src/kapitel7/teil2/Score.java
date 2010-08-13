package kapitel7.teil2;

public class Score {

	private final int a;
	private final int b;

	public Score(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public Score incA() {
		return new Score(a+1, b);
	}

	public Score incB() {
		return new Score(a, b+1);
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

}
