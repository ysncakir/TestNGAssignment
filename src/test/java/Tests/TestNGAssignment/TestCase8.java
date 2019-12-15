package Tests.TestNGAssignment;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[type='button']")).click();
        String selectedCountry=driver.findElement(By.id("result")).getText();
        String actualCountry = "You selected: United States of America";
        Assert.assertEquals(actualCountry,selectedCountry, "Country is not correct");
        System.out.println(selectedCountry);




    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
