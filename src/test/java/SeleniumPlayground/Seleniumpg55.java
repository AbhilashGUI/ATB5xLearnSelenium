package SeleniumPlayground;

import io.qameta.allure.Description;
import org.apache.poi.xddf.usermodel.XDDFRelativeRectangle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Seleniumpg55 {

    @Test
    @Description("Verify the  Multi-select")
    public void SearchableMultiSelect()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<input id="ms-search-input" data-testid="ms-search-input" role="combobox" aria-expanded="false" aria-controls="ms-search-results" aria-label="Search frameworks" placeholder="Type to search…" class="multi-select-module__ep-fQa__searchInput" autocomplete="off" value="">
        WebElement textsearch=driver.findElement(By.xpath("//input[@id='ms-search-input']"));
        textsearch.sendKeys("React");

        WebElement reactResult = driver.findElement(By.xpath("//div[@id='ms-search-results']//div[text()='React']"));
        reactResult.click();

        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">React chosen</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"React chosen");

        driver.quit();

    }

    @Test
    @Description("Verify the other element in the different browser")
    public void SearchableMultiSelect2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<input id="ms-search-input" data-testid="ms-search-input" role="combobox" aria-expanded="false" aria-controls="ms-search-results" aria-label="Search frameworks" placeholder="Type to search…" class="multi-select-module__ep-fQa__searchInput" autocomplete="off" value="Angular">
        WebElement textsearch=driver.findElement(By.xpath("//input[@data-testid='ms-search-input']"));
        textsearch.sendKeys("Angular");

        WebElement reactResult = driver.findElement(By.xpath("//div[@id='ms-search-results']//div[text()='Angular']"));
        reactResult.click();

         //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">React chosen</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Angular chosen");

        driver.quit();

    }


    @Test
    @Description("Verify the other element in the differnt browser")
    public void SearchableMultiSelect3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<input id="ms-search-input" data-testid="ms-search-input" role="combobox" aria-expanded="false" aria-controls="ms-search-results" aria-label="Search frameworks" placeholder="Type to search…" class="multi-select-module__ep-fQa__searchInput" autocomplete="off" value="Next.js">
        WebElement textsearch=driver.findElement(By.xpath("//input[@id='ms-search-input']"));
        textsearch.sendKeys("Next.js");

        WebElement reactResult = driver.findElement(By.xpath("//div[@id='ms-search-results']//div[text()='Next.js']"));
        reactResult.click();


        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">React chosen</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Next.js chosen");

        driver.quit();

    }
}
