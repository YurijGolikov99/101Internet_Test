package ui_module.steps;

import ui_module.constants.UiEndpoints;
import ui_module.pages.LeningradRatesPage;
import ui_module.pages.PiterOnlinePage;

public class PiterOnlinePageSteps {
    private static final String CITY_URL = UiEndpoints.PITER.getUrl();
    private final static PiterOnlinePage piterOnlinePage = new PiterOnlinePage(CITY_URL);
    private final static LeningradRatesPage leningradRatesPage = new LeningradRatesPage(CITY_URL);

    public void fillStreetField(){
        piterOnlinePage.getSearchStreetField().sendKeys("Тестовая линия");
        piterOnlinePage.getSearchStreetDropDown().click();
    }

    public void fillNumberField(){
        piterOnlinePage.getStreetNumberField().sendKeys("1");
        piterOnlinePage.getStreetNumberField().click();
    }

    public void clickTariffsButton(){
        piterOnlinePage.getTariffsButton().click();
    }

    public void enterAddressData(){
        fillStreetField();
        fillNumberField();
        clickTariffsButton();
    }

    public void enterPhoneNumber(){
        leningradRatesPage.getPhoneNumberField().click();
        leningradRatesPage.getPhoneNumberField().sendKeys("1111111111");
    }

    public void clickShowTariffsButton(){
        leningradRatesPage.getTariffsButton().click();
    }

}


//    public void runTestMultipleTimes() {
//        for (int i = 0; i < 5; i++) {
//            // Повторить пункты 2-3 пять раз.
//            enterAddressData();
//        }
//    }
//
//}
