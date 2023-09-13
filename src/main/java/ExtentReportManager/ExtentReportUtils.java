package ExtentReportManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ExtentReportUtils {

	public static ExtentReports extentReports;

	public static ExtentReports createExtentreportInstance(String filename, String reportname, String doctitle) {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filename);
		extentSparkReporter.config().setReportName(reportname);
		extentSparkReporter.config().setDocumentTitle(doctitle);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setEncoding("utf-8");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}

	public static String getReportNamewithTimeStamp() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		String reportName = "TestReport" + formattedTime + ".html";
		return reportName;
	}

	public static void logPassDetails(String log) {
		Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));

	}

	public static void logFailDetails(String log) {
		Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));

	}

	public static void logInfoDetails(String log) {
		Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.BROWN));

	}

	public static void logWarningDetails(String log) {
		Setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.LIME));
	}

	public static void logJson(String json) {
		Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	}

	public static void logHeaders(List<Header> headersList) {
		String[][] arrayHeaders = headersList.stream()
				.map(header -> new String[] { header.getName(), header.getValue() }).toArray(String[][]::new);
		Setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
	}

	public static void logFailureDetails(String log) {
		// TODO Auto-generated method stub
		Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
		
	}

	public static void logExceptionDetails(String log) {
		// TODO Auto-generated method stub
		Setup.extentTest.get().fail(log);
	}

}
