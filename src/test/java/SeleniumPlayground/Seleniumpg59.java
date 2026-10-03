package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg59
{

    @Test
    @Description("Verify the Date-pickers")
    public void DateRangePicker() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input id="dp-range-start" data-testid="dp-range-start" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" value="">
        WebElement FromDatebutton=driver.findElement(By.xpath("//input[@id='dp-range-start']"));
        FromDatebutton.sendKeys("01-10-2026");

        WebElement datefetch=driver.findElement(By.id("dp-range-start"));
        String Fromdate=datefetch.getAttribute("value");
        System.out.println(Fromdate);

        Thread.sleep(2000);

        //<input id="dp-range-end" data-testid="dp-range-end" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" value="" min="2026-10-01">

        WebElement ToDateButton=driver.findElement(By.xpath("//input[@id='dp-range-end']"));
        ToDateButton.sendKeys("03-10-2026");

        WebElement datefetch2=driver.findElement(By.id("dp-range-end"));
        String ToDate=datefetch2.getAttribute("value");
        System.out.println(ToDate);

        Thread.sleep(2000);

//<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Range: 2026-10-01 → 2026-10-03</span>
        WebElement messagecheck=driver.findElement(By.id("result-s04"));
        Assert.assertEquals(messagecheck.getText(),"Range: 2026-10-01 → 2026-10-03");



        driver.quit();


    }

    @Test
    @Description("Verify From and to dates")
    public void fromandtodates() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input id="dp-range-start" data-testid="dp-range-start" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" value="">

        WebElement Todate=driver.findElement(By.xpath("//input[@id='dp-range-start']"));
        Todate.sendKeys("01-09-2026");

        Thread.sleep(2000);

        //<input id="dp-range-end" data-testid="dp-range-end" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" value="" min="2026-10-01">

        WebElement Fromdate=driver.findElement(By.xpath("//input[@id='dp-range-end']"));
        Fromdate.sendKeys("03-11-2026");

        Thread.sleep(2000);



//<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Range: 2026-09-01 → 2026-11-03</span>

        WebElement messagecheck=driver.findElement(By.id("result-s04"));
        Assert.assertEquals(messagecheck.getText(),"Range: 2026-09-01 → 2026-11-03");

        driver.quit();



    }



}
