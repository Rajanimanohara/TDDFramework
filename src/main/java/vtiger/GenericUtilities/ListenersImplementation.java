package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains implementation for ITestListeners interface of TestNG
 * @author Rajani
 *
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName =result.getMethod().getMethodName();
		//System.out.println(methodName+"----- Execution Stared ----");
		
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName =result.getMethod().getMethodName();
		//System.out.println(methodName+"----- PASS ----");
		
		test.log(Status.PASS, methodName+"----- PASS ----");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String methodName =result.getMethod().getMethodName();
		
		
		test.log(Status.FAIL, methodName+"--FAIL---");
		test.log(Status.INFO, result.getThrowable());
		
		String ScreenshotName = methodName+"="+jUtil.getSystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver, ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName =result.getMethod().getMethodName();
		//System.out.println(methodName+"----- SKIP ----");
		
		test.log(Status.SKIP, methodName+"----- SKIP ----");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("Suite execution started");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("ONEAIR EXECUTION REPORT");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Reporter Name", "Rajani");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution finished");
		
		report.flush();
		
	}
}
