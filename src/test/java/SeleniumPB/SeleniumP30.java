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
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the window handles")
    public void windowhandlescheck() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        String Mainwindowhandle= driver.getWindowHandle();
        System.out.println("Before click "+Mainwindowhandle);
        //<a href="/windows/new" ,="" target="_blank">Click Here</a>
        WebElement linktext= driver.findElement(By.linkText("Click Here"));
        linktext.click();
        Thread.sleep(3000);
        Set<String> windowhandles=driver.getWindowHandles();

        for (String Multiplewindows:windowhandles)
        {
            driver.switchTo().window(Multiplewindows);
            System.out.println(Multiplewindows);
        }

        if (driver.getPageSource().contains("New window"))
        {
            System.out.println("Test case passed");
        }
        driver.switchTo().window(Mainwindowhandle);
        Thread.sleep(3000);
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}