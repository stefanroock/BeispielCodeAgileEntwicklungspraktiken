package kapitel7.stand4;

import java.io.*;

public class AppendingGameReport implements GameReport {

	private final File reportFile;

	public AppendingGameReport(File reportFile) {
		this.reportFile = reportFile;
	}

	@Override
	public void reportScored(GameTime time, Score newScore) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(reportFile, true));
			writer.print(time);
			writer.print(" ");
			writer.print(newScore);
			writer.println();
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		} finally {
			if (writer != null)
				writer.close();
		}
	}

}
