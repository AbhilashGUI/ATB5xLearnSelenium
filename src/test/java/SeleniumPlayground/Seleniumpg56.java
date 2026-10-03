package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg56 {

    @Test
    @Description("Verify the date picker")
    public void BasicDateInput() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input id="dp-basic-input" data-testid="dp-basic-input" class="h-9 w-fit rounded-md border border-input bg-background px-3 text-sm text-foreground shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date">
        WebElement Datepicker = driver.findElement(By.xpath("//input[@id='dp-basic-input']"));
        Datepicker.sendKeys("03-10-2026");

        String selectedDate = Datepicker.getAttribute("value");
        System.out.println("Selected date: " + selectedDate);


        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">2026-10-03</span>
        WebElement messagecheck=driver.findElement(By.id("result-s01"));
        Assert.assertEquals(messagecheck.getText(),"2026-10-03");

        driver.quit();

    }

    @Test
    @Description("Verify the different date in other browser")
    public void basicdateinput() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input id="dp-basic-input" data-testid="dp-basic-input" class="h-9 w-fit rounded-md border border-input bg-background px-3 text-sm text-foreground shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date">

        WebElement datepicker=driver.findElement(By.xpath("//input[@ id='dp-basic-input']"));
        datepicker.sendKeys("05-10-2025");

        String Selecteddate=datepicker.getAttribute("value");
        System.out.println("Selected Date: "+Selecteddate);

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">2025-10-05</span>
        WebElement messagecheck=driver.findElement(By.id("result-s01"));
        Assert.assertEquals(messagecheck.getText(),"2025-10-05");

        driver.quit();




    }


}
