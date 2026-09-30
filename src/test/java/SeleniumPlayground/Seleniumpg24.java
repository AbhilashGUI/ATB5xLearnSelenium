package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg24 {

    @Test(groups = "QA")
    @Description("Verify the checboxes assertion")
    public void AssertChecked()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

      //<input type="checkbox" id="chk-newsletter" data-testid="chk-newsletter" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" name="newsletter" checked="">

        WebElement checkassert=driver.findElement(By.id("chk-newsletter"));
        Assert.assertTrue(checkassert.isSelected(),"Check box should be selected initially");

        driver.quit();

    }


    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void AssertUnchecked()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input type="checkbox" id="chk-newsletter" data-testid="chk-newsletter" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" name="newsletter" checked="">

          WebElement uncheckassert=driver.findElement(By.xpath("//input[@id='chk-newsletter']"));
          uncheckassert.click();
          Assert.assertFalse(uncheckassert.isSelected(),"Checkbox should be unchecked after clicking");
          driver.quit();
    }
}
