package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumP1 {

    @Test(groups = "QA")
    @Description("Verify the positive scenario")
    public void Testvwologin() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");



        //<input type="email"e
        // class="text-input W(100%)"
        // name="username"
        // placeholder="Enter email ID"
        // id="login-username"
        // data-qa="hocewoqisi">

        WebElement Emailidtextfield=driver.findElement(By.id("login-username"));
        Emailidtextfield.sendKeys("vemulaabhilash8433@gmail.com");

        //<input type="password" class="text-input W(100%)" placeholder="Enter password" name="password" id="login-password" data-qa="jobodapuxe" data-gtm-form-interact-field-id="0">
        WebElement Passwordtextfield= driver.findElement(By.name("password"));
        Passwordtextfield.sendKeys("VAS1933@hyd");

        try{
            Thread.sleep(3000);
        }catch (Exception e)
        {
            throw new RuntimeException();
        }
        //<button type="submit"
        // id="js-login-btn" class="btn btn--primary btn--inverted W(100%) Mb(8px) Mb(0):lc" onclick="login.login(event)"
        // data-qa="sibequkica"> <span class="icon loader hidden"
        // data-qa="zuyezasugu"></span> <span data-qa="ezazsuguuy">Sign in</span> </button>
        driver.findElement(By.id("js-login-btn")).click();

        driver.quit();
    }
}