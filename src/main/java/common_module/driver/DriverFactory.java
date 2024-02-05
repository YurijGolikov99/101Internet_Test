package common_module.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static common_module.Global.CHROME_NAME;
import static common_module.Global.FIREFOX_NAME;
import static common_module.Global.SAFARI_NAME;
import static common_module.Global.WEBDRIVER_TYPE;
import static common_module.utils.TimeOuts.ELEMENT_TIMEOUT;
import static common_module.utils.TimeOuts.PAGE_LOAD_TIMEOUT;

public class DriverFactory {

    static WebDriver launchDriver() {
        WebDriver driver;
        if (WEBDRIVER_TYPE.equalsIgnoreCase(CHROME_NAME)) {
            driver = ChromeLauncher.createDriver();
        } else if (WEBDRIVER_TYPE.equalsIgnoreCase(FIREFOX_NAME)) {
            driver = FirefoxLauncher.createDriver();
        } else if (WEBDRIVER_TYPE.equalsIgnoreCase(SAFARI_NAME)) {
            driver = SafariLauncher.createDriver();
        } else {
            driver = ChromeLauncher.createDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
