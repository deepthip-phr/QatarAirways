package Actions;

import Waits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;
    Actions actions;

    public SeleniumActions(WebDriver driver) {
        seleniumWaits = new SeleniumWaits(driver);
        this.driver = driver;
    }

    public boolean clickOnWebElementUsingText(String idValue, String text) {
        try {
            seleniumWaits.givingImplicitWait();
            driver.findElement(By.xpath("//input[@id='" + idValue + "']/parent::span//div[@class='suggestion-list']/div/div/strong[text()='" + text + "']")).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDate(String monthAndYear, String date) {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//table[@class='t-table-condensed']/thead/tr/th[text()='" + monthAndYear + "']/ancestor::table//tbody/tr/td[contains(@aria-label,'" + date + "')]"))).build().perform();
        driver.findElement(By.xpath("//table[@class='t-table-condensed']/thead/tr/th[text()='" + monthAndYear + "']/ancestor::table//tbody/tr/td[contains(@aria-label,'" + date + "')]")).click();
    }
}
