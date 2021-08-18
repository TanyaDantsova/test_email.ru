package test.emailTest.patterns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qualityLaboratory.testTask.AppProperties;

public class SingletonWebDriver {
    private static WebDriver driver;

    private SingletonWebDriver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().version(AppProperties.getProperty("chromeVersion")).setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
