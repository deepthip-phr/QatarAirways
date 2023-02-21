package Tests;

import Automation.BasePage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PLPPage;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HighestPriceFlightTest extends BasePage {
    @Test
    public void highestPriceverification() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        PLPPage plpPage = new PLPPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.acceptCookies();
        homePage.showFlights();
        String highestPriceFlight = plpPage.getPrice();
        plpPage.selectingHighestPriceFlight();
        String priceIncartPage = cartPage.gettingPrice();
        Assert.assertEquals(highestPriceFlight, priceIncartPage);

    }
}
