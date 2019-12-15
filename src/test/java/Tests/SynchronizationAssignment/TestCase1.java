package Tests.SynchronizationAssignment;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("https://qa1.vytrack.com/");

    }

    @Test(description = "Verify that page subtitle is 'Options'")
    public void test1(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement username =driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager85");
        WebElement Password = driver.findElement(By.id("prependedInput2"));
        Password.sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Actions action = new Actions(driver);


    }



    public void teardown(){
        driver.quit();
    }




}
