package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumP27
{

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the keys")
    public void actionscheck() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for popup and click close button
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@class='commonModal__close'] | //span[contains(@class,'loginModal__close')] | //div[@class='loginModal displayBlock modalLogin dynHeight personal ']//span[contains(text(),'×')]")
            ));
            closePopup.click();
            System.out.println("Popup closed successfully!");
        } catch (Exception e) {
            System.out.println("Popup not displayed or already closed");
        }

        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(5000);
        System.out.println("Scrolldown check");
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}


