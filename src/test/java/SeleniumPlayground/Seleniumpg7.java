package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg7 {

    @Test(groups = "QA")
    @Description("Verify the button automation practice")
    public void NavigateToHomePage() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

            //<button id="navigateHomeBtn" data-testid="btn-navigate-home" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnPrimary">Go To Home</button>

        Thread.sleep(2000);
        WebElement buttoncheck= driver.findElement(By.id("navigateHomeBtn"));
        buttoncheck.click();
//<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Navigated to Home Page</span>

        WebElement successcheck= driver.findElement(By.id("result-s01"));
        Assert.assertTrue(successcheck.isDisplayed());
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void navigatetohomepage() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

        Thread.sleep(2000);
        //<button id="navigateHomeBtn" data-testid="btn-navigate-home" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnPrimary">Go To Home</button>

        WebElement buttoncheck= driver.findElement(By.xpath("//button[@id='navigateHomeBtn']"));
        buttoncheck.click();
//<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Navigated to Home Page</span>

        WebElement successcheck= driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertTrue(successcheck.isDisplayed());
        driver.quit();
    }


    }

