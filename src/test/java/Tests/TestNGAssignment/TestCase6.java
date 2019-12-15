package Tests.TestNGAssignment;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
     private WebDriver driver;

     @BeforeMethod
     public void setup(){
            driver = BrowserFactory.getDriver("chrome");
            driver.get("https://www.tempmailaddress.com/");
     }

     @Test(description = "signing up with email from tempmailaddress.com")
     public void Test6(){
         String email = driver.findElement(By.id("email")).getText();
         driver.navigate().to("http://practice.cybertekschool.com/");
         BrowserUtils.wait(2);
         System.out.println(email);
         driver.findElement(By.linkText("Sign Up For Mailing List")).click();
         driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Erdal Bakkal");
         driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
         BrowserUtils.wait(1);
         driver.findElement(By.cssSelector("[name='wooden_spoon']")).click();
         BrowserUtils.wait(1);
         String actualMessage = driver.findElement(By.cssSelector("[name='signup_message']")).getText();
         String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
         Assert.assertEquals(expectedMessage, actualMessage, "Message is not correct");
         driver.navigate().to("https://www.tempmailaddress.com/");
         BrowserUtils.wait(5);
         String doNotReply =driver.findElement(By.xpath("//*[@class='from'][1]")).getText();
         String expectedFromTemp= " do-not-reply@practice.cybertekschool.com";
         System.out.println(doNotReply);
         Assert.assertEquals(doNotReply, expectedFromTemp, "Message is not correct" );
         BrowserUtils.wait(5);
         String thanks=driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[2]")).getText();
         System.out.println(thanks);
         String actualThanks = "Thanks for subscribing to practice.cybertekschool.com!";
         Assert.assertEquals(thanks,actualThanks, "Message is not correct");

    }




     @AfterMethod
     public void teardown(){
         driver.quit();
     }
}
