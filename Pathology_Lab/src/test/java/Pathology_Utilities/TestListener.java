package Pathology_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pathology_TestCases.BaseClass;

public class TestListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentReportManager.createTest(result.getName(), result.getMethod().getDescription(), null);
	}

	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.logPass("Test passed");
	}

	/*
	 * public void onTestFailure(ITestResult result) {
	 * ExtentReportManager.logFail("Test failed"); //
	 * ExtentReportManager.attachScreenshot("path/to/screenshot.png",
	 * "Screenshot of failure");
	 * ExtentReportManager.attachScreenshot("ScreenShots/screenshot.png",
	 * "Screenshot of failure"); }
	 */

	public void onTestFailure(ITestResult result) {
		ExtentReportManager.logFail("Test failed");

		String screenshotPath = captureScreenshot(result.getName());
		ExtentReportManager.attachScreenshot(screenshotPath, "Screenshot of failure");
	}

	public String captureScreenshot(String testName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = "ScreenShots/" + testName + "_failure.png";

			FileUtils.copyFile(source, new File(destination));

			return destination;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void onFinish(ITestContext context) {
		ExtentReportManager.flushReport();
	}
}