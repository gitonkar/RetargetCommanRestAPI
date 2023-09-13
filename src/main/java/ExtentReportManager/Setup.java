package ExtentReportManager;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Setup implements ITestListener {

	public static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();	
	// from extentreport

	public void onStart(ITestContext context) {
		// not implemented
		String fileName = ExtentReportUtils.getReportNamewithTimeStamp();
		String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
		System.out.println("fullReportPath "+fullReportPath);
		extentReports = ExtentReportUtils.createExtentreportInstance(fullReportPath, "APIAutoRepo", "TestExeRepo");
		System.out.println("onStart executed..!");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		if (extentReports != null)
			extentReports.flush();
		System.out.println("onFinish executed..!");
	}

	public void onTestStart(ITestResult result) {
		// not implemented
	ExtentTest test=extentReports.createTest(
				"Test Name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
		extentTest.set(test); 
		System.out.println("onTestStart executed..!");
	}
	
	 public void onTestFailure(ITestResult result) {
	        ExtentReportUtils.logFailureDetails(result.getThrowable().getMessage());
	        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
	        stackTrace = stackTrace.replaceAll(",", "<br>");
	        String formmatedTrace = "<details>\n" +
	                "    <summary>Click Here To See Exception Logs</summary>\n" +
	                "    " + stackTrace + "\n" +
	                "</details>\n";
	        ExtentReportUtils.logExceptionDetails(formmatedTrace);
	        System.out.println("onTestFailure executed..!");
	    }
}
