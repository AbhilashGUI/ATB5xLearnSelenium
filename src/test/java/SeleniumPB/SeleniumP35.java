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
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver();
    }

    @Test(groups = "QA")
    @Description("Verify the differenttypes of exceptions in selenium")
    public void positivecase() {
        try{
        driver.manage().window().maximize();
        driver.get("https://google.com");

        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        driver.navigate().refresh();
        searchbox.sendKeys("The Testing Academy");
        //If we refresh,navigate to other pages, change in DOM elements(Ajax calls) we get to see staleelement exception

        WebElement searchbox_recheck = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchbox_recheck.sendKeys("The Testing Academy");


        // driver.switchTo().frame(1);--It throws a frameelement exception
        // driver.switchTo().alert().accept(); --It throws a alertelement exception

    } catch (StaleElementReferenceException | NoSuchElementException ex) {
        ex.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    }


}


@AfterTest
public void closeBrowser() {
    driver.quit();
}
}








