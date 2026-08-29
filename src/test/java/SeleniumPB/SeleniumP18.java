package  SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumP18 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the checkboxes")
    public void checkboxes() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        //<input type="checkbox" checked="">  checkbox 1
        //<input type="checkbox" checked="">  checkbox 2


        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void closebrowser()
    {
        if(driver !=null)
            driver.quit();
    }
}