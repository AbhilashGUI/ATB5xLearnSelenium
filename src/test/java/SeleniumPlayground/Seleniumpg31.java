package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg31 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void BrokenLinks()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");

        //<a target="_blank" rel="noopener noreferrer" id="link-broken-newtab" data-testid="link-broken-newtab" class="w-fit text-sm text-red-600 underline hover:text-red-800 dark:text-red-400 dark:hover:text-red-300" href="https://the-internet.herokuapp.com/status_codes/500">Broken Link — Opens in New Tab</a>

        WebElement brokenlinkinnewtab=driver.findElement(By.id("link-broken-newtab"));
        brokenlinkinnewtab.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(brokenlinkinnewtab.getText());
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verfiy the links in different browser")
    public void BrokenLinks2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");

        //<a id="link-broken-same" data-testid="link-broken-same" class="w-fit text-sm text-red-600 underline hover:text-red-800 dark:text-red-400 dark:hover:text-red-300" href="https://the-internet.herokuapp.com/status_codes/500">Broken Link — Same Tab</a>

        WebElement brokenlinksinsametab=driver.findElement(By.xpath("//a[@data-testid='link-broken-same']"));
        brokenlinksinsametab.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the link in different browser")
    public void BrokenLinks3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");

        //<a id="link-broken-empty" data-testid="link-broken-empty" class="w-fit text-sm text-red-600 underline hover:text-red-800 dark:text-red-400 dark:hover:text-red-300" href="#">Broken Link — Empty href</a>

        WebElement brokenlinkwithemptyhref=driver.findElement(By.partialLinkText("Empty href"));
        brokenlinkwithemptyhref.click();

        driver.quit();
    }
}
