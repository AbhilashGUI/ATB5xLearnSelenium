package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg90 {

    @Test
    @Description("Verify the Table and Window")
    public void AssertNewTabUrlAndTitle()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Mainwindow=driver.getWindowHandle();


        //<a id="tw-assert-tab-btn" data-testid="tw-assert-tab-btn" href="/" target="_blank" rel="noopener noreferrer" data-expected-url-contains="qaplayground" data-expected-title-contains="QA" class="inline-flex h-8 w-fit items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open &amp; Assert URL + Title</a>
        WebElement openurlbutton=driver.findElement(By.id("tw-assert-tab-btn"));
        openurlbutton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Assert.assertEquals("https://qaplayground.com/practice/tabs-windows",driver.getCurrentUrl());
        Assert.assertEquals("How to Handle Tabs and Windows in Selenium and Playwright | QA Playground",driver.getTitle());

        driver.quit();
    }
}
