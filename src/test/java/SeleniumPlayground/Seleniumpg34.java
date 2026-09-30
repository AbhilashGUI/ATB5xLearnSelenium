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

public class Seleniumpg34 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void Textlinksandanchor() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");

        //<a id="link-text-garbled-1" data-testid="link-text-garbled-1" class="w-fit text-sm text-blue-700 underline dark:text-blue-400" href="/">Homdf56e</a>

        WebElement Homepagelink=driver.findElement(By.partialLinkText("Hom"));
        Homepagelink.click();

        Thread.sleep(3000);
        driver.quit();

    }


    @Test(groups = "QA")
    @Description("Verify other links in different browser")
    public void Textlinksandanchor2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
//<a id="link-text-garbled-2" data-testid="link-text-garbled-2" class="w-fit text-sm text-blue-700 underline dark:text-blue-400" href="/about-us">About 32 yhs</a>

        WebElement Aboutlink = driver.findElement(By.xpath("//a[normalize-space()='About 32 yhs']"));
        String href = Aboutlink.getAttribute("href");
        System.out.println("URL--> " + href);
        Assert.assertEquals(href, "https://qaplayground.com/about-us");
        driver.quit();
    }


        @Test(groups = "QA")
        @Description("Verify the links in other browser")
        public void Textlinksandanchor3()
        {
            WebDriver driver=new FirefoxDriver();
            driver.get("https://qaplayground.com/practice/links");
            driver.manage().window().maximize();

            //<a id="link-text-anchor" data-testid="link-text-anchor" class="w-fit text-sm text-blue-700 underline dark:text-blue-400" href="#anchor-target">Links Anchor Text — Test Cases TC09</a>
     WebElement anchortext=driver.findElement(By.xpath("//a[normalize-space()='Links Anchor Text — Test Cases TC09']"));
    String testid=anchortext.getAttribute("data-testid");
    System.out.println("Test data: "+testid);
    driver.quit();
        }
}
