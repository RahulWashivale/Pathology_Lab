package Pathology_Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    public static ExtentReports getInstance(String ReportPath,String reportName) {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(ReportPath+"/"+reportName);
            htmlReporter.config().setTheme(Theme.DARK);
            
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description, String category) {
        test = getInstance("TestReport","test-report.html").createTest(testName, description);
        if (category != null) {
            test.assignCategory(category);
        }
        return test;
    }

    public static void logInfo(String message) {
        test.log(Status.INFO, message);
    }

    public static void logPass(String message) {
        test.log(Status.PASS, message);
    }

    public static void logFail(String message) {
        test.log(Status.FAIL, message);
    }

    public static void attachScreenshot(String imagePath, String description) {
        try {
            test.fail(description, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void flushReport() {
        getInstance("TestReport","test-report.html").flush();
    }
}