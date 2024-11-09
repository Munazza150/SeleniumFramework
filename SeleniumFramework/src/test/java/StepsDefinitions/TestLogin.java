package StepsDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.loginpage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.ExtentReportManager;
public class TestLogin {
	

	    private loginpage LoginPage = new loginpage();

	    @Before
	    public void setup() {
	        ExtentReportManager.initExtentReports();
	        ExtentReportManager.createTest("Login with Valid Credentials Test");
	    }

	    @Given("I am on the SauceDemo login page")
	    public void i_am_on_the_sauce_demo_login_page() {
	        LoginPage.navigateTo(ConfigReader.get("baseUrl"));
	        ExtentReportManager.logInfo("Navigated to SauceDemo login page");
	    }

	    @When("I enter valid username and valid password")
	    public void i_enter_valid_username_and_valid_password() {
	        String validUsername = ConfigReader.get("username");
	        String validPassword = ConfigReader.get("password");
	        LoginPage.login(validUsername, validPassword);
	        ExtentReportManager.logInfo("Entered valid username and valid password");
	    }

	    @Then("I should land on the dashboard")
	    public void i_should_land_on_the_dashboard() {
	        Assert.assertTrue(BrowserUtils.getCurrentUrl().contains("inventory"));
	        ExtentReportManager.logInfo("Verified that user has landed on the dashboard");
	        ExtentReportManager.logPass("User has landed on the dashboard successfully.");
	    }

	    @After
	    public void tearDown() {
	        ExtentReportManager.flushReports();
	        BrowserUtils.closeDriver();
	    }
	}
