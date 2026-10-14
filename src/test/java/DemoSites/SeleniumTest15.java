package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest15 {

    @Test(priority = 1)
    @Description("Verify with incorrect credentials")
    public void incorrectcred()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        WebElement login=driver.findElement(By.xpath("//a [@href='/login']"));
        login.click();
//
        WebElement Emailaddress=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        Emailaddress.sendKeys("vemulaabhilash07@gmail.com");

        WebElement Password=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        Password.sendKeys("Testcheck123");

        WebElement loginbutton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginbutton.click();

        WebElement errorcheck=driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
        System.out.println(errorcheck.getText());
        Assert.assertEquals(errorcheck.getText(),"Your email or password is incorrect!");
        driver.quit();
    }

    @Test
    @Description("Verify registration with existing email")
    public void resuseofemail()
    {
     WebDriver driver=new EdgeDriver();
     driver.get("https://automationexercise.com/");
     driver.manage().window().maximize();


     WebElement signup=driver.findElement(By.xpath("//a[@href='/login'] "));
     signup.click();

     WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
     name.sendKeys("Abhilash");

     WebElement emailaddress=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
     emailaddress.sendKeys("vemulaabhilash7@gmail.com");

     WebElement signupbutton=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
     signupbutton.click();

     WebElement errorcheck=driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));
     System.out.println(errorcheck.getText());
     Assert.assertEquals(errorcheck.getText(),"Email Address already exist!");
     driver.quit();
    }


    }



