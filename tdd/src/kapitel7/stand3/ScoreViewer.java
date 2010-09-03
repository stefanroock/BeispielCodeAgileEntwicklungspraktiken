package kapitel7.stand3;

public interface ScoreViewer {

	ScoreViewer NULL = new ScoreViewer() {
		@Override
		public void display(Score currentScore) {
		}
	};

	void display(Score currentScore);

}
