package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class BrowserUtils {



	    private static WebDriver driver;

	    // Initialize WebDriver based on the browser specified in config.properties
	    public static WebDriver getDriver() {
	        if (driver == null) {
	            String browser = ConfigReader.get("browser");
	            if (browser == null) {
	                throw new RuntimeException("Browser is not specified in config.properties file.");
	            }

	            switch (browser.toLowerCase()) {
	                case "firefox":
	                    System.setProperty("webdriver.gecko.driver", ConfigReader.get("firefoxDriverPath"));
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    System.setProperty("webdriver.edge.driver", ConfigReader.get("edgeDriverPath"));
	                    driver = new EdgeDriver();
	                    break;
	                case "chrome":
	                default:
	                    System.setProperty("webdriver.chrome.driver", ConfigReader.get("chromeDriverPath"));
	                    driver = new ChromeDriver();
	                    break;
	            }

	            // Set an implicit wait (configurable through config.properties)
	            int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }

	    // Generic method to enter text in input fields
	    public static void input(By locator, String text) {
	        WebElement element = getDriver().findElement(locator);
	        element.clear();
	        element.sendKeys(text);
	    }

	    // Generic method to click on elements
	    public static void click(By locator) {
	        WebElement element = getDriver().findElement(locator);
	        element.click();
	    }

	    // Get the current URL
	    public static String getCurrentUrl() {
	        return getDriver().getCurrentUrl();
	    }

	    // Close and quit the WebDriver instance
	    public static void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	}


