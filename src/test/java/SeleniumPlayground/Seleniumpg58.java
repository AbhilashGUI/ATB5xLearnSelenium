package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg58 {

    @Test
    @Description("Verify the Date-pickers")
    public void MonthNavigation() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

//<button type="button" data-testid="dp-nav-next-month" aria-label="Next month" class="inline-flex h-8 w-8 items-center justify-center rounded border border-input bg-background text-sm hover:bg-accent">›</button>

        WebElement ForwardNavigation=driver.findElement(By.xpath("//button[@data-testid='dp-nav-next-month']"));
        ForwardNavigation.click();


        Thread.sleep(2000);

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Navigated to: November 2026</span>
        WebElement messagecheck= driver.findElement(By.id("result-s03"));
        Assert.assertEquals(messagecheck.getText(),"Navigated to: November 2026");



        driver.quit();

    }

    @Test
    @Description("Verify the Date-pickers")
    public void BackwardNavgation() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<button type="button" data-testid="dp-nav-prev-month" aria-label="Previous month" class="inline-flex h-8 w-8 items-center justify-center rounded border border-input bg-background text-sm hover:bg-accent">‹</button>
        WebElement backwardnavigation=driver.findElement(By.xpath("//button[@data-testid='dp-nav-prev-month']"));
        backwardnavigation.click();


        Thread.sleep(2000);

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Navigated to: September 2026</span>
        WebElement messagecheck=driver.findElement(By.id("result-s03"));
        Assert.assertEquals(messagecheck.getText(),"Navigated to: September 2026");

        driver.quit();
    }



}
