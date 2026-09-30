package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg21 {

    @Test(groups = "QA")
    @Description("Verify the Radio buttons and checkboxes")
    public void Basiccheckboxcheck()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input id="chk-accept-terms" data-testid="chk-accept-terms" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" name="accept_terms">

        WebElement checkbox=driver.findElement(By.id("chk-accept-terms"));
        checkbox.click();

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Checked ✓</span>

        WebElement messagecheck=driver.findElement(By.id("result-s01"));
        Assert.assertEquals(messagecheck.getText(),"Checked ✓");

        driver.quit();
    }


    @Test(groups = "QA")
    @Description("Verify the same in the other browser")
    public void Basiccheckboxuncheck()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input id="chk-accept-terms" data-testid="chk-accept-terms" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" name="accept_terms">
         WebElement uncheckbox=driver.findElement(By.xpath("//input[@id='chk-accept-terms']"));

        Actions actions=new Actions(driver);
        actions.doubleClick(uncheckbox).perform();


        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Checked ✓</span>

         WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
         Assert.assertEquals(messagecheck.getText(),"Unchecked");



    }
}
