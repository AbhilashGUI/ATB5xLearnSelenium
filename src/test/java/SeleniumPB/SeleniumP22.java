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

import java.time.Duration;
import java.util.List;

public class SeleniumP22 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test(groups = "QA")
    @Description("Verify via SVG elements")
    public void positivecase() {
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");


        //List<WebElement> states=driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        // // Switch to iframe containing the SVG map
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'map-container')]")));
        // // Fetch all state elements (paths with aria-label)
        List<WebElement> states = driver.findElements(
                By.xpath("//*[name()='svg']//*[name()='path' and @aria-label]"));
        for (WebElement fetchstates : states) {
            System.out.println(fetchstates.getAttribute("aria-label"));

            if (fetchstates.getAttribute("aria-label").contains("Tripura")) {
                fetchstates.click();
            }
        }
    }
      @AfterTest
            public void closebrowser() {
            driver.quit();
        }
        }


