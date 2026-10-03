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

public class Seleniumpg62 {

    @Test(priority = 2)
    @Description("Verify the Date-pickers")
    public void Datecard1()
    {

        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<button type="button" aria-label="Book Morning slot on 2025-08-12" class="mt-1 inline-flex h-8 items-center justify-center rounded-md border border-input bg-background px-3 text-xs font-medium transition-colors hover:bg-accent">Book</button>

        WebElement Morningbatch=driver.findElement(By.xpath("//button[@aria-label='Book Morning slot on 2025-08-12']"));
        Morningbatch.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Booked: Morning — 2025-08-12 09:00 – 10:00 AM</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Booked: Morning — 2025-08-12 09:00 – 10:00 AM");

        driver.quit();

    }

    @Test
    @Description("Verify the other element in different browser")
    public void Datecard2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<button type="button" aria-label="Book Afternoon slot on 2025-08-12" class="mt-1 inline-flex h-8 items-center justify-center rounded-md border border-input bg-background px-3 text-xs font-medium transition-colors hover:bg-accent">Book</button>
        WebElement Afternoonbatch=driver.findElement(By.xpath("//button[@aria-label='Book Afternoon slot on 2025-08-12']"));
        Afternoonbatch.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Booked: Afternoon — 2025-08-12 01:00 – 02:00 PM</span>
        WebElement messagecheck=driver.findElement(By.id("result-s07"));
        Assert.assertEquals(messagecheck.getText(),"Booked: Afternoon — 2025-08-12 01:00 – 02:00 PM");

        driver.quit();

    }

    @Test(priority = 1)
    @Description("Verify the other element in differnt browser")
    public void Datecard3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<button type="button" aria-label="Book Evening slot on 2025-08-12" class="mt-1 inline-flex h-8 items-center justify-center rounded-md border border-input bg-background px-3 text-xs font-medium transition-colors hover:bg-accent">Book</button>

        WebElement Eveningbatch=driver.findElement(By.xpath("//button[@aria-label='Book Evening slot on 2025-08-12']"));
        Eveningbatch.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Booked: Evening — 2025-08-12 05:00 – 06:00 PM</span>
        WebElement messagecheck=driver.findElement(By.id("result-s07"));
        Assert.assertEquals(messagecheck.getText(),"Booked: Evening — 2025-08-12 05:00 – 06:00 PM");

        driver.quit();

    }
}
