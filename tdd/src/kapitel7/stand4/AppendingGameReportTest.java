package kapitel7.stand4;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

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

	@Test
	public void multipleScoreReportsAreAppendedInOrder() throws Exception {
		report.reportScored(new GameTime(1, 9), Score.ab(2, 9));
		report.reportScored(new GameTime(2, 5), Score.ab(15, 23));
		assertReportFileContents("Q1:9' 2:9", "Q2:5' 15:23");
	}

	@Test
	public void ifNotExistantReportFileIsCreated() throws Exception {
		assertTrue(reportFile.delete());
		report.reportScored(new GameTime(1, 9), Score.ab(2, 9));
		assertTrue(reportFile.exists());
	}

	@Test(expected = RuntimeException.class)
	public void ioExceptionDuringReportingWillBePropagatedAsRTE() throws Exception {
		reportFile.setReadOnly();
		report.reportScored(new GameTime(1, 9), Score.ab(2, 9));
	}
	
	private void assertReportFileContents(String ... expectedLines) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(reportFile));
			for (String expectedLine : expectedLines) {
				assertEquals("line", expectedLine, reader.readLine());
			}
			assertNull("no more lines", reader.readLine());
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
