package kapitel7.stand4;

public interface ScoringPolicy {

	ScoringPolicy DEFAULT = new ScoringPolicy() {
		@Override
		public int countingPoints(int shotDistance) {
			return shotDistance;
		}
	};

	int countingPoints(int shotDistance);

}
