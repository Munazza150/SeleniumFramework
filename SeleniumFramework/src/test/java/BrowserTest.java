import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    public static void main(String[] args) {
        // If you didn't add ChromeDriver to PATH, specify the path explicitly
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\eclipse-workspace\\SeleniumFramework\\src\\main\\resources\\chromedriver-win64\\chromedriver.exe");



        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Perform actions on the web page
        System.out.println("Title: " + driver.getTitle());

        // Close the driver
        driver.quit();
    }
}
