package kapitel7.stand3;

public interface GameReport {

	GameReport NULL = new GameReport() {
		@Override
		public void reportScored(int quarter, int minute, Score newScore) {
		}
	};

	void reportScored(int quarter, int minute, Score newScore);

}
