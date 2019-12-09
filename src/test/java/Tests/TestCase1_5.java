package Tests;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1_5 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);

    }

    @Test(description = "verify warning message is 'The date of birth is not valid'")
    public void Test1(){

        driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");
        String actualMessage= driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
        String expectedMessage = "The date of birth is not valid";

        Assert.assertEquals(actualMessage, expectedMessage, "Warning message is not correct");

    }

    @Test(description = "Verify that C++, Java, JavaScript are displayed ")
    public void Test2(){

     List<WebElement>languages = driver.findElements(By.xpath("//label[@class= 'form-check-label']"));
        for(WebElement language : languages){
            System.out.println("Displayed language: "+language.getText());
        }
        }

    @Test(description = "Verify that first name must be more than 2 and less" +
            "than 64 characters long")
    public void Test3(){

        driver.findElement(By.cssSelector("[placeholder='first name']")).sendKeys("y");
        WebElement warning = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        String actualMessage = warning.getText();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualMessage, expectedMessage, "Warning messages are not equal");

    }

    @Test(description = "Verify that last name must be more than 2 and less\" +\n" +
            "than 64 characters long")
    public void Test4(){

        driver.findElement(By.cssSelector("[placeholder='last name']")).sendKeys("y");
        WebElement warning = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        String actualMessage = warning.getText();
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualMessage, expectedMessage, "Warning messages is not correct");

    }

    @Test(description = "Complete registration")
    public void Test5(){
        // input name
        driver.findElement(By.cssSelector("[placeholder='first name']")).sendKeys("yasin");
        BrowserUtils.wait(1);
        // input last name
        driver.findElement(By.cssSelector("[placeholder='last name']")).sendKeys("cakir");
        BrowserUtils.wait(1);
        // input username
        driver.findElement(By.cssSelector("[placeholder= 'username']")).sendKeys("ysncakir");
        BrowserUtils.wait(1);
        // input email
        driver.findElement(By.cssSelector("[placeholder= 'email@email.com']")).sendKeys("simbilli@gmail.com");
        BrowserUtils.wait(1);
        //input password
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("20013957");
        BrowserUtils.wait(1);
        // input phone number
        driver.findElement(By.cssSelector("[placeholder='571-000-0000']")).sendKeys("478-876-5445");
        BrowserUtils.wait(1);
        // select gender
        driver.findElement(By.cssSelector("[value='male']")).click();
        BrowserUtils.wait(1);
        // input DOB
        driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("01/01/1980");
        BrowserUtils.wait(1);
        // select department
        Select select = new Select( driver.findElement(By.cssSelector("[name='department']")));
        select.selectByValue("TRO");
        BrowserUtils.wait(1);
        // select job title
        Select select1 = new Select(driver.findElement(By.cssSelector("[name='job_title']")));
        select1.selectByVisibleText("SDET");
        BrowserUtils.wait(1);
        // select languages
        List<WebElement>languages = driver.findElements(By.xpath("//label[@class= 'form-check-label']"));
        for(WebElement language : languages){
            language.click();
        }
        BrowserUtils.wait(1);
        // submit form
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(1);
        String actualMessage = driver.findElement(By.xpath("//div[@class= 'alert alert-success']/p")).getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(expectedMessage, actualMessage, "Message is not correct");
        BrowserUtils.wait(1);
    }





    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
