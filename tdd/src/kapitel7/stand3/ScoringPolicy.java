package kapitel7.stand3;

public interface ScoringPolicy {

	ScoringPolicy DEFAULT = new ScoringPolicy() {
		@Override
		public int countingPoints(int shotDistance) {
			return shotDistance;
		}
	};

	int countingPoints(int shotDistance);

}
