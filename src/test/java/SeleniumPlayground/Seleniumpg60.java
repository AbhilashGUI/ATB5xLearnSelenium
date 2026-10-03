package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg60 {

    @Test
    @Description("Verify the Date-pickers")
    public void EnabledDatescheck()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();


   //<input id="dp-constrained-input" data-testid="dp-constrained-input" min="2025-06-01" max="2025-12-31" data-min="2025-06-01" data-max="2025-12-31" class="h-9 w-fit rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date">
        WebElement Datefield=driver.findElement(By.id("dp-constrained-input"));
        Datefield.sendKeys("30-06-2025");
        Assert.assertEquals("2025-06-30",Datefield.getAttribute("value"));
        Datefield.clear();

        Datefield.sendKeys("31-12-2025");
        Assert.assertEquals("2025-12-31",Datefield.getAttribute("value"));

        driver.quit();

    }

    @Test
    @Description("Verify the Date-pickers")
    public void DisabledDatescheck() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input id="dp-constrained-input" data-testid="dp-constrained-input" min="2025-06-01" max="2025-12-31" data-min="2025-06-01" data-max="2025-12-31" class="h-9 w-fit rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date">

        WebElement Datefield=driver.findElement(By.id("dp-constrained-input"));
        Datefield.sendKeys("30-05-2025");
        Assert.assertEquals("2025-05-30",Datefield.getAttribute("value"));
        Datefield.clear();

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Invalid: 2025-05-30 is out of range</span>

        WebElement messagecheck=driver.findElement(By.id("result-s05"));
        Assert.assertEquals(messagecheck.getText(),"Invalid: 2025-05-30 is out of range");

        Thread.sleep(2000);

        Datefield.sendKeys("01-01-2026");
        Assert.assertEquals("2026-01-01",Datefield.getAttribute("value"));

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Invalid: 2026-01-01 is out of range</span>
        WebElement messagecheck2=driver.findElement(By.id("result-s05"));
        Assert.assertEquals(messagecheck2.getText(),"Invalid: 2026-01-01 is out of range");

        Thread.sleep(2000);

        driver.quit();





    }



}
