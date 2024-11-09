package StepsDefinitions;
//
//
//
////import io.cucumber.junit.Cucumber;
////import io.cucumber.junit.CucumberOptions;
////import org.junit.runner.RunWith;
////
////@RunWith(Cucumber.class)
////@CucumberOptions(
////    features = "src/test/resources/features",
////    glue = "StepsDefinitions",
////    plugin = {
////        "pretty",
////        "io.qameta.allure.cucumber5junit.AllureCucumber5JUnit" // Add Allure Cucumber plugin
////    },
////    monochrome = true
////
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/features", // Path to your feature files
//    glue = "StepsDefinitions", // Path to your step definitions
//    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
//    monochrome = true // Makes console output readable
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//}


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import utils.ExtentReportManager;

@CucumberOptions(
    features = "src/main/resources/features", // Path to your feature files
    glue = "StepsDefinitions", // Path to your step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
    monochrome = true // Makes console output readable
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        ExtentReportManager.initExtentReports(); // Initialize Extent Reports
        ExtentReportManager.createTest("Login Test"); // Create a test instance
    }
}
