package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg29 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void InternalFollowingLinks()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");

        //<a id="link-internal-home" data-testid="link-internal-home" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="/">Home</a>
        WebElement link1=driver.findElement(By.id("link-internal-home"));
        link1.click();

        driver.navigate().back();

        //<a id="link-internal-about" data-testid="link-internal-about" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="/about-us">About Us</a>
        WebElement link2= driver.findElement(By.id("link-internal-about"));
        link2.click();
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void internalfollowinglinks()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");


        //<a id="link-internal-home" data-testid="link-internal-home" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="/">Home</a>

        WebElement link1=driver.findElement(By.linkText("Home"));
        link1.click();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        //<a id="link-internal-about" data-testid="link-internal-about" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="/about-us">About Us</a>

         WebElement  link2=driver.findElement(By.linkText("About Us"));
         link2.click();
         System.out.println(driver.getCurrentUrl());
         driver.quit();

    }
}
