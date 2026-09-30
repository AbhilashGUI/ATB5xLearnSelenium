package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg25 {

    @Test(groups = "QA")
    @Description("Verify Radioboxes and checkboxes")
    public void  DisabledControls()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");

        //<button type="button" class="mt-1 inline-flex h-8 w-fit items-center justify-center rounded-md border border-input bg-background px-3 text-xs font-medium transition-colors hover:bg-accent">Assert disabled state</button>

        WebElement button=driver.findElement(By.xpath("//button[@type='button']"));
        Assert.assertTrue(button.isEnabled(),"Checkboxes are disabled");
        driver.quit();
    }
}
