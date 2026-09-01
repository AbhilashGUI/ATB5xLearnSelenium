package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP24 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the action items via click events")
    public void actionscheck() throws InterruptedException {
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();


        //<input name="firstname" style="-webkit-appearance: none; appearance: none; background-color: #fcfcfc; border-color: rgba(173, 176, 182, 0.3); border-radius: 0px; border-style: solid; border-width: 1px; color: #787d85; font-family: verdana, helvetica, arial, verdana, sans-serif; font-size: 13px; height: 38px; line-height: 22px; margin: 0px; outline: 0px; padding: 5px 15px; vertical-align: baseline;" type="text">
        WebElement inputtextfield = driver.findElement(By.name("firstname"));
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(inputtextfield, "Abhilash")
                .keyUp(Keys.SHIFT).build().perform();


        WebElement link = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));
        actions.contextClick(link).build().perform();
        Thread.sleep(10000);
    }
        @AfterTest
                public void closebrowser()
        {
            driver.quit();


    }
}