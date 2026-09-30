package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg30 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void Externallinks() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/links");
        Assert.assertEquals(driver.getTitle(), "How to Handle Links in Selenium and Playwright | QA Playground");

        //<a target="_blank" rel="noopener noreferrer" id="link-external-selenium" data-testid="link-external-selenium" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="https://www.javatpoint.com/selenium-tutorial">Selenium Automation Notes</a>

        WebElement link1 = driver.findElement(By.partialLinkText("Selenium"));
        link1.click();
        Thread.sleep(2000);
        Assert.assertTrue(link1.isEnabled(),"Redirecting to respective page");


        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the other link in different browser")
    public void Externllink2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/links");


        //<a target="_blank" rel="noopener noreferrer" id="link-external-course" data-testid="link-external-course" class="w-fit text-sm text-blue-600 underline hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300" href="https://www.udemy.com/course/selenium-real-time-examplesinterview-questions/">Selenium Complete Course</a>

        WebElement link2= driver.findElement(By.xpath("//a[@id='link-external-course']"));
        link2.click();
        Thread.sleep(2000);

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Opened Course in new tab</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(),"Opened Course in new tab");
        driver.quit();

    }
}