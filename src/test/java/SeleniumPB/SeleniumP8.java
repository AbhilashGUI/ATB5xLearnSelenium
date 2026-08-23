package  SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumP8 {


    @Test(groups = "QA")
    @Description("Verify Gmail sign-in")
    public void gmailsignin()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://workspace.google.com/intl/en-US/gmail/");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        /*<span
        class="button__content"
        >Sign in
        </span>
         */

        WebElement signinbutton= driver.findElement(By.xpath("//span[text()='Sign in']"));
        signinbutton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();


    }
}