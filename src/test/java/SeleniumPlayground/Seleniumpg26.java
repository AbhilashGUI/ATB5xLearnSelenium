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

public class Seleniumpg26 {

    @Test(groups = "QA")
    @Description("Verify the Radiobuttons and checkboxes")
    public void Siblinglocatedcontrols()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("https://qaplayground.com/practice/radio-checkbox",driver.getCurrentUrl());
        Assert.assertEquals("How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground",driver.getTitle());

    //<input type="checkbox" id="notif_email_marketing" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" name="notif_email_marketing">
    //<span class="radio-checkbox-module__U2kB7W__fieldSpan">Marketing emails</span>
        WebElement checkbox1=driver.findElement(By.xpath("//span[normalize-space()='Marketing emails']/preceding-sibling::input"));
        checkbox1.click();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Marketing emails: on</span>
        WebElement messagecheck=driver.findElement(By.id("result-s06"));
        Assert.assertEquals(messagecheck.getText(),"Marketing emails: on");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the other element in different browser")
    public void Siblinglocatedcontrols2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("https://qaplayground.com/practice/radio-checkbox",driver.getCurrentUrl());
        Assert.assertEquals("How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground",driver.getTitle());

        //<input type="checkbox" id="notif_sms_alerts" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" name="notif_sms_alerts">
       //<span class="radio-checkbox-module__U2kB7W__fieldSpan">SMS alerts</span>
        WebElement checkbox2=driver.findElement(By.xpath("//span[normalize-space()='SMS alerts']/preceding-sibling::input"));
        checkbox2.click();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">SMS alerts: on</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']"));
        Assert.assertEquals(messagecheck.getText(),"SMS alerts: on");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the other element in different browser")
    public void Siblinglocatedcontrols3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("https://qaplayground.com/practice/radio-checkbox",driver.getCurrentUrl());
        Assert.assertEquals("How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground",driver.getTitle());

        //<input type="checkbox" id="notif_push_weekly" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" name="notif_push_weekly">
        //<span class="radio-checkbox-module__U2kB7W__fieldSpan">Weekly digest</span>

        WebElement checkbox3=driver.findElement(By.xpath("//span[normalize-space()='Weekly digest']/preceding-sibling::input"));
        checkbox3.click();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Weekly digest: on</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']"));
        Assert.assertEquals(messagecheck.getText(),"Weekly digest: on");
        driver.quit();



    }

}
