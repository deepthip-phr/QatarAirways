package Pages;

import Actions.SeleniumActions;
import Waits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;
    Actions actions;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);

    }

    @FindBy(id = "cookie-close-accept-all")
    WebElement acceptAll;
    @FindBy(xpath = "//input[@id='bw-from']/parent::span//div[@class='suggestion-list']")
    WebElement fromSuggestList;
    @FindBy(id = "bw-from")
    WebElement fromInputBox;
    @FindBy(id = "bw-to")
    WebElement toInputBox;

    @FindBy(xpath = "//input[@id='bw-to']/parent::span//div[@class='suggestion-list']")
    WebElement toSuggestList;
    @FindBy(css = "#tripType")
    WebElement tripTypeButton;
    @FindBy(id = "onewayTrip")
    WebElement oneWayTrip;
    @FindBy(xpath = "//button[text()='Clear']/following-sibling::button")
    WebElement continueButton;

    @FindBy(xpath = "//button[text()='Show flights']")
    WebElement showFlightsButton;


    public void acceptCookies() {
        seleniumWaits = new SeleniumWaits(driver);
        seleniumWaits.waitForElement(acceptAll);
        acceptAll.click();
    }

    public void showFlights() throws InterruptedException {
        fromInputBox.click();
        boolean status = fromSuggestList.isDisplayed();
        if (status = true) {
            Thread.sleep(2000);
            // seleniumWaits.givingImplicitWait();
            seleniumActions.clickOnWebElementUsingText("bw-from", "Hyderabad");
        }
        toInputBox.click();
        boolean status1 = toSuggestList.isDisplayed();
        if (status1 = true) {
            //Thread.sleep(2000);
            seleniumWaits.givingImplicitWait();

            seleniumActions.clickOnWebElementUsingText("bw-to", "Abidjan");
        }
        seleniumWaits.waitForElement(tripTypeButton);
         actions = new Actions(driver);
        actions.moveToElement(tripTypeButton);
        tripTypeButton.click();
        Thread.sleep(3000);
        //seleniumWaits.givingImplicitWait();
        oneWayTrip.click();
        Thread.sleep(3000);
        //seleniumWaits.givingImplicitWait();
        seleniumActions.selectDate("March 2023", "24");
        continueButton.click();
        showFlightsButton.click();
    }


}
