package ListenersUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestNG.BaseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener {
public ExtentReports report;
public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Date d = new Date();
		String newDate= d.toString().replace(" ","_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
		spark.config().setDocumentTitle("Sauce");
		spark.config().setReportName("SauceResults");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		Reporter.log("report config", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		
		report.flush();
		Reporter.log("report backup", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		test = report.createTest(testname);
		test.log( Status.INFO,"===" +testname+"Execution STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname = result.getMethod().getMethodName();
		test.log(Status.PASS, "===="+testname+"Execution PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Date d = new Date();
		String newDate= d.toString().replace(" ","_").replace(":", "_");
		
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sdriver;
		String temp= ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
	//	File perm = new File("./src/test/resources/"+newDate+".png");
		//try {
			//FileHandler.copy(temp, perm);
	//	}catch(IOException e){
		//	e.printStackTrace();
		//}

		String testname = result.getMethod().getMethodName();
		test.log(Status.FAIL,"===="+testname+"Execution FAIL");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		test.log(Status.SKIP,"===="+testname+"Execution Skipped");
	}

}
