package common_module.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLauncher {

    public static WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}