package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg22 {

    @Test(groups = "QA")
    @Description("Verify the Radio buttons and checkboxes")
    public void RadioButtonGroup()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");

        //<input id="radio-plan-starter" data-testid="radio-plan-starter" class="h-4 w-4 cursor-pointer accent-primary" type="radio" value="starter" name="plan">
        WebElement radiogroup=driver.findElement(By.id("radio-plan-starter"));
        radiogroup.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected: Starter</span>

        WebElement messagecheck=driver.findElement(By.id("result-s02"));
        Assert.assertEquals(messagecheck.getText(),"Selected: Starter");

        driver.quit();


    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void radiobuttongroup()
    {
        WebDriver driver= new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");

//<input id="radio-plan-business" data-testid="radio-plan-business" class="h-4 w-4 cursor-pointer accent-primary" type="radio" value="business" name="plan">
        WebElement buttonselection=driver.findElement(By.xpath("//input[@id='radio-plan-business']"));
        buttonselection.click();
        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected: Starter</span>

       WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s02']"));
       Assert.assertEquals(messagecheck.getText(),"Selected: Business");

       driver.quit();
    }
}
