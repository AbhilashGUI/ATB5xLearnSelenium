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
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new EdgeDriver();
    }

    @Test(groups = "QA")
    @Description("Verify Action items via click events")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstnamefield= driver.findElement(By.name("firstname"));

        Actions actions= new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstnamefield,"thetestingacademy")
                .keyUp(Keys.SHIFT).build().perform();

        WebElement link= driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]"));
        actions.contextClick(link).build().perform();
        Thread.sleep(10000);
    }
    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}
