package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumP2 {

    @Test(groups = "QA")
    @Description("Verify the negative scenario")
    public void Testvwologin2() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement Emailfieldbox = driver.findElement(By.name("username"));
        Emailfieldbox.sendKeys("vemulaabhilash");

        WebElement passwordfieldbox = driver.findElement(By.id("login-password"));
        passwordfieldbox.sendKeys("VAS1933@hyd");



        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>
        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa=error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();

    }
}