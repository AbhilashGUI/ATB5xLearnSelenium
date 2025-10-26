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

import java.util.Set;

public class SeleniumP30 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Verify the multiple window handles")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String Mainwindowhandle = driver.getWindowHandle();
        System.out.println("Before click" + Mainwindowhandle);
        WebElement linktext = driver.findElement(By.linkText("Click Here"));
        linktext.click();
        Set<String> windowhandles = driver.getWindowHandles();
        //All the window tabs have unique name

        for (String handle : windowhandles) {
            driver.switchTo().window(handle);
            System.out.println(handle);
        }
        if (driver.getPageSource().contains("New Window")) ;
        {
            System.out.println("Test case passed");
        }
        driver.switchTo().window(Mainwindowhandle);
        Thread.sleep(2000);
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}

