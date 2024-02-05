package ui_module.pages;

import common_module.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeningradRatesPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@datatest='close_popup1_from_quiz_input_tel']")
    public WebElement modalWindowCloseButton;
    @FindBy(xpath = "(//div[@datatest='providers_form_inspect_connect_tariff_button'])[1]")
    public WebElement connectTariffButton;
    @FindBy(xpath = "//input[@datatest='popup_tariff_order_input_tel']")
    public WebElement tariffPhoneNumberField;
    @FindBy(xpath = "//div[@data-test='popup_tariff_order_form_input_connect_button']")
    public WebElement inputConnectButton;
    @FindBy(xpath = "//div[@data-test='give_feedback']")
    public WebElement thanksButton;

    public LeningradRatesPage(String url) {
        this.driver = DriverProvider.getDriver();
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public WebElement getModalWindowCloseButton(){
        return  modalWindowCloseButton;
    }

    public WebElement getConnectTariffButton(){
        return connectTariffButton;
    }

    public WebElement getTariffPhoneNumberField(){
        return tariffPhoneNumberField;
    }

    public WebElement getInputConnectButton(){
        return inputConnectButton;
    }

    public WebElement getThanksButton(){
        return thanksButton;
    }
}
