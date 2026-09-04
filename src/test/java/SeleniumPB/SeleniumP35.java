package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP35 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify different types of exception")
    public void Exceptionscheck() {
        try {
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            WebElement searchbox = driver.findElement(By.xpath("//*[@id=\\\"ti6dpd\\\"]"));
            driver.navigate().refresh();
            Thread.sleep(3000);
            searchbox.sendKeys("The Testing Academy");
            //If we refresh,navigate to other pages, change in DOM elements(Ajax calls) we get to see staleelement exception

            WebElement rechecksearchbox = driver.findElement(By.xpath("//*[@id=\\\"ti6dpd\\\"]"));
            rechecksearchbox.sendKeys("The Testing Academy");

            // driver.switchTo().frame(1);--It throws a frameelement exception
            // driver.switchTo().alert().accept(); --It throws a alertelement exception

        } catch (StaleElementReferenceException | NoSuchElementException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}