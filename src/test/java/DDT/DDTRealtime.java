package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.time.Duration;

public class DDTRealtime {
    WebDriver driver;
            @BeforeClass
            public void setup()
    {
        driver= new EdgeDriver();
        driver.manage().window().maximize();
    }


     @Test(dataProvider = "Logincredentials")
    public void testdatadriven(String Email, String Password, String ExpectedResult)
    {
        driver.get("https://app.vwo.com/");
        WebElement emailelement= driver.findElement(By.id("login-username"));
        emailelement.clear();
        emailelement.sendKeys(Email);
        WebElement pwdelement= driver.findElement(By.id("login-password"));
        pwdelement.clear();
        pwdelement.sendKeys(Password);
        driver.findElement(By.id("js-login-btn")).click();


        if(ExpectedResult.equalsIgnoreCase("Invalid"))
        {
            WebElement errormessage= driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errormessage));
            Assert.assertTrue(errormessage.isDisplayed());
            Assert.assertEquals(errormessage.getText(),"Your email, password, IP address or location did not match");
        }

    }
    /*** @DataProvider(name="Logincredentials")
    public Object[][] testdata() {
         return new Object[][]
                 {
                         {"vemulaabhilash03@gmail.com", "Test@123", "Invalid"},
                         {"vemulaabhilash8433@gmail.com", "VAS1933@hyd", "Valid"},
                 };
     }***/

    @DataProvider(name = "Logincredentials")
    public Object[][] testDataExcel() {

        return DDTRealtimereadfromexcel
                .getTestDataFromSheet("LoginData");
    }
        @AfterClass
                public void teardown()
        {
            driver.quit();
        }

    }

