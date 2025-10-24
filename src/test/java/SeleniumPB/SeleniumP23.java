package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP23 {


    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Verify the shadowdom concept")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

//Javascriptcode: document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")
        WebElement divscrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);", divscrollTo);

        Thread.sleep(3000);

        WebElement inputboxpizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputboxpizza.sendKeys("Farmhouse");

        Thread.sleep(10000);
    }


    @AfterTest
    public void closebrowser() {
        driver.quit();
    }
}