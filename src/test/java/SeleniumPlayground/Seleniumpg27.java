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

public class Seleniumpg27 {

    @Test(groups = "QA")
    @Description("Verify the radioboxes and checkboxes")
    public void Scopedcardcontrols()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");


        //<input type="radio" class="h-4 w-4 accent-primary" aria-label="Select Starter plan" name="plan-card-radio" value="starter">

        WebElement radiobox1=driver.findElement(By.xpath("//input[@name='plan-card-radio' and @value='starter']"));
        radiobox1.click();

        Assert.assertTrue(radiobox1.isSelected(),"Starter plan radio button should be enabled");

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected plan: starter</span>
        WebElement messagecheck=driver.findElement(By.id("result-s07"));
        Assert.assertEquals(messagecheck.getText(),"Selected plan: starter");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the other element in different browser")
    public void Scopedcardcontrols2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input type="radio" class="h-4 w-4 accent-primary" aria-label="Select Pro plan" name="plan-card-radio" value="pro">

        WebElement radiobox2=driver.findElement(By.xpath("//input[@name='plan-card-radio' and @value='pro']"));
        radiobox2.click();

        Assert.assertTrue(radiobox2.isSelected(),"Pro plan radio button should be enabled");

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected plan: pro</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Selected plan: pro");
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the other element in different browser")
    public void Scopedcontrols3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input type="radio" class="h-4 w-4 accent-primary" aria-label="Select Enterprise plan" name="plan-card-radio" value="enterprise">

        WebElement radiobox3= driver.findElement(By.xpath("//input[@name='plan-card-radio' and @value='enterprise']"));
        radiobox3.click();

        Assert.assertTrue(radiobox3.isSelected(),"Enterprise plan should be enabled");

 //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected plan: enterprise</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Selected plan: enterprise");
        driver.quit();
    }
}
