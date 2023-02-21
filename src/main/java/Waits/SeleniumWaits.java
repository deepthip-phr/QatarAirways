package Waits;

import Constants.WaitTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumWaits {
    WebDriverWait webDriverWait;
    WebDriver driver;
    WaitTime waitTime;

    public SeleniumWaits(WebDriver driver) {
        this.driver = driver;

        waitTime = new WaitTime();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime.EXPLICITWAIT));

    }

    public void waitForElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void givingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime.IMPLICITWAIT));

    }

    public void killingImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime.KILLIMPLICITWAIT));

    }
}
