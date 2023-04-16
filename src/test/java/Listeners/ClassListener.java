package Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReport;

public class ClassListener implements ITestListener {
	
	ExtentReports extent;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReport.generateExtentReport();
		System.out.println("Execution of project tests started");
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.INFO, "Started Test ......." + result.getName());
		System.out.println("Started Test ......." + result.getName() );
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.PASS, "Passed Test....." + result.getName());
		System.out.println("Passed Test....." + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "\\test-output\\Screenshots\\" + result.getName() + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destination);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, "Failed Test....." + result.getName());
		
		System.out.println("Failed Test....." + result.getName());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, "Skipped Test....." + result.getName());
		System.out.println("Skipped Test....." + result.getName());
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished executing Project Tests");
		extent.flush();
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		System.out.println(result.getName() + "with this much percentage");
		System.out.println(result.getThrowable());
		
	}

	
}
