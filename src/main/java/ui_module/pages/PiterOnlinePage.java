package ui_module.pages;

import common_module.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectPage {
    private WebDriver driver;

    @FindBy(xpath = "(//input[@datatest='main_input_street_home_new'])[1]")
    public WebElement searchStreetField;

    @FindBy(xpath = "//li[@datatest='dropdown_list_main']")
    public WebElement searchStreetDropDown;

    @FindBy(xpath = "(//input[@datatest='main_input_street_home_new'])[2]")
    public WebElement streetNumberField;

    @FindBy(xpath = "(//div[contains(@class, 'app112')])[2]")
    public WebElement tariffsButton;

    public ConnectPage(String url) {
        this.driver = DriverProvider.getDriver();
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchStreetField() {
        return searchStreetField;
    }

    public WebElement getSearchStreetDropDown(){
        return searchStreetDropDown;
    }

    public WebElement getStreetNumberField(){
        return streetNumberField;
    }

    public WebElement getTariffsButton() {
        return tariffsButton;
    }
}
