package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BrowserUtils;

public class loginpage extends Basepage {
	private WebDriver driver = BrowserUtils.getDriver();
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
//    public loginpage enterUsername(String username) {
//        BrowserUtils.input(usernameField, username);
//        return this;
//    }
//
//    public loginpage enterPassword(String password) {
//        BrowserUtils.input(passwordField, password);
//        return this;
//    }
//
//    public loginpage clickLogin() {
//        BrowserUtils.click(loginButton);
//        return this;
//    }

    public String getErrorMessage() {
        return BrowserUtils.getDriver().findElement(errorMessage).getText();
    }
}

