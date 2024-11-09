package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            // Load properties from the config file
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the browser type
    public static String getBrowser() {
        return properties.getProperty("browser");
    }
    
    // Method to get the base URL
    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    // Method to get the Chrome driver path
    public static String getChromeDriverPath() {
        return properties.getProperty("chromeDriverPath");
    }

    // Generic method to retrieve any key
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
