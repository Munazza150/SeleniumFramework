package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initExtentReports() {
        // Create an instance of ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extentReports.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }
    public static void logInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    public static void logPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }

    public static void flushReports() {
        extentReports.flush();
    }

    public static void createTest(String testName) {
        extentTest = extentReports.createTest(testName);
    }
}
