package Automation;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BasePage {
    public WebDriver driver;

    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @BeforeTest
    public void launchApplication() {
        driver.get("https://www.qatarairways.com/");
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void killSession(){
        driver.quit();
    }

}
