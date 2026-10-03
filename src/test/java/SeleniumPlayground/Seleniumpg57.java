package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg57 {

    @Test
    @Description("Verify the Date pickers")
    public void Calenderopenandselect()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<button type="button" id="dp-calendar-trigger" data-testid="dp-calendar-trigger" aria-haspopup="dialog" aria-expanded="true" class="inline-flex h-9 w-fit items-center gap-2 rounded-md border border-input bg-background px-3 text-sm shadow-sm transition-colors hover:bg-accent"><span>📅</span><span>Pick a date</span></button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement calenderbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='dp-calendar-trigger']")));
        calenderbutton.click();

        //<button type="button" role="gridcell" data-testid="dp-day-btn" data-date="2026-10-03" aria-label="2026-10-03" aria-selected="false" class="date-picker-module__PNVq0G__calendarDay ">3</button>
        WebElement dateselect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-date='2026-10-03']")));
        dateselect.click();


        WebElement Datefromcalender= driver.findElement(By.id("dp-calendar-trigger"));
        String Selecteddate=Datefromcalender.getText();
        System.out.println("Selected Date "+ Selecteddate);

       driver.quit();

    }

    @Test
    @Description("Verify by selecting the previous month date")
    public void SelectPreviousMonthDate() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();


        //<button type="button" id="dp-calendar-trigger" data-testid="dp-calendar-trigger" aria-haspopup="dialog" aria-expanded="true" class="inline-flex h-9 w-fit items-center gap-2 rounded-md border border-input bg-background px-3 text-sm shadow-sm transition-colors hover:bg-accent"><span>📅</span><span>2026-10-03</span></button>
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement calenderbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='dp-calendar-trigger']")));
        calenderbutton.click();

        //Click previous month 3times
        for (int i = 3; i > 0; i--)

        //<button type="button" id="dp-prev-month" data-testid="dp-prev-month" aria-label="Previous month" class="date-picker-module__PNVq0G__calendarNavBtn">‹</button>
        {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement previousmonth = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='dp-prev-month'] ")));
            previousmonth.click();

        }
       //<button type="button" role="gridcell" data-testid="dp-day-btn" data-date="2026-07-28" aria-label="2026-07-28" aria-selected="true" class="date-picker-module__PNVq0G__calendarDay date-picker-module__PNVq0G__calendarDaySelected">28</button>
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement selectdate=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='dp-day-btn' and @data-date='2026-07-28']")));
        selectdate.click();

        //<button type="button" id="dp-calendar-trigger" data-testid="dp-calendar-trigger" aria-haspopup="dialog" aria-expanded="false" class="inline-flex h-9 w-fit items-center gap-2 rounded-md border border-input bg-background px-3 text-sm shadow-sm transition-colors hover:bg-accent"><span>📅</span><span>2026-07-28</span></button>
        WebElement selecteddate=driver.findElement(By.id("dp-calendar-trigger"));
        System.out.println("Selecteddate:"+selecteddate.getText());


        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected: 2026-07-28</span>
        WebElement messagecheck=driver.findElement(By.id("result-s02"));
        Assert.assertEquals(messagecheck.getText(),"Selected: 2026-07-28");

        driver.quit();





    }

}
