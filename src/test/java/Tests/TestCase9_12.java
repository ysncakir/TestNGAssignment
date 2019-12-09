package Tests;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase9_12 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        wait = new WebDriverWait(driver, 10);
    }


    @DataProvider(name = "testData")
    public static Object[][] testData(){
        return new Object[][]{
                {"200", "This page returned a 200 status code"},
                {"301", "This page returned a 301 status code"},
                {"404", "This page returned a 404 status code"},
                {"500", "This page returned a 500 status code"}
        };
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String button, String expectedMessage){

        driver.findElement(By.linkText("Status Codes")).click();
        WebElement link = driver.findElement(By.linkText(button));
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();

        String actualMessage= driver.findElement(By.xpath("//p[contains(text(),\"code\")]")).getText();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(),\"code\")]"))));
        int index = actualMessage.indexOf(".");
        String actualResult= actualMessage.substring(0,index);

        Assert.assertEquals(actualResult, expectedMessage);

    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
