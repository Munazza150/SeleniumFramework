package StepsDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.loginpage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.ExtentReportManager;
public class TestInvalidlogin {

    private loginpage LoginPage = new loginpage();

    @Before
    public void setup() {
        ExtentReportManager.initExtentReports();
        ExtentReportManager.createTest("Login with Invalid Credentials Test");
    }

    @Given("user is on the login page")
    public void i_am_on_the_sauce_demo_login_page() {
        LoginPage.navigateTo(ConfigReader.get("baseUrl"));
        ExtentReportManager.logInfo("Navigated to SauceDemo login page");
    }

    @When("I enter valid username and invalid password")
    public void i_enter_valid_username_and_invalid_password() {
        String validUsername = ConfigReader.get("username");
        String invalidPassword = "wrong_password";
        LoginPage.login(validUsername, invalidPassword);
        ExtentReportManager.logInfo("Entered valid username and invalid password");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = LoginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        ExtentReportManager.logInfo("Verified error message displayed");
        ExtentReportManager.logPass("Error message is displayed as expected.");
    }

    @After
    public void tearDown() {
        ExtentReportManager.flushReports();
        BrowserUtils.closeDriver();
    }
}

