package Pages;

import Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    String price;
    String half;
    String half1;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);

    }

    @FindBy(xpath = "//div[@class='tirp-price-sum']/span")
    WebElement priceInCart;

    public String gettingPrice() {
        price = priceInCart.getText();
        String price1 = price.replace(".00", "");
        half = price1.substring(0, 3);
        half1 = price1.substring(3, 6);
        String symbol = "₹";
        String symbol1 = ",";
        String newPrice = symbol.concat(half).concat(symbol1).concat(half1);
        System.out.println(newPrice);
        return newPrice;
    }
}
