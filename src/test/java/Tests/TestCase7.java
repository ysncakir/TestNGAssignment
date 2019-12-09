package Tests;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "File Uploaded")
    public void Test7(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/ysncakir/Desktop/deneme ");
        driver.findElement(By.id("file-submit")).click();
        String file =driver.findElement(By.cssSelector("[class='example']")).getText();
        System.out.println(file);



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
