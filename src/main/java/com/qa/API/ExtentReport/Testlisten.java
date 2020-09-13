package com.qa.API.ExtentReport;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Testlisten implements ITestListener {

	public static ExtentTest logger;
	private static ExtentReports extent;
	private static ExtentHtmlReporter HtmlReporter;
	public static String packagename;
	ReportCategory_Conditionalities RCC;
	public static int Sheetnum = 1;
	private static Object[] InputParameters;

	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename = result.getTestClass().getRealClass().getPackage().getName();
		RCC = new ReportCategory_Conditionalities();
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));

	}

	public void onTestSkipped(ITestResult result) {

		logger = extent.createTest(result.getName());
		InputParameters=result.getParameters();
		if (InputParameters != null)
			Sheetnum++;
		packagename = result.getTestClass().getRealClass().getPackage().getName();
		RCC = new ReportCategory_Conditionalities();
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		if (HtmlReporter == null) {
			HtmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "./test-output/STMExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(HtmlReporter);
			extent.setSystemInfo("Host Name", "5CD9229M66");
			extent.setSystemInfo("Environment", "Test");
			extent.setSystemInfo("Test Automation Engineer", "Harsha");
			HtmlReporter.config().setDocumentTitle("Regression Test Report");

			HtmlReporter.config().setReportName("Regression Test Report");

			HtmlReporter.config().setTheme(Theme.STANDARD);
		}
	}

	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		packagename = result.getTestClass().getRealClass().getPackage().getName();
		RCC = new ReportCategory_Conditionalities();
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestStart(ITestResult result) {

	}

}
