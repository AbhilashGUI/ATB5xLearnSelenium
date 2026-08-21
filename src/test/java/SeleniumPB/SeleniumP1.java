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
    public void vwologin()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - Wingify");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        /*<input type="email"
    class="text-input W(100%)"
    name="username"
    vwo-html-translate-attr="placeholder"
    vwo-html-translate-placeholder="login:enterEmailID"
    id="login-username"
    data-qa="hocewoqisi"
    placeholder="Enter email ID">*/


        WebElement EmailTextfield= driver.findElement(By.id("login-username"));
        EmailTextfield.sendKeys("vemulaabhilash8433@gmail.com");


       /* <input type="text"
    class="text-input W(100%) Pend(36px)"
    vwo-html-translate-attr="placeholder"
    vwo-html-translate-placeholder="login:enterPassword"
    name="password"
    id="login-password"
    data-qa="jobodapuxe"
    placeholder="Enter password"
    data-gtm-form-interact-field-id="0">*/

        WebElement PasswordTextfield= driver.findElement(By.name("password"));
        PasswordTextfield.sendKeys("VAS1933@hyd");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* <button type="submit"
     id="js-login-btn"
    class="btn btn--primary btn--inverted W(100%) Mb(24px) Mb(0):lc"
    onclick="login.login(event)"
    data-qa="sibequkica">
    <span class="icon loader D(n)"
    data-qa="zuyezasugu">
    </span>
    <span data-qa="ezazsuguuy"
    vwo-html-translate="login:signIn">
    Sign in</span> </button>*/

        WebElement signinbutton= driver.findElement(By.id("js-login-btn"));
        signinbutton.click();

        driver.quit();

    }

}