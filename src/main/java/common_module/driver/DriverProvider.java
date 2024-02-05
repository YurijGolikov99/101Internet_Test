package common_module.driver;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.launchDriver();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
