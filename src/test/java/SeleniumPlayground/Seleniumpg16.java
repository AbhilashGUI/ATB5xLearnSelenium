package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg16 {

    @Test(groups="QA")
    @Description("Verify the dropdown automation practice")
    public void SelectCountryByValueAttribute()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

        //<select id="countrySelect" name="country" data-testid="country-select" data-locator-level="beginner" class="dropdowns-module__P6SCTq__practiceSelect"><option value="">Select Country</option><option value="argentina">Argentina</option><option value="india">India</option><option value="japan">Japan</option><option value="united-states">United States</option></select>

    Select selectcountry=new Select(driver.findElement(By.id("countrySelect")));
    selectcountry.selectByValue("india");
    Assert.assertEquals("India",selectcountry.getFirstSelectedOption().getText());

    //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected country: India (india)</span>

        WebElement messagecheck=driver.findElement(By.id("result-s02"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();
    }


    @Test(groups = "QA")
    @Description("Verify the  same in other browser")
    public void selectcountrybyvalueattribute()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

        //<select id="countrySelect" name="country" data-testid="country-select" data-locator-level="beginner" class="dropdowns-module__P6SCTq__practiceSelect"><option value="">Select Country</option><option value="argentina">Argentina</option><option value="india">India</option><option value="japan">Japan</option><option value="united-states">United States</option></select>

        Select selectcountry=new Select(driver.findElement(By.xpath("//select[@id='countrySelect']")));
        selectcountry.selectByValue("argentina");
        Assert.assertEquals("Argentina",selectcountry.getFirstSelectedOption().getText());

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected country: India (india)</span>

        WebElement messagecheck= driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();
    }

}
