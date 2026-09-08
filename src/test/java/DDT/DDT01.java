package DDT;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DDT01 {


    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void SetUP()
    {
     driver=new EdgeDriver();
     driver.manage().window().maximize();
     wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(dataProvider="getdata",dataProviderClass = UtilExcel.class)
    public void testuserlogin(String Email, String Password, String ExpectedResult) {
        System.out.println("------------");
        System.out.println("Email:" + Email);
        System.out.println("Password:" + Password);
        System.out.println("ExpectedResult:" + ExpectedResult);

        driver.get("https://app.vwo.com/");

        //Username
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
        username.clear();
        username.sendKeys(Email);

        //Password
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
        password.clear();
        password.sendKeys(Password);

        //Login
        driver.findElement(By.id("js-login-btn")).click();

        //Negativecase

        if (ExpectedResult.equalsIgnoreCase("Invalid")) {
            WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
            System.out.println("Actual error: " + errormessage.getText());
            Assert.assertEquals(errormessage.getText(), "Your email, password, IP address or location did not match");
            System.out.println("Negative case Passed");
        } else if (ExpectedResult.equalsIgnoreCase("Valid")) {
            WebElement loggedInUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa='lufexuloga']")));
            String Actualusername = loggedInUser.getText();
            System.out.println("LoggedinUsername " + Actualusername);
            Assert.assertEquals(Actualusername, "Vemula Abhilash");
            System.out.println("Positive case Passed");
        }
    }
        @AfterMethod
                public void teardown()
        {
            driver.quit();
        }
    }

