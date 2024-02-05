package ui;

import common_module.driver.DriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ui_module.steps.PiterOnlineSteps;

public class TestAutomation {

    @Before
    public void setUp() {
        DriverProvider.getDriver().get("https://piter-online.net/");
    }

    @Test
    public void test() {
        PiterOnlineSteps piterOnlinePageSteps = new PiterOnlineSteps();
        piterOnlinePageSteps.enterAddressData();
        piterOnlinePageSteps.closeModalWindow();
        piterOnlinePageSteps.connectTariffMultipleTimes();
        piterOnlinePageSteps.checkApplicationStatuses();
    }

    @After
    public void tearDown() {
        DriverProvider.tearDown();
    }
}
