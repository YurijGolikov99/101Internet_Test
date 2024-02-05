package ui_module.steps;

import common_module.driver.DriverProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_module.constants.UiEndpoints;
import ui_module.pages.LeningradRatesPage;
import ui_module.pages.PiterOnlinePage;

import java.time.Duration;

public class PiterOnlineSteps {
    private static final String CITY_URL = UiEndpoints.PITER.getUrl();
    private final static PiterOnlinePage piterOnlinePage = new PiterOnlinePage(CITY_URL);
    private final static LeningradRatesPage leningradRatesPage = new LeningradRatesPage(CITY_URL);

    public void fillStreetField() {
        piterOnlinePage.getSearchStreetField().sendKeys("Тестовая линия");
        piterOnlinePage.getSearchStreetDropDown().click();
    }

    public void fillNumberField() {
        piterOnlinePage.getStreetNumberField().sendKeys("1");
        piterOnlinePage.getStreetNumberField().click();
    }

    public void clickTariffsButton() {
        piterOnlinePage.getTariffsButton().click();
    }

    public void enterAddressData() {
        fillStreetField();
        fillNumberField();
        clickTariffsButton();
    }

    private void waitForVisibility(WebElement element) {
        new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void closeModalWindow() {
        WebElement closeButton = leningradRatesPage.getModalWindowCloseButton();
        ((JavascriptExecutor) DriverProvider.getDriver()).executeScript("arguments[0].click();", closeButton);
    }

    public void clickConnectTariffButton() {
        leningradRatesPage.getConnectTariffButton().click();
    }

    public void enterPhoneNumber() {
        leningradRatesPage.getTariffPhoneNumberField().sendKeys("1111111111");
    }

    public void clickInputConnectButton() {
        leningradRatesPage.getInputConnectButton().click();
    }

    public void clickThanksButton() {
        leningradRatesPage.getThanksButton().click();
    }

    public void connectTariffMultipleTimes() {
        for (int i = 0; i < 5; i++) {
            try {
                clickConnectTariffButton();
                enterPhoneNumber();
                clickInputConnectButton();
                clickThanksButton();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Retrying...");
            }
        }
    }

    public void checkApplicationStatuses() {
        String apiUrl = "https://piter-online.net/api/orders?type=site101-callback";

        Response response = RestAssured.get(apiUrl);

        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
            System.out.println("All applications have status 201.");
        } else {
            System.out.println("Some applications do not have status 201.");
        }
    }
}
