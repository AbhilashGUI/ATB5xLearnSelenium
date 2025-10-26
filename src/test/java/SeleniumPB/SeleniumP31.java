package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumP31 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);

    }


    @Test(groups = "QA")
    @Description("Verify the relative locators")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");
        WebElement span_element = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        //<input id="exp-0"
        // name="exp"
        // style="font-size: 14px; margin-left: 0px; margin-right: 0px; margin-top: 0px; padding: 0px; vertical-align: baseline;"
        // type="radio"
        // value="1">
        //driver.findElement(with(By.id("exp-0")).toRightOf(span_element)).click();
        driver.findElement((with(By.id("exp-2")).toRightOf(span_element))).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}
