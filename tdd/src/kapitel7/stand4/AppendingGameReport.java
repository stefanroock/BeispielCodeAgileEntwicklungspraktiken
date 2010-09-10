package kapitel7.stand4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendingGameReport implements GameReport {

	private final File reportFile;

	public AppendingGameReport(File reportFile) {
		this.reportFile = reportFile;
	}

	@Override
	public void reportScored(GameTime time, Score newScore) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(reportFile));
			writer.print(time);
			writer.print(" ");
			writer.print(newScore);
			writer.println();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
