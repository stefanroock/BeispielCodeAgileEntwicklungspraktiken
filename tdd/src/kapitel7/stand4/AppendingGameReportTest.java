package kapitel7.stand4;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class AppendingGameReportTest {

	@Test
	public void singleScoreReportAppendsOneLineEntry() throws Exception {
		File reportFile = File.createTempFile("game-report", "txt");
		AppendingGameReport report = new AppendingGameReport(reportFile);
		report.reportScored(new GameTime(1,9), Score.ab(12, 19));
		BufferedReader reader = new BufferedReader(new FileReader(reportFile));
		assertEquals("Q1:9' 12:19", reader.readLine());
		assertNull(reader.readLine());
	}
}
