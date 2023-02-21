package Pages;

import Actions.SeleniumActions;
import Waits.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PLPPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    int maximumPrice;
    SeleniumWaits seleniumWaits;
    String price;
    String values2;
    String half;
    String half1;
    String maxPriceWithSymbol;

    public PLPPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(css = "h5[class$='at-BUSINESS']~h3[class^='cabin-class-price']")
    List<WebElement> priceList;


    public String getPrice() throws InterruptedException {
        ArrayList<Integer> priceValuelist = new ArrayList<Integer>();
        Thread.sleep(10000);
        // seleniumWaits.givingImplicitWait();
        for (int i = 0; i < priceList.size(); i++) {
            price = priceList.get(i).getText();
            String values = price.replace("₹", "");
            values2 = values.replace(",", "");
            int priceValues = Integer.parseInt(values2);
            priceValuelist.add(priceValues);
            maximumPrice = Collections.max(priceValuelist);
            String maxPrice = Integer.toString(maximumPrice);
            half = maxPrice.substring(0, 3);
            half1 = maxPrice.substring(3, 6);
            String symbol = "₹";
            String symbol1 = ",";
            maxPriceWithSymbol = symbol.concat(half).concat(symbol1).concat(half1);
        }
        System.out.println(maxPriceWithSymbol);

        return maxPriceWithSymbol;

    }

    public void selectingHighestPriceFlight() {
        driver.findElement(By.xpath("//span[text()='" + maxPriceWithSymbol + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + maxPriceWithSymbol + "']/parent::h3/following-sibling::div/button[normalize-space()='Select fare']")).click();
        driver.findElement(By.xpath("//div[starts-with(@class,'pos-center')]/div/button[normalize-space()='Continue']")).click();
    }
}
