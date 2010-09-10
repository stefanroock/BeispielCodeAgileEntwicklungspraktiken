package kapitel7.stand4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppendingGameReportTest {

	private File reportFile;
	private AppendingGameReport report;

	@Before
	public void initialize() throws IOException {
		reportFile = File.createTempFile("game-report", "txt");
		report = new AppendingGameReport(reportFile);
	}

	@After
	public void release() {
		reportFile.delete();
	}

	@Test
	public void singleScoreReportAppendsOneLineEntry() throws Exception {
		report.reportScored(new GameTime(1, 9), Score.ab(2, 9));
		assertReportFileContents("Q1:9' 2:9");
	}

	private void assertReportFileContents(String expected) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(reportFile));
			assertEquals("line", expected, reader.readLine());
			assertNull("no more lines", reader.readLine());
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
