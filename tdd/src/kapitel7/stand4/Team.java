package kapitel7.stand4;

public enum Team {
	A {
		@Override
		public Score scorePointsOn(int points, Score score) {
			return score.incABy(points);
		}
	},

	B {
		@Override
		public Score scorePointsOn(int points, Score score) {
			return score.incBBy(points);
		}
	},

	NONE {
		@Override
		public Score scorePointsOn(int points, Score score) {
			return score;
		}
	};

	public abstract Score scorePointsOn(int points, Score score);

}
