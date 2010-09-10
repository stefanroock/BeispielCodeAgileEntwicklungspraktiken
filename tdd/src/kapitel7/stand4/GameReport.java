package kapitel7.stand4;

public interface GameReport {

	GameReport NULL = new GameReport() {
		@Override
		public void reportScored(GameTime time, Score newScore) {
		}
	};

	void reportScored(GameTime time, Score newScore);

}
